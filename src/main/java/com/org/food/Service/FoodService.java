package com.org.food.Service;

import java.nio.file.Path;
import java.util.List;

import com.org.food.Model.Food;

public interface FoodService {
	

	public void Save(Food food ,String path); 
	public void SaveEdit(Food food);
	public List<Food> findByActiveTure();
	public void Delete(Integer id);
	public Food Edit(Integer id);
}
