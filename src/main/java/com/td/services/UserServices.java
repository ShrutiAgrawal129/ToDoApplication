package com.td.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.td.entities.User;
import com.td.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepo;
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public boolean checkUser(String name,String password) {
		
		Optional<User> user=userRepo.findByName(name);
		if(user.isPresent()) {
			User u=user.get();
			return name.equals(u.getName()) && password.equals(u.getPassword());
		}
		return false;
	}
	
	public User profile(String name) {
		Optional<User> user=userRepo.findByName(name);
		User u=user.get();
		if(name.equals(u.getName())) {
			return u;
		}
		else {
			return null;
		}
	}
	
	@Transactional
	public void eprofile(String name,String email) {
		userRepo.updateProfile(name, email);
	}
	
	@Transactional
	public void cpass(String name,String npass) {
		userRepo.chpass(name, npass);
	}
}
