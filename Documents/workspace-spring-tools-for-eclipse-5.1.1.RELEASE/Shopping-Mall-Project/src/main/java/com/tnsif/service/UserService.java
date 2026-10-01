package com.tnsif.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.entity.User;
import com.tnsif.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepository;

	public User addNewUser(User user) {
		return userrepository.save(user);
	}

	public User updateUser(User user) {
		if(!userrepository.existsById(user.getId())) {
			throw new RuntimeException("user Not found");
		}
		return userrepository.save(user);
	}

	public User login(User user) {
	 User existinguser=userrepository.findByName(user.getName())
			             .orElseThrow(() -> new RuntimeException("User not found"));
		return existinguser;
	}

	public boolean logout() {
		return true;
	}

	public User deleteUser(int id) {
      User existingUser = userrepository.findById(id)
		                .orElseThrow(() ->new RuntimeException("User not found"));
           userrepository.deleteById(id);
           return existingUser;
		    }

	}
	

