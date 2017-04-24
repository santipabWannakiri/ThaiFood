package com.org.food.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.food.Model.Food;

@Repository
public class CustomWishlistRepository {

	@PersistenceContext
	EntityManager em;

	public List<Food> GetWishlist(String u) {

		@SuppressWarnings("unchecked")
		List<Food> f = (List<Food>) em
				.createQuery(
						"SELECT f FROM Food f,User u,Wishlist w WHERE u.id=w.user AND w.food=f.id AND u.email = :user")
				.setParameter("user", u).getResultList();
		return f;
	}

	public Double tatolPrice(String u) {

		Double total = (Double) em
				.createQuery(
						"SELECT SUM(f.price) FROM Food f,User u,Wishlist w WHERE u.id=w.user AND w.food=f.id AND u.email = :user")
				.setParameter("user", u).getSingleResult();
		System.out.println("total price is = " + total);
		return total;
	}

	public Long countWishlist(String u) {

		Long amount = (Long) em
				.createQuery(
						"SELECT COUNT(f.id) FROM Food f,User u,Wishlist w WHERE u.id=w.user AND w.food=f.id AND u.email = :user")
				.setParameter("user", u).getSingleResult();

		return amount;
	}

}
