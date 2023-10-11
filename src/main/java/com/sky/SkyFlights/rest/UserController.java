package com.sky.SkyFlights.rest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sky.SkyFlights.domain.User;
import com.sky.SkyFlights.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/register")
	public String registerUser(@RequestBody @Validated User user) {

		return this.userService.registerUser(user);
	}

	@GetMapping("/user")
	public String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
