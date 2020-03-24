package com.playmates.playmates.service;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.BoardGameFiltered;
import com.playmates.playmates.model.Mechanics;
import com.playmates.playmates.model.generated.BoardGame;
import com.playmates.playmates.model.generated.GamesItem;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.repository.FilteredBoardGameRepository;
import com.playmates.playmates.repository.MechanicsRepository;
import com.playmates.playmates.util.Converter;
import com.playmates.playmates.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GameService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ApiSearchService apiSearchService;

    @Autowired
    Converter converter;

    @Autowired
    FilteredBoardGameRepository filteredBoardGameRepository;

    @Autowired
    Util util;

    @Autowired
    MechanicsRepository mechanicsRepository;

    public void addGameToFavourites(GamesItem game) {

        AppUser appUser = util.getUserFromContext();

        BoardGameFiltered boardGame = converter.getConvertedBoardGame(game);
        filteredBoardGameRepository.save(boardGame);

        Set<BoardGameFiltered> favourites = appUser.getFavouriteBoardGames();
        favourites.add(boardGame);
        appUser.setFavouriteBoardGames(favourites);
        appUserRepository.save(appUser);


    }

    public List<Mechanics> getAllMechanics() {

        return mechanicsRepository.findAll();
    }

    public BoardGame getBoardGamesByMechanics(String mechanicsId) {

       return apiSearchService.getBoardGamesByMechanics(mechanicsId);
    }
}
