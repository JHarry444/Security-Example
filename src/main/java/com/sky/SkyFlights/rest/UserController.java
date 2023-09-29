package com.sky.SkyFlights.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/getByID/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int userID) {
		User user = userService.getUserById(userID);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/user")
	public String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@GetMapping("/getUserID/{username}")
	public ResponseEntity<Integer> getUsername(@PathVariable("username") String username) {
		User user = userService.getBookingByUsername(username);

		// extract userID to return for front end
		int userID = user.getUserID();
		return new ResponseEntity<>(userID, HttpStatus.OK);
	}

}
