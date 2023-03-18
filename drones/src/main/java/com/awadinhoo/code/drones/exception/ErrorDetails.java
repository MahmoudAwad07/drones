package com.awadinhoo.code.drones.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String errorMessage;
    private String details;
}
