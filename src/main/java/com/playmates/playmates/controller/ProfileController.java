package com.playmates.playmates.controller;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/me")
    public AppUser getUserInformation() {

        return profileService.getUserInformation();
    }
}
