package com.events.services.impl;

import com.events.dao.EventRepository;
import com.events.dao.EventSpecification;
import com.events.entities.Events;
import com.events.exception.ApiException;
import com.events.exception.EventAlreadyExist;
import com.events.models.EventListResponse;
import com.events.models.EventRequest;
import com.events.models.EventResponse;
import com.events.services.EventService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public EventResponse saveEvent(EventRequest eventRequest) {

        Events events = objectMapper.convertValue(eventRequest, Events.class);

        Optional<Events> eventsOptional = eventRepository.findEventsByEventNameOrDivn(events.getEventName(), events.getDivn());
        if (eventsOptional.isPresent()) {
            throw new EventAlreadyExist("Duplicate record");
        }
        if (events.getLastUpdate() == null) {
            events.setLastUpdate(events.getCreateDate());
        }
        Events savedEvents = eventRepository.save(events);
        EventResponse eventsResponse = objectMapper.convertValue(savedEvents, EventResponse.class);
        return eventsResponse;
    }

    @Override
    public EventListResponse getAllEvents(Long eventId, Long divn, String eventName, String sortBy, int offset, int size) {
        Pageable pageable = PageRequest.of(offset, size).withSort(Sort.by(Sort.Direction.ASC, sortBy));
        Page<Events> events = eventRepository.findAll(eventSpecification.getEvents(eventId, divn, eventName, sortBy), pageable);
        EventListResponse eventListResponse = objectMapper.convertValue(events, EventListResponse.class);
        return eventListResponse;
    }

    @Override
    public EventResponse getEventById(Long id) {
        Events events = eventRepository.findById(id).orElseThrow(() -> new ApiException(String.format("Event not found with event id %d", id), 404));
        return objectMapper.convertValue(events, EventResponse.class);
    }
}
