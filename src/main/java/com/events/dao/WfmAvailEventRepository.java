package com.events.dao;

import com.events.entities.WfmAvailEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WfmAvailEventRepository extends JpaRepository<WfmAvailEvent, Long>, JpaSpecificationExecutor<WfmAvailEvent> {

}
