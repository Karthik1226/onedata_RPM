package com.onedata.remotepatientmonitoring.controller;


import com.onedata.remotepatientmonitoring.models.tables.pojos.Users;
import com.onedata.remotepatientmonitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users) {
        return userService.createUser(users);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users users) {
        return userService.verify(users);
    }
}
