package com.ums.login.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoUserFoundException extends RuntimeException {
    private String errorMessage;
}