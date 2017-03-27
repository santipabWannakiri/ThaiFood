package com.org.food.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.food.Model.Food;
import com.org.food.Model.Images;
import com.org.food.Repository.CustomImageRepository;
import com.org.food.Repository.ImagesReposotiry;
import com.org.food.Service.ImagesService;
@Service("ImagesServiceImp")
public class ImagesServiceImp implements ImagesService{

	@Autowired
	ImagesReposotiry imagerepo;
	
	@Autowired
	CustomImageRepository customImage;

	@Override
	public void SaveImage(Food food,String path) {
		Images  image = new Images();
		
		image.setFood(food);
		image.setPathImage(path);
		
		imagerepo.save(image);
	
	}

	@Override
	public void GetListImage(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String GetOneImage(int index) {
		return customImage.GetOneImage(index);
	}

	
	
			

}
