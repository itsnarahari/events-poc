package com.events.dao;

import com.events.entities.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Events, Long> {

    Optional<Events> findEventsByEventNameOrDivn(String eventName, Long divn);
}
