package com.events.models;

import lombok.*;

@Setter@Getter
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private Integer code;
    private String status;
    private T data;

    public ApiResponse(String message, Integer code, String status, T data) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.data = data;
    }
}
