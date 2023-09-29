package com.sky.SkyFlights.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sky.SkyFlights.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String userName);

}
