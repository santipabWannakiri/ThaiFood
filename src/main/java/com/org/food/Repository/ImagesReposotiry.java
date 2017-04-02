package com.org.food.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.food.Model.Images;

@Repository("ImagesRepository")
public interface ImagesReposotiry extends CrudRepository<Images, Integer>{
	
//	@Query(value = "INSERT INTO images (id, food_ID, pathImage) VALUES ('Cardinal', 'Stavanger', 'Norway')", nativeQuery = true)
//	void SaveImageCustom();
//	
}
