package com.example.second_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class SecondServiceController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the Second Service";
	}

	@GetMapping("/check")
	public String check() {
		return "Hi, there. This is a message from Second Service";
	}
}
