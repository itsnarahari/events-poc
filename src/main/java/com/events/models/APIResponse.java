package com.events.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class APIResponse<T> {

    int recordCount;
    T response;

}
