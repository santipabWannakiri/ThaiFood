package com.org.food.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import com.org.food.Model.User;
import com.org.food.Service.FoodService;
import com.org.food.Service.UserService;

@Controller
public class FoodController {

	String UPLOAD_FOLDER = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\ImageFood\\";
	String filename = null;

	@Autowired
	private FoodService foodservice;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ModelAndView indexShow() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("FoodList", foodservice.findByActiveTure());
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
		modelAndView.addObject("FoodList", foodservice.findByActiveTure());
		modelAndView.setViewName("listProduct");
		return modelAndView;
	}

	@PostMapping("/add")
	public ModelAndView SaveItem(@Valid Food food, @RequestParam("file") MultipartFile file,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		String paths = null;
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addItem");
		} else {
			try {

				byte[] bytes = file.getBytes();
				Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
				paths = UPLOAD_FOLDER + file.getOriginalFilename();
				Files.write(path, bytes);
				filename = "/ImageFood/" + file.getOriginalFilename();
				System.out.println("Save Image : " + paths);
			} catch (IOException e) {
				e.printStackTrace();
			}

			modelAndView.addObject("food", new Food());
			foodservice.Save(food, filename);
			modelAndView.addObject("success", "Add Item Successfully !!!");
			modelAndView.setViewName("addItem");

		}

		return modelAndView;
	}

	@GetMapping("food/delete/{id}")
	public ModelAndView DeleteItem(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		foodservice.Delete(id);
		modelAndView.setViewName("redirect:/list");

		return modelAndView;

	}

	@GetMapping("product/edit/{id}")
	public ModelAndView EditProduct(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Food food = foodservice.Edit(id);
		modelAndView.addObject("ListFoodEdit", food);
		modelAndView.setViewName("editProduct");

		return modelAndView;

	}

	@PostMapping("/SaveEdit")
	public ModelAndView SaveEdit(@Valid Food food) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(food.toString());
		foodservice.SaveEdit(food);
		System.out.println("Update ID : " + food.getId());
		modelAndView.setViewName("redirect:/list");

		return modelAndView;
	}

}