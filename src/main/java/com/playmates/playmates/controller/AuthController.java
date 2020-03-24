package com.playmates.playmates.controller;

import com.playmates.playmates.model.credentials.UserCredentials;
import com.playmates.playmates.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {

    @Autowired
    AuthService authservice;

    private final PasswordEncoder passwordEncoder;

    public AuthController() {

        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody UserCredentials data, HttpServletResponse response) {

        return authservice.signin(data, response);

    }

    @PostMapping("/registration")
    public void registration(@RequestBody UserCredentials data) {

        data.setPassword(passwordEncoder.encode(data.getPassword()));
        authservice.registerNewUser(data);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletResponse response) {

        return authservice.logout(response);
    }
}