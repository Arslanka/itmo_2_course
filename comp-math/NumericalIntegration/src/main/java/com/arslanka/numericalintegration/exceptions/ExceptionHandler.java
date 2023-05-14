package com.arslanka.numericalintegration.exceptions;

import com.arslanka.numericalintegration.models.dtos.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception exception) {
        Response response;
        if (exception instanceof BusinessException) {
            response = new Response(((BusinessException) exception).message());
        } else {
            response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
