package com.ums.login.LoginService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UmsExceptionAdviser {

    @ExceptionHandler(value = LoginFailedException.class)
    public ResponseEntity<String> handleLoginFailure(LoginFailedException ex) {
        return new ResponseEntity<>("Invalid Credentails", HttpStatus.FORBIDDEN);
    }
}
