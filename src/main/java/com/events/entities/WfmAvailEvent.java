package com.events.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "WFM_AVAIL_EVENTS")
@AllArgsConstructor@NoArgsConstructor
@ToString
public class WfmAvailEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EVENT_ID")
    private Long eventId;
    @Column(name = "DIVN")
    private Long divn;
    @Column(name = "EVENTNAME")
    private String eventName;
    @Column(name = "START_DTM")
    private Date startDate;
    @Column(name = "END_DTM")
    private Date endDate;
    @Column(name = "DISPLAY_START_DTM")
    private Date displayStartDate;
    @Column(name = "DISPLAY_END_DTM")
    private Date displayEndDate;
    @Column(name = "ALLOW_CHGS")
    private String allowChgs;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;
    @Column(name = "LAST_UPDATE")
    private Date lastUpdateDate;

    @PrePersist
    public void prePersist() {
        this.createDate = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        this.lastUpdateDate = new Date();
    }
}
