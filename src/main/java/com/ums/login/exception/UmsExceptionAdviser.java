package com.ums.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UmsExceptionAdviser {

    @ExceptionHandler(value = LoginFailedException.class)
    public ResponseEntity<String> handleLoginFailure(LoginFailedException ex) {
        return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = NoUserFoundException.class)
    public ResponseEntity<String> handleNoUserFound(NoUserFoundException ex) {
        return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.NOT_FOUND);
    }
}
