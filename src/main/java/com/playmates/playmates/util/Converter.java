package com.playmates.playmates.util;

import com.playmates.playmates.model.Event;
import com.playmates.playmates.model.BoardGameFiltered;
import com.playmates.playmates.model.EventForFrontend;
import com.playmates.playmates.model.Mechanics;
import com.playmates.playmates.model.generated.GamesItem;
import com.playmates.playmates.model.generated.MechanicsItem;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.repository.MechanicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Converter {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    MechanicsRepository mechanicsRepository;

    public Set<BoardGameFiltered> getConvertedBoardGames(List<GamesItem> games) {
        Set<BoardGameFiltered> convertedGames = games.stream().map(game -> {
            BoardGameFiltered obj = BoardGameFiltered.builder()
                    .id(game.getId())
                    .name(game.getName())
                    .image(game.getImages().getMedium())
                    .mechanics(getConvertedMechanics(game.getMechanics()))
                    .build();
            return obj;
        }).collect(Collectors.toSet());
        return convertedGames;
    }

    public BoardGameFiltered getConvertedBoardGame(GamesItem game) {

        Set<Mechanics> mechanics = getConvertedMechanics(game.getMechanics());
        BoardGameFiltered boardGame = BoardGameFiltered.builder()
                .id(game.getId())
                .name(game.getName())
                .image(game.getImages().getMedium())
                .mechanics(mechanics)
                .build();
        return boardGame;
    }

    public Set<Mechanics> getConvertedMechanics(List<MechanicsItem> mechanicsItems) {
        Set<Mechanics> mechanics = mechanicsItems.stream().map(mechanicsItem -> {
            Mechanics mechanic = mechanicsRepository.findById(mechanicsItem.getId()).orElse(null);
            return mechanic;
        }).collect(Collectors.toSet());
        return mechanics;
    }
}
