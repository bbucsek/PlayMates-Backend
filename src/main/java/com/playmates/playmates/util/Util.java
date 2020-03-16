package com.playmates.playmates.util;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.generated.BoardGame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Util {


    @Value("&client_id=LY2v8wNXTx")
    String CLIENT_ID;

    @Value("https://www.boardgameatlas.com/api/search?name=")
    String apiUrl;

    public String getSearchURL(String name) {

        String queryString = new StringBuilder().append(apiUrl).append(name).append(CLIENT_ID).toString();
        return queryString;

    }

    public static String getUserFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (String) authentication.getPrincipal();
    }
}
