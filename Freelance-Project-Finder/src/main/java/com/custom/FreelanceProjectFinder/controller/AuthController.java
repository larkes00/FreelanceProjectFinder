package com.custom.FreelanceProjectFinder.controller;

import com.custom.FreelanceProjectFinder.model.User;
import com.custom.FreelanceProjectFinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        return "index";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user, Model model) {
        userService.create(user);
        return "redirect:/";
    }

    private static class LoginForm {
        public String email;
        public String password;
    }
}
