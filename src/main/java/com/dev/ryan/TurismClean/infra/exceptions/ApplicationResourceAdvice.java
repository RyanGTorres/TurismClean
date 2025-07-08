package com.dev.ryan.TurismClean.infra.exceptions;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationResourceAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateException(BusinessException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error", exception.getMessage());
        response.put("Message: ", "Por favor tente novamente e insira uma hashId valido para a viagem!");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.CONFLICT);

    }


    @ExceptionHandler(NotFoundTravelException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundTravelException(NotFoundTravelException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error", exception.getMessage());
        response.put("Message: ", "Por favor, confira se o codigo que voce digitou existe!");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);

    }
}
