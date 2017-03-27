package com.org.food.Service;

import com.org.food.Model.Food;
import com.org.food.Model.Images;

public interface ImagesService {
	
	public void SaveImage(Food food,String path);
	public void GetListImage(int index);
	public String GetOneImage(int index);

}
