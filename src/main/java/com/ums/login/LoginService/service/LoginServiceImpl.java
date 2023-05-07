package com.ums.login.LoginService.service;

import com.ums.login.LoginService.dto.User;
import com.ums.login.LoginService.dto.UserType;
import com.ums.login.LoginService.exception.LoginFailedException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public User login(User user) {
        boolean isValid = false;
        if (user.getUsername().equals("student") && user.getPassword().equals("student")) {
            user.setUserType(UserType.STUDENT.name());
            isValid = true;
        }
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            user.setUserType(UserType.ADMIN.name());
            isValid = true;
        }
        if (user.getUsername().equals("faculty") && user.getPassword().equals("faculty")) {
            user.setUserType(UserType.FACULTY.name());
            isValid = true;
        }
        if (isValid)
            return user;
        throw new LoginFailedException("Invalid Credentils");
    }
}
