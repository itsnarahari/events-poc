package com.events.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.util.Date;

@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResponse {

    private Long eventId;
    private Long divn;
    private String eventName;
    @JsonFormat
    private Date startDtm;
    private Date endDtm;
    @JsonDeserialize
    private Date displayStartDtm;
    private Date displayEndDtm;
    private String allowChgs;
    private Date createDate;
    private String lastUpdatedBy;
    private Date lastUpdate;

}

