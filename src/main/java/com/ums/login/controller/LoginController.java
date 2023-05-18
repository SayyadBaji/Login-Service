package com.ums.login.controller;

import com.ums.login.dto.User;
import com.ums.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000")
public class LoginController {

    //@Autowired
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user) {
        User userObj =  loginService.login(user);
        return new ResponseEntity<>(userObj.getUsertype(), HttpStatus.OK);
    }

    /*@PostMapping(value = "/reset")
    public ResponseEntity<String> resetPassword(@RequestBody User user) {
        User userObj =  loginService.resetPassword(user);
        return null;
    }*/

    @GetMapping(value = "/generateUsername")
    public ResponseEntity<String> generateUsername(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String userType) {
        String userName = loginService.generateUsername(firstName, lastName, userType);
        return new ResponseEntity<>(userName, HttpStatus.OK);
    }
}
