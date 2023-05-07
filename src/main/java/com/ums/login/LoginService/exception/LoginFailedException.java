package com.ums.login.LoginService.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginFailedException extends RuntimeException {
    private String errorMessage;
}
