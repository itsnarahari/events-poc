package com.events;

import com.events.dao.EventRepository;
import com.events.entities.Events;
import com.events.exception.EventAlreadyExist;
import com.events.models.AuthResponse;
import com.events.models.EventRequest;
import com.events.models.EventResponse;
import com.events.services.EventService;
import com.events.services.impl.EventServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class EventsPocApplicationTests {

//	@Mock
//	private EventRepository eventRepository;
//	@InjectMocks
//	private EventServiceImpl eventService;
//	@Mock
//	ObjectMapper objectMapper;
//	ObjectMapper om= new ObjectMapper();
//	EventRequest eventRequest;
//	@BeforeEach
//	void setup(){
//		eventRequest=new EventRequest(234l,34l,"MyEvent", new Date(),new Date(),new Date(),new Date(),"N",new Date(),"BH21247",new Date());
//	}
//
//	@DisplayName("For save method test")
//	@Test
//	public void saveEventTest(){
////		System.out.println("babu1 "+eventRequest);
////		Events convertedEvent = om.convertValue(eventRequest, Events.class);
////		System.out.println("babu "+convertedEvent);
////		Mockito.when(eventRepository.findEventsByEventNameOrDivn(convertedEvent.getEventName(), convertedEvent.getDivn())).thenReturn(Optional.of(convertedEvent));
////		Mockito.when(eventRepository.save(convertedEvent)).thenReturn(convertedEvent);
//
////		Events events1 = eventService.saveEvent(eventRequest);
////		System.out.println(events1);
////		Assertions.assertThat(events1).isNotNull();
//
//	}
}
