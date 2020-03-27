package com.playmates.playmates.controller;

import com.playmates.playmates.model.Event;
import com.playmates.playmates.model.EventForFrontend;
import com.playmates.playmates.model.credentials.EventCredentials;
import com.playmates.playmates.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/addevent")
    public void createEvent(@RequestBody EventCredentials event) {

        eventService.addEvent(event);
    }

    @GetMapping("my-events")
    public Set<Event> getMyEvents() {

        return eventService.getMyEvents();
    }

    @DeleteMapping("delete/{id}")
    public void deleteEvent(@PathVariable Long id) {

        eventService.deleteEventById(id);
    }

    @GetMapping("/list")
    public Set<Event> getOpenEvents() {

        return eventService.getOpenEvents();
    }

    @PutMapping("/join/{eventId}")
    public void joinEvent(@PathVariable Long eventId) {

        eventService.joinEvent(eventId);
    }

    @PutMapping("edit/{id}")
    public void editEvent(@PathVariable Long id) {

        eventService.editEvent(id);
    }

}
