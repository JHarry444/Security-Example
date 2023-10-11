package com.sky.SkyFlights.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sky.SkyFlights.domain.User;
import com.sky.SkyFlights.repos.UserRepo;

@Service
public class UserService {

	public UserRepo userRepo;

	private BCryptPasswordEncoder encoder;

	public UserService(UserRepo userRepo, BCryptPasswordEncoder encoder) {
		super();
		this.userRepo = userRepo;
		this.encoder = encoder;
	}

	public String registerUser(User user) {

		// encode password into hash in db

		user.setPassword(this.encoder.encode(user.getPassword()));
		User saved = this.userRepo.save(user);
		return saved.getUsername();
	}

	public User getUserById(int userID) {
		Optional<User> optionalUser = userRepo.findById(userID);
		return optionalUser.get();
	}

	public User getBookingByUsername(String username) {
		return userRepo.findByUsername(username).get();
	}

	public int getUserID(String username) {
		return userRepo.findByUsername(username).get().getUserID();
	}

}
