package com.example.demo.service;

import java.util.List;



import com.example.demo.entity.User;

public interface UserService {
	public void saveUser(User user);
	public List<User>getAllUser();
	public User getUserById(int id);
	public void updateUser(User user);
	public void deleteUser(User user);
	
	public User getUserByUsername(String username);
	
}

