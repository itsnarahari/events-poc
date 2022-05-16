package com.events.controller;

import com.events.entities.Events;
import com.events.models.EventRequest;
import com.events.models.EventResponse;
import com.events.services.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService service;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveEvents(@Valid @RequestBody EventRequest eventRequest){
        Events events = service.saveEvent(eventRequest);
        EventResponse eventResponse = objectMapper.convertValue(events, EventResponse.class);
        return ResponseEntity.ok().body(eventResponse);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllEvents(@RequestParam(required = false) Long eventId, @RequestParam(required = false) Long divn, @RequestParam(required = false) String eventName,@RequestParam(required = false) String sortBy){
        return ResponseEntity.ok().body(service.getAllEvents(eventId,divn,eventName,sortBy));
    }
}
