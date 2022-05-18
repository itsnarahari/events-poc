package com.events.services;

import com.events.models.EventListResponse;
import com.events.models.EventRequest;
import com.events.models.EventResponse;

public interface EventService {

    EventResponse saveEvent(EventRequest eventRequest);
    EventResponse getEventById(Long id);
    EventListResponse getAllEvents(Long eventId, Long divn, String eventName, String sortBy, int offset, int size);
}
