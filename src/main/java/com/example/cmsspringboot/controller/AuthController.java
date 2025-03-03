package com.example.cmsspringboot.controller;

import com.example.cmsspringboot.dto.LoginRequest;
import com.example.cmsspringboot.dto.RegisterRequest;
import com.example.cmsspringboot.model.User;
import com.example.cmsspringboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = userService.authenticate(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(token);
    }
}