package com.org.food.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.org.food.Service.WishlistService;

@Controller
public class WishlistController {

	@Autowired
	WishlistService WishService;

	@GetMapping("/wishlist")
	public ModelAndView getWishlist(){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("product", WishService.getWishlist("admin@gmail.com"));
		modelAndView.setViewName("wishlist");
		
		return modelAndView;
	}
	

	@GetMapping("save/wishlist/{id}")
	public ModelAndView saveWishlist(@PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		WishService.saveWishlist(id, user);
		
		modelAndView.setViewName("redirect:/wishlist");
		return modelAndView;
	}
	
}
