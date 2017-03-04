package com.org.food.Service;

import java.util.List;

import com.org.food.Model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public List<User> findByEmailList(String email);
	public void saveUser(User user);
}
