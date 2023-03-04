package com.custom.FreelanceProjectFinder.controller;

import com.custom.FreelanceProjectFinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
}
