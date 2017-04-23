package com.org.food.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.food.Model.Food;
import com.org.food.Model.User;
import com.org.food.Model.Wishlist;
import com.org.food.Repository.CustomWishlistRepository;
import com.org.food.Repository.FoodRepository;
import com.org.food.Repository.UserRepository;
import com.org.food.Repository.WishlistRepository;
import com.org.food.Service.WishlistService;

@Service
public class WishlistServiceImp implements WishlistService {

	@Autowired
	CustomWishlistRepository customwishRepo;

	@Autowired
	WishlistRepository wishRepo;

	@Autowired
	FoodRepository foodRepo;

	@Autowired
	UserRepository userRepo;

	@Override
	public List<Food> getWishlist(String u) {
		return customwishRepo.GetWishlist(u);
	}

	@Override
	public void saveWishlist(int id, String email) {
		Wishlist wish = new Wishlist();

		Food food = foodRepo.findById(id);
		User user = userRepo.findByEmail(email);

		wish.setFood(food);
		wish.setUser(user);

		wishRepo.save(wish);

	}

}
