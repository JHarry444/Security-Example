package com.sky.SkyFlights.services;

import com.sky.SkyFlights.domain.MyUserDetails;
import com.sky.SkyFlights.domain.User;
import com.sky.SkyFlights.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User found = this.repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user exists with name: " + username));
        return new MyUserDetails(found);

    }

}

