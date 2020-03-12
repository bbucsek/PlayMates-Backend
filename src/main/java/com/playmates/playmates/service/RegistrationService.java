package com.playmates.playmates.service;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.UserCredentials;
import com.playmates.playmates.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RegistrationService {

    @Autowired
    AppUserRepository appUserRepository;

    public void registerNewUser(UserCredentials user) {

        AppUser newUser = AppUser.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .roles(Arrays.asList("ROLE_USER"))
                .build();

        appUserRepository.saveAndFlush(newUser);
    }
}
