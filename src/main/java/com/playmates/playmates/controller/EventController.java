package com.playmates.playmates.controller;

import com.playmates.playmates.model.credentials.EventCredentials;
import com.playmates.playmates.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/events")
@CrossOrigin
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/addevent")
    public void createEvent(@RequestBody EventCredentials event) {

        eventService.addEvent(event);
    }
}
