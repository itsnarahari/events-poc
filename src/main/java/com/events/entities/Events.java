package com.events.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "WFM_AVAIL_EVENTS")
@AllArgsConstructor@NoArgsConstructor
public class Events {

    @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long eventId;
    @NotNull(message = "should not be null")
    @Column(name = "DIVN")
    private Long divn;
    @NotNull(message = "should not be null")
    @Column(name = "EVENTNAME")
    private String eventName;
    @NotNull(message = "should not be null")
    @Column(name = "START_DTM")
    private Date startDtm;
    @NotNull(message = "should not be null")
    @Column(name = "END_DTM")
    private Date endDtm;
    @NotNull(message = "displayStartDtm date should not be null")
    @Column(name = "DISPLAY_START_DTM")
    private Date displayStartDtm;
    @NotNull(message = "displayEndDtm date should not be null")
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

    @PrePersist
    protected void createDate(){
        createDate=new Date();
    }
    @PreUpdate
    protected void lastUpdate(){
        lastUpdate=new Date();
    }
}
