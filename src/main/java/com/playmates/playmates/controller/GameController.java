package com.playmates.playmates.controller;

import com.playmates.playmates.model.BoardGameFiltered;
import com.playmates.playmates.model.Mechanics;
import com.playmates.playmates.model.generated.BoardGame;
import com.playmates.playmates.model.generated.GamesItem;
import com.playmates.playmates.service.ApiSearchService;
import com.playmates.playmates.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping("/games")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class GameController {

    @Autowired
    ApiSearchService apiSearchService;

    @Autowired
    GameService gameService;

    @GetMapping("/search/{name}")
    public BoardGame getGameByName(@PathVariable String name) {
        return apiSearchService.getBoardGamesByName(name);
    }

    @PostMapping("/favourites/add")
    public void addGameToFavourites(@RequestBody GamesItem game) {
        gameService.addGameToFavourites(game);
    }

    @GetMapping("/mechanics")
    public List<Mechanics> getAllMechanics() {
        return gameService.getAllMechanics();
    }

    @GetMapping("/mechanics/{mechanicsId}")
    public BoardGame getBoardGamesByMechanics(@PathVariable String mechanicsId) {

        return gameService.getBoardGamesByMechanics(mechanicsId);
    }

}
