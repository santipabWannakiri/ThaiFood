package com.org.food.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.food.Model.Food;
import com.org.food.Model.SeacrFood;


@Repository("FoodRepository")
public interface FoodRepository extends CrudRepository<Food,Integer> {
	
	//nativeQuery  for use normal query SQL
	@Query(value = "SELECT f.id,f.name,f.detail,f.price,f.discount,im.pathImage FROM Food f JOIN Images im ON f.id=food_id  WHERE f.active=TRUE ORDER BY f.create_date DESC LIMIT 4",nativeQuery = true)
	 SeacrFood findByActive();
	 
	 @Query("SELECT f from Food f WHERE f.id=?")
	 List<Food> findforDelelte(Integer id);
	 
	 @Query("SELECT f from Food f WHERE f.id=?")
	 Food findById(Integer id);
}
