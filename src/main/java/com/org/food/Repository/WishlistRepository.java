package com.org.food.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.food.Model.Wishlist;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {

}
