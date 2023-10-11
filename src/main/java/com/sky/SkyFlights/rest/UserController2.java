package com.sky.SkyFlights.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sky.SkyFlights.services.UserService;

@RestController
public class UserController2 {

	private UserService userService;

	public UserController2(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
