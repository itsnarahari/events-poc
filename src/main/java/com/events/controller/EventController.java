package com.events.controller;

import com.events.models.EventRequest;
import com.events.services.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventServiceImpl service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveEvents(@Valid @RequestBody EventRequest eventRequest){

        return ResponseEntity.ok().body(service.saveEvent(eventRequest));

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllEvents(){
        return ResponseEntity.ok().body(service.getAllEvents());
    }
}
