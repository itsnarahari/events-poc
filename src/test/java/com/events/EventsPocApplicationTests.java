package com.events;

import com.events.dao.EventRepository;
import com.events.entities.Events;
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

import java.util.Date;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class EventsPocApplicationTests {

	@Mock
	private EventRepository eventRepository;
	@InjectMocks
	private EventServiceImpl eventService;

    @Mock
    ObjectMapper objectMapper2;
    ObjectMapper objectMapper;

	EventRequest eventRequest;
	@BeforeEach
	void setup(){
        objectMapper=new ObjectMapper();
		eventRequest=new EventRequest(234l,34l,"MyEvent", new Date(),new Date(),new Date(),new Date(),"N",new Date(),"BH21247",new Date());
	}

	@DisplayName("For save method test")
	@Test
	public void saveEventTest(){
		System.out.println("eventRequest "+eventRequest);
		Events convertedEvent = objectMapper.convertValue(eventRequest, Events.class);
		System.out.println("convertedEvent "+convertedEvent);

        Mockito.when(eventRepository.findEventsByEventNameOrDivn(convertedEvent.getEventName(), convertedEvent.getDivn())).thenReturn(Optional.of(convertedEvent));
		Mockito.when(eventRepository.save(convertedEvent)).thenReturn(convertedEvent);

		EventResponse eventResponse = eventService.saveEvent(eventRequest);
//		System.out.println(events1);
		Assertions.assertThat(eventResponse).isNotNull();

	}
}
