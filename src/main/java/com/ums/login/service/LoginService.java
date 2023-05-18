package com.ums.login.service;

import com.ums.login.dto.User;

public interface LoginService {
    User login(User user);
    /*User resetPassword(User user);*/
    String generateUsername(String firstName, String lastName, String userType);
}
