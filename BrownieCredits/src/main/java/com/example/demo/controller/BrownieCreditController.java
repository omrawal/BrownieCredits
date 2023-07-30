package com.example.demo.controller;

import com.example.demo.config.CONSTANT;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
