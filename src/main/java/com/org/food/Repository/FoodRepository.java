package com.org.food.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.food.Model.Food;

@Repository("FoodRepository")
public interface FoodRepository extends CrudRepository<Food,Integer> {
	
//	@Query("SELECT f from Food f WHERE f.active=?")
//	List<Food> findByActive(boolean active);
	
	 List<Food> findByActiveTrue();
	 
	 @Query("SELECT f from Food f WHERE f.id=?")
	 List<Food> findforDelelte(Integer id);
}
