package com.events.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "WFM_AVAIL_EVENTS")
@AllArgsConstructor@NoArgsConstructor
@ToString
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EVENT_ID")
    private Long eventId;
    @Column(name = "DIVN")
    private Long divn;
    @Column(name = "EVENTNAME")
    private String eventName;
    @Column(name = "START_DTM")
    private Date startDtm;
    @Column(name = "END_DTM")
    private Date endDtm;
    @Column(name = "DISPLAY_START_DTM")
    private Date displayStartDtm;
    @Column(name = "DISPLAY_END_DTM")
    private Date displayEndDtm;
    @Column(name = "ALLOW_CHGS")
    private String allowChgs;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;
    @Column(name = "LAST_UPDATE")
    private Date lastUpdate;
}
