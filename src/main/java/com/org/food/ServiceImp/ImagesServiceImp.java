package com.org.food.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.food.Model.Food;
import com.org.food.Model.Images;
import com.org.food.Repository.CustomImageRepository;
import com.org.food.Repository.ImagesReposotiry;
import com.org.food.Service.ImagesService;

@Service("ImagesServiceImp")
public class ImagesServiceImp implements ImagesService {

	@Autowired
	ImagesReposotiry imagerepo;

	@Autowired
	CustomImageRepository customImage;

	@Override
	public void SaveImage(Food food, String path) {
		Images image = new Images();

		image.setFood(food);
		image.setPathImage(path);

		System.out.println("Save To DB : " + path);

		imagerepo.save(image);
	}

	@Override
	public List<Images> GetListImage(int index) {
		return customImage.GetListImage(index);
	}

}
