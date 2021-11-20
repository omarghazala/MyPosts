package com.pharos.myposts.controller;

import com.pharos.myposts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/")
public class LoginRestController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password) {
        try {
            return "Hello! "+ userService.validateUserAuthority(userName, password).getUserName();
        } catch (Exception e) {
            return "login failed !";
        }
    }
}
