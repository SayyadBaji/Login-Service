package com.ums.login.LoginService.controller;

import com.ums.login.LoginService.dto.User;
import com.ums.login.LoginService.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user) {
        User userObj =  loginService.login(user);
        return new ResponseEntity<>(userObj.getUserType(), HttpStatus.OK);
    }
}
