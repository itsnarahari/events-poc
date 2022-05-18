package com.events;

import com.events.dao.EventRepository;
import com.events.entities.Events;
import com.events.exception.ApiException;
import com.events.exception.EventAlreadyExist;
import com.events.models.EventRequest;
import com.events.models.EventResponse;
import com.events.services.impl.EventServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class EventsPocApplicationTests {

	@Mock
	private EventRepository eventRepository;

	@Mock
	ObjectMapper objectMapper2;

	@InjectMocks
	private EventServiceImpl eventService;

	ObjectMapper objectMapper;

	EventRequest eventRequest;
	Events events;
	EventResponse eventResponse;

	@BeforeEach
	void setup(){
		objectMapper=new ObjectMapper();
		eventRequest=new EventRequest(34l,"MyEvent", new Date(),new Date(),new Date(),new Date(),"N",new Date(),"BH21247",new Date());
		events=objectMapper.convertValue(eventRequest, Events.class);
		eventResponse = objectMapper.convertValue(events, EventResponse.class);
		events.setEventId(34l);

	}

	@DisplayName("Test for save event")
	@Test
	void testSaveEvent() {
		Mockito.when(eventRepository.save(events)).thenReturn(events);
		Mockito.when(eventRepository.findEventsByEventNameOrDivn(events.getEventName(),events.getDivn())).thenReturn(Optional.empty());
		Mockito.when(objectMapper2.convertValue(eventRequest,Events.class)).thenReturn(events);
		Mockito.when(eventService.saveEvent(eventRequest)).thenReturn(eventResponse);
		EventResponse eventResponse = eventService.saveEvent(eventRequest);
		Assertions.assertThat(eventResponse).isNotNull();
	}

	@DisplayName("Test for check event already exist")
	@Test
	void testSaveEventWithEventNameCheck() {
		Mockito.when(eventRepository.findEventsByEventNameOrDivn(events.getEventName(),events.getDivn())).thenReturn(Optional.of(events));
		Mockito.when(objectMapper2.convertValue(eventRequest,Events.class)).thenReturn(events);
		EventAlreadyExist exception = assertThrows(EventAlreadyExist.class, () ->
				eventService.saveEvent(eventRequest));
		assertEquals("Duplicate record", exception.getMessage());
	}

	@DisplayName("Test for get event by id")
	@Test
	void testForGetEventById() {
		Mockito.when(eventRepository.findById(events.getEventId())).thenReturn(Optional.ofNullable(events));
		Mockito.when(objectMapper2.convertValue(events,EventResponse.class)).thenReturn(eventResponse);
		EventResponse eventResponse = eventService.getEventById(events.getEventId());
		Assertions.assertThat(eventResponse).isNotNull();
	}

	@DisplayName("Test for get event by id if event not found")
	@Test
	void testForGetEventByIdIfEventNotFound() {
		Mockito.when(eventRepository.findById(45l)).thenReturn(Optional.empty());
		ApiException exception = assertThrows(ApiException.class, () ->
				eventService.getEventById(45l));
		assertEquals("Event not found with event id "+45l, exception.getMessage());
	}

//	@DisplayName("Get All Events")
//	@Test
//	void getAllEvents() {
//		List<Events> list=new ArrayList();
//		list.add(events);
//		Mockito.when(eventRepository.findAll()).thenReturn(list);
//		Mockito.when(objectMapper2.convertValue(events,EventResponse.class)).thenReturn(eventResponse);
//		EventResponse eventResponse = eventService.getEventById(events.getEventId());
//		Assertions.assertThat(eventResponse).isNotNull();
//	}
}
