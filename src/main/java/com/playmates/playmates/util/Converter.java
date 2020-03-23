package com.playmates.playmates.util;

import com.playmates.playmates.model.Event;
import com.playmates.playmates.model.BoardGameFiltered;
import com.playmates.playmates.model.EventForFrontend;
import com.playmates.playmates.model.generated.GamesItem;
import com.playmates.playmates.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Converter {

    @Autowired
    AppUserRepository appUserRepository;

    public Set<EventForFrontend> getConvertedEvent(Set<Event> events) {

        Set<EventForFrontend> result = events.stream().map(event -> {
            EventForFrontend obj = EventForFrontend.builder()
                    .eventDate(event.getEventDate())
                    .games(event.getGames())
                    .hostName(appUserRepository.findUsernameById(event.getHostId()))
                    .memberLimit(event.getMemberLimit())
                    .id(event.getId())
                    .members(event.getMemberIds().stream().map(id -> {
                        String member = appUserRepository.findUsernameById(id);
                        return member;
                    }).collect(Collectors.toSet()))
                    .build();
            return obj;
        }).collect(Collectors.toSet());
        return result;
    }

    public Set<BoardGameFiltered> getConvertedBoardGames(List<GamesItem> games) {
        Set<BoardGameFiltered> convertedGames = games.stream().map(game -> {
            BoardGameFiltered obj = BoardGameFiltered.builder()
                    .id(game.getId())
                    .name(game.getName())
                    .build();
            return obj;
        }).collect(Collectors.toSet());
        return convertedGames;
    }
}
