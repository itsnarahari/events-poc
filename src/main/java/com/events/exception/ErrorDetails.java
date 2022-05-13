package com.events.exception;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor@NoArgsConstructor
@Setter@Getter
public class ErrorDetails {

    private Date timestamp;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private String message;
    private String uri;

}
