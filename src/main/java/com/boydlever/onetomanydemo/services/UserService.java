package com.boydlever.onetomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boydlever.onetomanydemo.models.User;
import com.boydlever.onetomanydemo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	//create user 
	public User createUser(User user) {
		return userRepo.save(user);
	}
	//find one user
	public User oneUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	//find all users
	public List<User> allUsers(){
		return userRepo.findAll();
	}
}
