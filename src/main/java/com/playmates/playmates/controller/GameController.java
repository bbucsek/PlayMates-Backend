package com.playmates.playmates.controller;

import com.playmates.playmates.model.generated.BoardGame;
import com.playmates.playmates.model.generated.GamesItem;
import com.playmates.playmates.service.BoardGameService;
import com.playmates.playmates.service.GameService;
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

    @Autowired
    GameService gameService;

    @GetMapping("/search/{name}")
    public BoardGame getGameByName(@PathVariable String name) {
        return boardGameService.getBoardGamesByName(name);
    }

    @PostMapping("/favourites/add")
    public void addGameToFavourites(@RequestBody GamesItem game) {
        gameService.addGameToFavourites(game);
    }


}
