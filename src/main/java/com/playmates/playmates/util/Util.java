package com.playmates.playmates.util;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Util {


    @Value("&client_id=LY2v8wNXTx")
    String CLIENT_ID;

    @Value("https://www.boardgameatlas.com/api/search?mechanics=")
    String searchByMechanicsApiUrl;

    @Value("https://www.boardgameatlas.com/api/search?name=")
    String searchByNameApiUrl;

    @Autowired
    AppUserRepository appUserRepository;

    public String getSearchByNameUrl(String name) {

        return searchByNameApiUrl + name + CLIENT_ID;

    }

    public String getSearchByMechanicsUrl(String mechanicsId) {

        return searchByMechanicsApiUrl + mechanicsId + CLIENT_ID;

    }

    public AppUser getUserFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        return appUserRepository.findByUsername(username).get();
    }
}
