package com.awadinhoo.code.drones.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DronesCustomException extends RuntimeException {

    public DronesCustomException(String message) {
        super(message);
    }
    public DronesCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
