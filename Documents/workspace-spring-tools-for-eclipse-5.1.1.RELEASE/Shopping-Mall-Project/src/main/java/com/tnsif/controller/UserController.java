package com.tnsif.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.entity.User;
import com.tnsif.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/add")
	public User addNewUser(@RequestBody User user) {
		return userservice.addNewUser(user);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
		
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userservice.login(user);
		
	}
	
	 @PostMapping("/logout")
	    public boolean logout() {
          return userservice.logout();
	    }
	 
	  @DeleteMapping("/delete/{id}")
	    public User deleteUser(@PathVariable int id) {

	        return userservice.deleteUser(id);
	    }
	}
