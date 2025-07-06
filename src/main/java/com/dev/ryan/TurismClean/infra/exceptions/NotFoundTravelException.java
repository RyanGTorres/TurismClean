package com.dev.ryan.TurismClean.infra.exceptions;

public class NotFoundTravelException extends RuntimeException {
    public NotFoundTravelException(String message) {
        super(message);
    }
}
