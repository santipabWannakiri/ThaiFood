package com.org.food.Service;

import java.nio.file.Path;
import java.util.List;

import com.org.food.Model.Food;
import com.org.food.Model.SeacrFood;

public interface FoodService {
	

	public void Save(Food food ); 
	public void SaveEdit(Food food);
	public SeacrFood findByActiveTure();
	public void Delete(Integer id);
	public Food Edit(Integer id);
	public Food ShowProducts(Integer id);
}
