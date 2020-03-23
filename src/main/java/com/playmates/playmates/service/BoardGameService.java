package com.playmates.playmates.service;

import com.playmates.playmates.model.generated.BoardGame;
import com.playmates.playmates.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoardGameService {

    @Autowired
    Util util;

    public BoardGame getBoardGamesByName(String name) {

        String queryString = util.getSearchURL(name);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BoardGame> boardGameResponseEntity = restTemplate.exchange(queryString, HttpMethod.GET, null, BoardGame.class);
        return boardGameResponseEntity.getBody();
    }


}
