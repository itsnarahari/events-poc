package com.events.dao;

import com.events.entities.Events;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Events, Long>, JpaSpecificationExecutor<Events> {

    Optional<Events> findEventsByEventNameOrDivn(String eventName, Long divn);
    List<Events> findAll(Specification<Events> spec);

}
