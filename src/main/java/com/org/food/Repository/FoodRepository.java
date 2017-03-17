package com.org.food.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.food.Model.Food;


@Repository("FoodRepository")
public interface FoodRepository extends CrudRepository<Food,Integer> {
	
	//nativeQuery  for use normal query SQL
	@Query(value = "SELECT * FROM Food f WHERE f.active=TRUE ORDER BY f.create_date DESC LIMIT 4",nativeQuery = true)
	 List<Food> findByActive();
	 
	 @Query("SELECT f from Food f WHERE f.id=?")
	 List<Food> findforDelelte(Integer id);
	 
	 @Query("SELECT f from Food f WHERE f.id=?")
	 Food findById(Integer id);
}
