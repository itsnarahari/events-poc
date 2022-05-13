package com.events.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor@RequiredArgsConstructor
public class AuthResponse {

    private boolean status;
    private String message;
}
