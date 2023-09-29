package com.sky.SkyFlights.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sky.SkyFlights.domain.User;
import com.sky.SkyFlights.repos.UserRepo;

@Service
public class UserServiceDB implements UserService {

	public UserRepo userRepo;

	private BCryptPasswordEncoder encoder;

	public UserServiceDB(UserRepo userRepo, BCryptPasswordEncoder encoder) {
		super();
		this.userRepo = userRepo;
		this.encoder = encoder;
	}

	@Override
	public String registerUser(User user) {

		// encode password into hash in db

		user.setPassword(this.encoder.encode(user.getPassword()));
		User saved = this.userRepo.save(user);
		return saved.getUsername();
	}

	@Override
	public User getUserById(int userID) {
		Optional<User> optionalUser = userRepo.findById(userID);
		return optionalUser.get();
	}

	@Override
	public User getBookingByUsername(String username) {
		return userRepo.findByUsername(username).get();
	}

	@Override
	public int getUserID(String username) {
		return userRepo.findByUsername(username).get().getUserID();
	}

}
