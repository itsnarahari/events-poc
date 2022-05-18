package com.events.dao;

import com.events.entities.Events;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Events, Long>, JpaSpecificationExecutor<Events> {

    Optional<Events> findEventsByEventNameOrDivn(String eventName, Long divn);
    Page<Events> findAll(Specification<Events> spec, Pageable pageable);

}
