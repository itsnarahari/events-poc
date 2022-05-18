package com.events.services;

import com.events.models.ApiResponse;
import com.events.models.EventRequestResponse;

import java.util.List;

public interface WfmAvailEventService {

    ApiResponse<EventRequestResponse> saveEvent(EventRequestResponse eventRequest);
    EventRequestResponse getEventById(Long id);
    List<EventRequestResponse> getAllEvents();
}
