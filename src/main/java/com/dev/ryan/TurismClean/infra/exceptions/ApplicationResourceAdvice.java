package com.dev.ryan.TurismClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationResourceAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public TravelError handleBusinessException(BusinessException ex){
        return new TravelError(ex.getMessage());
    }


    @ExceptionHandler(NotFoundTravelException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public TravelError handleNotFoundTravelException(NotFoundTravelException ex){
        return new TravelError(ex.getMessage());
    }
}
