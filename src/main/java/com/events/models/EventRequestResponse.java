package com.events.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
@ToString
public class EventRequestResponse {

    private Long eventId;
    @NotNull(message = "should not be null")
    private Long divn;
    @NotNull(message = "should not be null")
    @Size(min = 5, max = 50, message = "should be between 5 and 50 characters")
    private String eventName;
    @NotNull(message = "should not be null")
    private Date startDate;
    @NotNull(message = "should not be null")
    private Date endDate;
    @NotNull(message = "should not be null")
    private Date displayStartDate;
    @NotNull(message = "should not be null")
    private Date displayEndDate;
    private String allowChgs;
    private String lastUpdatedBy;
    private Date createDate;
    private Date lastUpdateDate;

}
