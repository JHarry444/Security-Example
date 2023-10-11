package com.sky.SkyFlights.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sky.SkyFlights.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String userName);

}
