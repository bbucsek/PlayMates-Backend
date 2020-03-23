package com.playmates.playmates.service;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.BoardGameFiltered;
import com.playmates.playmates.model.generated.GamesItem;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.repository.FilteredBoardGameRepository;
import com.playmates.playmates.util.Converter;
import com.playmates.playmates.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GameService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    Converter converter;

    @Autowired
    FilteredBoardGameRepository filteredBoardGameRepository;

    public void addGameToFavourites(GamesItem game) {

        String name = Util.getUserFromContext();
        AppUser user = appUserRepository.findByUsername(name).get();

        BoardGameFiltered boardGame = converter.getConvertedBoardGame(game);
        filteredBoardGameRepository.save(boardGame);

        Set<BoardGameFiltered> favourites = user.getFavouriteBoardGames();
        favourites.add(boardGame);
        user.setFavouriteBoardGames(favourites);
        appUserRepository.save(user);


    }
}
