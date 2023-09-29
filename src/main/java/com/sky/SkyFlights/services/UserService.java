package com.sky.SkyFlights.services;

import com.sky.SkyFlights.domain.User;


public interface UserService {
    String registerUser(User user);
    User getUserById(int userId);

    User getBookingByUsername(String username);

    int getUserID(String username);
}
