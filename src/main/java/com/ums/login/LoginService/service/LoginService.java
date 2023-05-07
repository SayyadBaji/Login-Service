package com.ums.login.LoginService.service;

import com.ums.login.LoginService.dto.User;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    User login(User user);
}
