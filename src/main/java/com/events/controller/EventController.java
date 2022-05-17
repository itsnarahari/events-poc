package com.events.controller;

import com.events.models.EventRequest;
import com.events.models.EventResponse;
import com.events.services.EventService;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveEvents(@Valid @RequestBody EventRequest eventRequest){
        EventResponse eventResponse = service.saveEvent(eventRequest);
        return ResponseEntity.ok().body(eventResponse);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllEvents(@RequestParam(required = false) Long eventId, @RequestParam(required = false) Long divn, @RequestParam(required = false) String eventName,@RequestParam(required = false) String sortBy){
        return ResponseEntity.ok().body(service.getAllEvents(eventId,divn,eventName,sortBy));
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getEventById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getEventById(id));
    }
}
