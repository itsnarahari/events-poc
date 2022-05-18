package com.events.controller;

import com.events.models.ApiResponse;
import com.events.models.EventRequestResponse;
import com.events.services.WfmAvailEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/event")
public class WfmAvailEventController {

    @Autowired
    WfmAvailEventService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> saveEvents(@Valid @RequestBody EventRequestResponse eventRequest) {
        ApiResponse eventResponse = service.saveEvent(eventRequest);
        return ResponseEntity.ok().body(eventResponse);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllEvents() {
        return ResponseEntity.ok().body(service.getAllEvents());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getEventById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getEventById(id));
    }
}
