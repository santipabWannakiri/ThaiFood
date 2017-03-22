package com.org.food.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.food.Model.Food;
import com.org.food.Model.Images;
import com.org.food.Repository.ImagesReposotiry;
import com.org.food.Service.ImagesService;
@Service("ImagesServiceImp")
public class ImagesServiceImp implements ImagesService{

	@Autowired
	ImagesReposotiry imagerepo;

	@Override
	public void SaveImage(Food food,String path) {
		Images  image = new Images();
		
		image.setFood(food);
		image.setPathImage(path);
		
		imagerepo.save(image);
	
	}

	
	
			

}
