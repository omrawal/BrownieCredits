package com.example.demo.controller;

import com.example.demo.config.CONSTANT;
import com.example.demo.exception.InvalidUserException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BrownieCreditController {

	@Autowired
	public UserService userService;

//	@GetMapping("/")
//	@ResponseBody
	@RequestMapping("/")
	public String homePage() {
		return "index.jsp";
	}

	/**
	 * Insert a user record
	 */
	@PostMapping("/insertUser")
	@ResponseBody
	public User addUserRecord(@RequestBody User user){
		try {
			return userService.insertUserRecord(user);
		}
		catch (UserAlreadyExistsException ex){
			return User.builder().exceptionMessage(CONSTANT.userExists).build();
		}
	}

	/**
	 * Fetch all user record
	 */
	@GetMapping("/getUsers")
	@ResponseBody
	public List<User> getUserRecord(){
		return userService.fetchAllRecords();
	}

	/**
	 * Fetch a user using userId
	 */
	@GetMapping("/getUser")
	@ResponseBody
	public Optional<User> getSingleUserRecord(String userId){
		try{
			return userService.fetchUserRecord(userId);
		}
		catch (InvalidUserException ex){
			return Optional.ofNullable(User.builder().exceptionMessage(CONSTANT.invalidUser).build());
		}
	}

	/**
	 * Delete a record
	 */
	@DeleteMapping("/deleteUser")
	@ResponseBody
	public Optional<User> deleteUserRecord(String userId){
		try{
			return userService.removeUserRecord(userId);
		}
		catch (InvalidUserException ex){
			return Optional.ofNullable(User.builder().exceptionMessage(CONSTANT.invalidUser).build());
		}
	}
}
