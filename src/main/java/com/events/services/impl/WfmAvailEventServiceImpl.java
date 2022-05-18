package com.events.services.impl;

import com.events.dao.WfmAvailEventRepository;
import com.events.entities.WfmAvailEvent;
import com.events.exception.ApiException;
import com.events.models.ApiResponse;
import com.events.models.EventRequestResponse;
import com.events.services.WfmAvailEventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class WfmAvailEventServiceImpl implements WfmAvailEventService {

    @Autowired
    WfmAvailEventRepository wfmAvailEventRepository;

    @Autowired
    ObjectMapper objectMapper;

//    @Autowired
//    EventSpecification eventSpecification;

    @Override
    @Transactional
    public ApiResponse<EventRequestResponse> saveEvent(EventRequestResponse eventRequest) {

        try{
            log.info("Event request received to save");

            // Convert DTO to Entity
            WfmAvailEvent wfmAvailEvent = objectMapper.convertValue(eventRequest, WfmAvailEvent.class);

            wfmAvailEvent.setCreateDate(new Date());
            wfmAvailEvent.setLastUpdateDate(wfmAvailEvent.getCreateDate());
            WfmAvailEvent save = wfmAvailEventRepository.save(wfmAvailEvent);

            // Convert Entity to DTO
            EventRequestResponse eventRequestResponse = objectMapper.convertValue(save, EventRequestResponse.class);

            log.info("Event saved successfully");
            return new ApiResponse<>( "Event saved successfully",200,"success", eventRequestResponse);
        }catch (Exception ex){
            log.error("Exception occurred while saving event {}", ex.getMessage());
            throw new ApiException(String.format("Exception occurred while saving event %s", ex.getMessage()), 400);
        }
    }

    @Override
    @Transactional
    public List<EventRequestResponse> getAllEvents() {

        log.info("Fetching all events");
        try{
            List<WfmAvailEvent> events = wfmAvailEventRepository.findAll();
            List<EventRequestResponse> eventListResponse = objectMapper.convertValue(events, List.class);
            return eventListResponse;
        }
        catch (Exception ex){
            log.error("Exception occurred while fetching all events {}", ex.getMessage());
            throw new ApiException(String.format("Exception occurred while fetching all events %s", ex.getMessage()), 400);
        }
    }

    @Override
    @Transactional
    public EventRequestResponse getEventById(Long id) {
        log.info("Fetching event by id {}", id);
        try{
            WfmAvailEvent wfmAvailEvent = wfmAvailEventRepository.findById(id).orElseThrow(() -> new ApiException(String.format("Event not found with event id %d", id), 404));
            return objectMapper.convertValue(wfmAvailEvent, EventRequestResponse.class);
        }catch (Exception ex){
            log.error("Exception occurred while fetching event by id {}", ex.getMessage());
            throw new ApiException(String.format("Exception occurred while fetching all events %s", ex.getMessage()), 400);
        }
    }

    //    @Override
//    public EventListResponse getAllEvents(Long eventId, Long divn, String eventName, String sortBy, int offset, int size) {
//        Pageable pageable = PageRequest.of(offset, size).withSort(Sort.by(Sort.Direction.ASC, sortBy));
//        Page<Events> events = eventRepository.findAll(eventSpecification.getEvents(eventId, divn, eventName, sortBy), pageable);
//        EventListResponse eventListResponse = objectMapper.convertValue(events, EventListResponse.class);
//        return eventListResponse;
//    }
}
