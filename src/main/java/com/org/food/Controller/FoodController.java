package com.org.food.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.org.food.Model.Food;
import com.org.food.Model.Images;
import com.org.food.Model.SeacrFood;
import com.org.food.Model.User;
import com.org.food.Repository.CustomImageRepository;
import com.org.food.Repository.CustomWishlistRepository;
import com.org.food.Repository.FoodRepository;
import com.org.food.Repository.ImagesReposotiry;
import com.org.food.Service.FoodService;
import com.org.food.Service.ImagesService;
import com.org.food.Service.UserService;
import com.org.food.Service.WishlistService;

@Controller
public class FoodController {

	String UPLOAD_FOLDER = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\ImageFood\\";
	String filename = null;

	@Autowired
	private FoodService foodService;

	@Autowired
	private ImagesService imageService;

	@Autowired
	private UserService userService;

	@Autowired
	private ImagesService imService;

	@Autowired
	private WishlistService wishlistService;

	@GetMapping("/show")
	public ModelAndView show() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("FoodList", foodService.findByActiveTure());
		modelAndView.setViewName("product");
		return modelAndView;
	}

	@GetMapping("/")
	public ModelAndView indexShow() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();

		modelAndView.addObject("FoodList", foodService.findByActiveTure());
		modelAndView.addObject("AmountWishlist", wishlistService.countWishlist(user));
		modelAndView.setViewName("index_vitamin");
		return modelAndView;
	}

	@PostMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("Uname", "Hi" + user.getName());
		modelAndView.setViewName("index_vitamin");
		return modelAndView;
	}

	@GetMapping("/add")
	public ModelAndView SaveItem() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("food", new Food());
		modelAndView.setViewName("addItem");
		return modelAndView;
	}

	@GetMapping("/list")
	public ModelAndView ListProduct() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("FoodList", foodService.findByActiveTure());
		modelAndView.setViewName("listProduct");
		return modelAndView;
	}

	@PostMapping("/add")
	public ModelAndView SaveItem(@Valid Food food, @RequestParam("file") MultipartFile[] file,
			BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		final String NoimagePath = "/ImageSystem/no-image.png";
		String paths = null;
		List<String> Checkpath = new ArrayList<String>();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addItem");
		} else {

			for (MultipartFile files : file) {
				try {
					byte[] bytes = files.getBytes();
					Path path = Paths.get(UPLOAD_FOLDER + files.getOriginalFilename());
					paths = UPLOAD_FOLDER + files.getOriginalFilename();
					Files.write(path, bytes);
					filename = "/ImageFood/" + files.getOriginalFilename();
					System.out.println("Save to DB : " + filename);
					Checkpath.add(filename);
					System.out.println("Save Image : " + paths);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// if List Image Path Empty add all picture no image
			if (Checkpath.isEmpty()) {
				for (int loop = 0; loop < 4; loop++) {
					Checkpath.add(NoimagePath);
				}
			} else if ((Checkpath.size() - 1) != 3) {
				for (int loop = Checkpath.size(); loop < 4; loop++) {
					Checkpath.add(NoimagePath);
				}
			}
			// Set Path Image for cover & save Food object
			food.setPicCover(Checkpath.get(0));
			foodService.Save(food);
			// add path image to DB
			for (int i = 0; i < Checkpath.size(); i++) {
				System.out.println("Size: " + Checkpath.size());
				System.out.println("Send From Controller : " + Checkpath.get(i));
				imageService.SaveImage(food, Checkpath.get(i));
			}
			modelAndView.addObject("food", new Food());
			modelAndView.addObject("success", "Add Item Successfully !!!");
			modelAndView.setViewName("addItem");
		}
		return modelAndView;
	}

	@GetMapping("food/delete/{id}")
	public ModelAndView DeleteItem(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		foodService.Delete(id);
		modelAndView.setViewName("redirect:/list");

		return modelAndView;

	}

	@GetMapping("product/edit/{id}")
	public ModelAndView EditProduct(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Food food = foodService.Edit(id);
		modelAndView.addObject("ListFoodEdit", food);
		modelAndView.setViewName("editProduct");

		return modelAndView;

	}

	@GetMapping("product/show/{id}")
	public ModelAndView ShowDetailProducts(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Food food = foodService.ShowProducts(id);
		modelAndView.addObject("PathImage", imService.GetListImage(id));
		modelAndView.addObject("Products", food);
		modelAndView.setViewName("product");

		return modelAndView;

	}

	@PostMapping("/SaveEdit")
	public ModelAndView SaveEdit(@Valid Food food) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(food.toString());
		foodService.SaveEdit(food);
		System.out.println("Update ID : " + food.getId());
		modelAndView.setViewName("redirect:/list");

		return modelAndView;
	}

}
