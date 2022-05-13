package com.events.services.impl;

import com.events.dao.EventRepository;
import com.events.entities.Events;
import com.events.exception.EventAlreadyExist;
import com.events.models.AuthResponse;
import com.events.models.EventRequest;
import com.events.models.EventResponse;
import com.events.services.EventService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    @Transactional
    public AuthResponse saveEvent(EventRequest eventRequest) {
        Events events = objectMapper.convertValue(eventRequest, Events.class);
        Optional<Events> eventsOptional = eventRepository.findEventsByEventNameOrDivn(events.getEventName(), events.getDivn());

        if(eventsOptional.isPresent()){
            throw new EventAlreadyExist("Duplicate record");
        }
        return new AuthResponse(true, "success");
    }

    @Override
    public List<EventResponse> getAllEvents() {
        List<Events> allEvents = eventRepository.findAll();
        List<EventResponse> list = objectMapper.convertValue(allEvents, new TypeReference<List<EventResponse>>(){});
        return list;
    }
}
