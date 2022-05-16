package com.events.services;

import com.events.entities.Events;
import com.events.models.AuthResponse;
import com.events.models.EventRequest;
import com.events.models.EventResponse;

import java.util.List;

public interface EventService {

    public Events saveEvent(EventRequest eventRequest);
    public List<EventResponse> getAllEvents(Long eventId, Long divn, String eventName, String sortBy);
}
