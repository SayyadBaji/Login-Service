package com.ums.login.LoginService.dto;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String userType;
}
