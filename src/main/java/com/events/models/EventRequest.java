package com.events.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
@ToString
public class EventRequest {

    @NotNull(message = "should not be null")
    private Long divn;
    @NotNull(message = "should not be null")
    private String eventName;
    @NotNull(message = "should not be null")
    private Date startDtm;
    @NotNull(message = "should not be null")
    private Date endDtm;
    @NotNull(message = "should not be null")
    private Date displayStartDtm;
    @NotNull(message = "should not be null")
    private Date displayEndDtm;
    private String allowChgs;
    private Date createDate;
    private String lastUpdatedBy;
    private Date lastUpdate;

}
