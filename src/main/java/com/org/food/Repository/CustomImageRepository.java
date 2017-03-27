package com.org.food.Repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.org.food.Model.Food;
import com.org.food.Model.Images;

@Repository
public class CustomImageRepository {

	@PersistenceContext
	EntityManager em;

	public void GetListImage(int index) {
		Food food = (Food) em.createQuery("SELECT DISTINCT f FROM Food f LEFT JOIN FETCH f.images WHERE f.id = :Find")
				.setParameter("Find", index).getSingleResult();

		List<Images> image = food.getImages();
		System.out.println("Now !!");
		System.out.println("ID : " + food.getId());
		System.out.println("Image : " + Arrays.toString(image.toArray()));
	}

	public String GetOneImage(int index) {

		Food food = (Food) em.createQuery("SELECT DISTINCT f FROM Food f LEFT JOIN FETCH f.images WHERE f.active = :active")
				.setParameter("active",true).setMaxResults(1).getSingleResult();
	
		List<Images> image = food.getImages();
		    Images im = image.get(0);
		    String path = im.getPathImage();
			System.out.println(im.getPathImage());
			
			
			
		return path;
	}

}
