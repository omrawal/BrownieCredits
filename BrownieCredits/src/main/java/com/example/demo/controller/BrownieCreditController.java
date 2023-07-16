package com.example.demo.controller;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return userService.insertUserRecord(user);
	}
}
