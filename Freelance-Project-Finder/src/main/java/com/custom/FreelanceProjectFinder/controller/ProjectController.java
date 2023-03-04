package com.custom.FreelanceProjectFinder.controller;

import com.custom.FreelanceProjectFinder.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;
}
