package com.org.food.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.org.food.Model.Food;

@Repository
public class CustomWishlistRepository {

	@PersistenceContext
	EntityManager em;

	public List<Food> GetWishlist(String u) {

		@SuppressWarnings("unchecked")
		List<Food> f = (List<Food>) em.createQuery("SELECT f FROM Food f,User u,Wishlist w WHERE u.id=w.user AND w.food=f.id AND u.email = :user")
				.setParameter("user", u).getResultList();
		return f;
	}

}
