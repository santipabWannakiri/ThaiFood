package com.org.food.Service;

import java.util.List;

import com.org.food.Model.Food;
import com.org.food.Model.Images;

public interface ImagesService {
	
	public void SaveImage(Food food,String path);
	public List<Images> GetListImage(int index);


}
