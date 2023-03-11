package com.custom.FreelanceProjectFinder.controller;

import com.custom.FreelanceProjectFinder.model.dto.UserDto;
import com.custom.FreelanceProjectFinder.model.entity.User;
import com.custom.FreelanceProjectFinder.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuth", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        return "index";
    }

    @GetMapping("/registration")
    public String registrationPage(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuth", true);
        }
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(UserDto userDto, Model model) {
        try {
            userService.create(userDto.convertDtoToEntity());
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "registration";
        }
        return "redirect:/";
    }
}
