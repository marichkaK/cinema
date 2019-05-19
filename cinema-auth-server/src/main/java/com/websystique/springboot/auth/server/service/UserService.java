package com.websystique.springboot.auth.server.service;

import com.websystique.springboot.auth.server.dto.UserDto;
import com.websystique.springboot.auth.server.model.User;
import com.websystique.springboot.auth.server.model.UserRole;
import com.websystique.springboot.auth.server.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User registerUser(UserDto userDto) {
        User user = userDto.toModel();

        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(hashedPassword);

        user.setRole(UserRole.USER);

        return userRepository.save(user);
    }
}
