package com.custom.FreelanceProjectFinder.controller;

import com.custom.FreelanceProjectFinder.model.dto.ProjectDto;
import com.custom.FreelanceProjectFinder.model.entity.Project;
import com.custom.FreelanceProjectFinder.model.entity.User;
import com.custom.FreelanceProjectFinder.service.ProjectService;
import com.custom.FreelanceProjectFinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String mainPage(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuth", true);
        }
        model.addAttribute("projects", projectService.getAll());
        return "index";
    }

    @PostMapping("/projects/create")
    public String createProject(Authentication authentication, ProjectDto projectDto) {
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        projectDto.setOwnerId(userService.getByEmail(email).getUserId());
        projectService.create(projectDto.convertDtoToEntity());
        return "redirect:/";
    }

    @GetMapping("/projects/create")
    public String createProjectPage(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("isAuth", true);
        }
        return "createProject";
    }
}
