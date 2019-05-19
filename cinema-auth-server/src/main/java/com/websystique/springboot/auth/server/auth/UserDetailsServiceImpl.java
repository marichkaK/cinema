package com.websystique.springboot.auth.server.auth;

import com.websystique.springboot.auth.server.model.User;
import com.websystique.springboot.auth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {

        return userService.getByEmail(username)
            .map(User::toSpringUser)
            .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }
}