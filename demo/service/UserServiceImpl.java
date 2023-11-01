package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Authorities;
import com.example.demo.entity.User;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService{

//	@Autowired
	UserRepository userRepository;
	
	UserServiceImpl(UserRepository userRepository)
	{
		
		this.userRepository = userRepository;	
		
	}
	
	@Override
	public void saveUser(User user) {
	
		Authorities authority =  new Authorities();
		if(user.getRole().equals("admin")) {
			authority.setAuthority("ROLE_ADMIN");
		} else {
			authority.setAuthority("ROLE_USER");;
		}
		authority.setUsername(user.getUsername());
		authority.setUser(user);
		user.setAuthority(authority);
		
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll() ;
	}

	@Override
	public User getUserById(int id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(User user) {
		userRepository.saveAndFlush(user);
		
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
