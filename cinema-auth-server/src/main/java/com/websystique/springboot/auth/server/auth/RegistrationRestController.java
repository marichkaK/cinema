package com.websystique.springboot.auth.server.auth;

import com.websystique.springboot.auth.server.dto.UserDto;
import com.websystique.springboot.auth.server.model.User;
import com.websystique.springboot.auth.server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/register")
public class RegistrationRestController {

    private final UserService userService;

    public RegistrationRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        User user = userService.registerUser(userDto);

        return ResponseEntity.ok(user.toDto());
    }
}