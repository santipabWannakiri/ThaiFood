package com.org.food.ServiceImp;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.org.food.Model.Food;
import com.org.food.Model.User;
import com.org.food.Repository.FoodRepository;
import com.org.food.Service.FoodService;
import com.org.food.Service.UserService;

@Service("FoodService")
public class FoodServiceImp implements FoodService{
	
	@Autowired
	private FoodRepository foodrepo;

	@Autowired
	private UserService userService; 
	

	@Override
	public void Save(Food food,String path) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<User> user = userService.findByEmailList(auth.getName());
		//System.out.println("CreateBy Name: "+user.get(1)+" ID: "+user.get(0));
		
		food.setName(food.getName());
		food.setDetail(food.getDetail());
		food.setDiscount(food.getDiscount());
		food.setPrice(food.getDiscount());
		food.setPromotionCode(food.getPromotionCode());
		food.setImage(path);
		food.setCreateDate(setCreateDate());
		food.setActive(true);
		food.setReferUser(user.get(0));
		foodrepo.save(food);
		System.out.println("Save Food Successfully !!");
	}
	
	@Override
	public void SaveEdit(Food food) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<User> user = userService.findByEmailList(auth.getName());
		
		food.setName(food.getName());
		food.setDetail(food.getDetail());
		food.setDiscount(food.getDiscount());
		food.setPrice(food.getDiscount());
		food.setPromotionCode(food.getPromotionCode());
		food.setImage(food.getImage());
		food.setCreateDate(food.getCreateDate());
		food.setLastUpdate(setCreateDate());
		food.setActive(true);
		food.setReferUser(user.get(0));
		
		foodrepo.save(food);
		System.out.println("Edit Food Successfully !!");
	}


		


	@Override
	public Food ShowProducts(Integer id) {
		Food food = foodrepo.findById(id);
		return food;
	}

	@Override
	public List<Food> findByActiveTure() {
		List<Food> food = foodrepo.findByActive();
		//System.out.println(food.toString() );
		
		return food;
	}
	
	
	
	

	@Override
	public void Delete(Integer id) {
		List<Food> listFood = foodrepo.findforDelelte(id);
		for( Food food : listFood){
			food.setActive(false);
			foodrepo.save(food);
			System.out.println("ID : "+food.getId() + "Active SET : " + food.getActive() );
		}
		
	}


	


	@Override
	public Food Edit(Integer id) {
		return foodrepo.findOne(id);
	}




	public Date setCreateDate(){
		Date date = new Date();
		return date;
	}
	
}
