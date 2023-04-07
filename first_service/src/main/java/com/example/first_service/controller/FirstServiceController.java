package com.example.first_service.controller;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstServiceController {

	Environment env;
	@Autowired
	public FirstServiceController(Environment env) {
		this.env = env;
	}
	@Value("local.server.port")
	private String port;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the First Service";
	}
	@GetMapping("/check")
	public String check(HttpServletRequest request) {
		log.info("Server port={}", request.getServerPort());

		return String.format("Hi, there. This is a message from First Service on PORT %s", env.getProperty("local.server.port"));
	}
}
