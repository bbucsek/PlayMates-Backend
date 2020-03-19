package com.playmates.playmates.service;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.Event;
import com.playmates.playmates.model.EventBoardGame;
import com.playmates.playmates.model.EventForFrontend;
import com.playmates.playmates.model.credentials.EventCredentials;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.repository.EventRepository;
import com.playmates.playmates.util.Converter;
import com.playmates.playmates.util.Util;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventService {

    Logger logger;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    Converter converter;

    public void addEvent(EventCredentials event) {
        String name = Util.getUserFromContext();
        AppUser appUser = appUserRepository.findByUsername(name).get();

        List<EventBoardGame> games = converter.getConvertedBoardGames(event.getGames());

        Event newEvent = Event.builder()
                .eventDate(event.getDate())
                .hostId(appUser.getId())
                .memberLimit(event.getLimit())
                .games(games)
                .build();
        eventRepository.saveAndFlush(newEvent);

    }

    public Set<EventForFrontend> getMyEvents() {

        String name = Util.getUserFromContext();
        AppUser user = appUserRepository.findByUsername(name).get();
        Set<Event> events = eventRepository.findByHostId(user.getId());

        return converter.getConvertedEvent(events);

    }

    public void deleteEventById(Long id) {

        eventRepository.deleteById(id);
    }

    public Set<EventForFrontend> getOpenEvents() {

        String name = Util.getUserFromContext();
        AppUser user = appUserRepository.findByUsername(name).get();

        /*Set<Event> filteredEvents = eventRepository.findAll().stream().filter(event ->
                !event.getHostId().equals(user.getId())).collect(Collectors.toSet());*/

        Set<Event> filteredEvents = eventRepository.findAll().stream().filter(event ->
                !event.getHostId().equals(user.getId()) &&
                !event.getMemberIds().contains(user.getId())
                ).collect(Collectors.toSet());

        return converter.getConvertedEvent(filteredEvents);
    }

    public void joinEvent(Long eventId) {

        String name = Util.getUserFromContext();
        AppUser user = appUserRepository.findByUsername(name).get();

        Event event = eventRepository.findById(eventId).get();
        Set<Long> members = event.getMemberIds();
        members.add(user.getId());
        event.setMemberIds(members);
        eventRepository.save(event);
    }
}
