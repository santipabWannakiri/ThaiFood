package com.org.food.Service;

import java.util.List;

import com.org.food.Model.Food;

public interface WishlistService {

	public List<Food> getWishlist(String u);

	public void saveWishlist(int id,String user);
}
