package com.events;

import com.events.dao.EventRepository;
import com.events.entities.Events;
import com.events.models.AuthResponse;
import com.events.models.EventRequest;
import com.events.models.EventResponse;
import com.events.services.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;

@SpringBootTest
class EventsPocApplicationTests {

	@Autowired
	private EventService eventService;

	@MockBean
	private EventRepository eventRepository;

	@Autowired
	ObjectMapper objectMapper;


	@Test
	void saveTest(){
		EventRequest eventRequest=new EventRequest(234l,34l,"MyEvent", new Date(),new Date(),new Date(),new Date(),"N",new Date(),"BH21247",new Date());
		Events events= objectMapper.convertValue(eventRequest,Events.class);
		Mockito.when(eventRepository.save(events)).thenReturn(events);
		Assertions.assertEquals(events,eventService.saveEvent(eventRequest));
	}

}
