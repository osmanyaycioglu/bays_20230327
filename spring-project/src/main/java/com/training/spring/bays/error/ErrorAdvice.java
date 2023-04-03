package com.training.spring.bays.error;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorDescParam(exp.getMessage())
                       .withErrorCodeParam(1045)
                       .build();
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorObj handleException(final AuthenticationException exp) {
        return ErrorObj.builder()
                       .withErrorDescParam(exp.getMessage())
                       .withErrorCodeParam(3005)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withErrorDescParam("Validation problem")
                       .withErrorCodeParam(1046)
                       .withSubErrorsParam(exp.getAllErrors()
                                              .stream()
                                              .map(se -> ErrorObj.builder()
                                                                 .withErrorDescParam(se.toString())
                                                                 .withErrorCodeParam(1050)
                                                                 .build())
                                              .collect(Collectors.toList()))
                       .build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(final Exception exp) {
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .header("err",
                                         "null pointer")
                                 .body(ErrorObj.builder()
                                               .withErrorDescParam(exp.getMessage())
                                               .withErrorCodeParam(1045)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("err",
                                     exp.getClass()
                                        .getName())
                             .body(ErrorObj.builder()
                                           .withErrorDescParam(exp.getMessage())
                                           .withErrorCodeParam(1045)
                                           .build());
    }

}
