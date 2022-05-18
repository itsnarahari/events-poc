package com.events.dao;

import com.events.entities.Events;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventSpecification {

    public Specification<Events> getEvents(Long eventId, Long divn, String eventName, String sortBy) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (eventId != null) {
                predicates.add(criteriaBuilder.equal(root.get("eventId"), eventId));
            }
            if (divn != null) {
                predicates.add(criteriaBuilder.equal(root.get("divn"), divn));
            }
            if (eventName != null && !eventName.isEmpty() && !eventName.isBlank()) {
                predicates.add(criteriaBuilder.equal(root.get("eventName"), eventName));
            }
//            query.orderBy(criteriaBuilder.desc(root.get(sortBy!=null && !sortBy.isBlank() ? sortBy : "eventName")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
