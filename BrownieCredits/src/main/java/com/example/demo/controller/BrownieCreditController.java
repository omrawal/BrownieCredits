package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController

@Controller
public class BrownieCreditController {
//	@GetMapping("/")
//	@ResponseBody
	@RequestMapping("/")
	public String homePage() {
		return "index.jsp";
	}
	
}
