package com.playmates.playmates.service;

import com.playmates.playmates.model.*;
import com.playmates.playmates.model.credentials.EventCredentials;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.repository.CommentRepository;
import com.playmates.playmates.repository.EventRepository;
import com.playmates.playmates.repository.FilteredBoardGameRepository;
import com.playmates.playmates.util.Converter;
import com.playmates.playmates.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    FilteredBoardGameRepository filteredBoardGameRepository;

    @Autowired
    Converter converter;

    @Autowired
    Util util;

    @Autowired
    CommentRepository commentRepository;

    public void addEvent(EventCredentials event) {

        AppUser appUser = util.getUserFromContext();

        Set<BoardGameFiltered> games = converter.getConvertedBoardGames(event.getGames());

        saveGamesToDb(games);
        Event newEvent = Event.builder()
                .eventDate(event.getDate())
                .host(appUser)
                .memberLimit(event.getLimit())
                .games(games)
                .build();
        eventRepository.saveAndFlush(newEvent);

    }

    private void saveGamesToDb(Set<BoardGameFiltered> games) {
        for (BoardGameFiltered game : games) {
            filteredBoardGameRepository.save(game);
        }
    }

    public Set<Event> getMyEvents() {

        AppUser appUser = util.getUserFromContext();
        Set<Event> myEvents = eventRepository.findByHostId(appUser.getId());
        Set<Event> eventsParticipate = eventRepository.findByMembersContains(appUser);
        myEvents.addAll(eventsParticipate);
        return myEvents;
    }

    public void deleteEventById(Long id) {

        eventRepository.deleteById(id);
    }

    public Set<Event> getOpenEvents() {

        AppUser appUser = util.getUserFromContext();

        Set<Event> filteredEvents = eventRepository.findByHostIdIsNot(appUser.getId())
                .stream()
                .filter(event ->
                        !event.getMembers().contains(appUser))
                .collect(Collectors.toSet());

        return filteredEvents;
    }

    public void joinEvent(Long eventId) {

        AppUser appUser = util.getUserFromContext();

        Event event = eventRepository.findById(eventId).get();
        Set<AppUser> members = event.getMembers();
        members.add(appUser);
        event.setMembers(members);
        eventRepository.save(event);
    }

    public void editEvent(EventCredentials editedEvent, Long eventId) {

        Event event = eventRepository.findById(eventId).get();
        Set<BoardGameFiltered> games =  converter.getConvertedBoardGames(editedEvent.getGames());
        Set<AppUser> members = editedEvent.getMembers().stream().map(member -> {
            return appUserRepository.findById(member.getId()).get();
        }).collect(Collectors.toSet());
        saveGamesToDb(games);
        event.setMemberLimit(editedEvent.getLimit());
        event.setGames(games);
        event.setEventDate(editedEvent.getDate());
        event.setMembers(members);
        eventRepository.save(event);

    }

    public Event getEventById(Long id) {

        return eventRepository.findById(id).get();
    }

    public Event addCommentToEvent(Long eventId, String newComment) {

        AppUser user = util.getUserFromContext();
        Comment comment = Comment.builder()
                .comment(newComment)
                .author(user)
                .submitDate(java.time.LocalDateTime.now())
                .build();
        commentRepository.save(comment);
        Event event = eventRepository.findById(eventId).get();
        Set<Comment> eventComments = event.getComments();
        eventComments.add(comment);
        event.setComments(eventComments);
        eventRepository.save(event);
        return event;

    }
}
