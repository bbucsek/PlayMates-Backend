package com.playmates.playmates.controller;

import com.playmates.playmates.model.generated.BoardGame;
import com.playmates.playmates.service.BoardGameService;
import com.playmates.playmates.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/games")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class GameController {

    @Autowired
    BoardGameService boardGameService;

    @GetMapping("/search/{name}")
    public BoardGame getGameByName(@PathVariable String name) {
        return boardGameService.getBoardGamesByName(name);
    }


}
