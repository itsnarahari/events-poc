package com.events.models;

import lombok.*;

import java.util.Date;

@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
public class EventResponse {

    private Long eventId;
    private Long divn;
    private String eventName;
    private Date startDtm;
    private Date endDtm;
    private Date displayStartDtm;
    private Date displayEndDtm;
    private String allowChgs;
    private Date createDate;
    private String lastUpdatedBy;
    private Date lastUpdate;

}

