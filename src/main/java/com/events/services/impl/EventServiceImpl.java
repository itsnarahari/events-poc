package com.events.services.impl;

import com.events.dao.EventRepository;
import com.events.dao.EventSpecification;
import com.events.entities.Events;
import com.events.exception.ApiException;
import com.events.exception.EventAlreadyExist;
import com.events.models.AuthResponse;
import com.events.models.EventRequest;
import com.events.models.EventResponse;
import com.events.services.EventService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    EventSpecification eventSpecification;

    @Override
    @Transactional
    public Events saveEvent(EventRequest eventRequest) {
        Events events = objectMapper.convertValue(eventRequest, Events.class);
        Optional<Events> eventsOptional = eventRepository.findEventsByEventNameOrDivn(events.getEventName(), events.getDivn());
        if (eventsOptional.isPresent()) {
            throw new EventAlreadyExist("Duplicate record");
        }
        return eventRepository.save(events);
    }

    @Override
    public List<EventResponse> getAllEvents(Long eventId, Long divn, String eventName, String sortBy) {
        List<Events> events = eventRepository.findAll(eventSpecification.getEvents(eventId, divn, eventName, sortBy));
        List<EventResponse> eventResponses = objectMapper.convertValue(events, new TypeReference<>() {
        });
        return eventResponses;
    }
}
