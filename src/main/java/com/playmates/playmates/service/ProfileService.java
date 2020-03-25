package com.playmates.playmates.service;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    Util util;

    @Autowired
    AppUserRepository appUserRepository;

    public AppUser getUserInformation() {

        return appUserRepository.findByUsername(util.getUserFromContext().getUsername()).get();
    }
}
