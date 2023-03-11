package com.custom.FreelanceProjectFinder.controller;

import com.custom.FreelanceProjectFinder.utils.Base;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllProjects() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void createProjectPageWithNoAuthUser() throws Exception {
        mockMvc
                .perform(get("/projects/create"))
                .andExpect(redirectedUrl(Base.HTTP_PROTOCOL + Base.DOMAIN + "/login"));
    }

    @Test
    @WithMockUser
    void createProjectPageWithAuthUser() throws Exception {
        mockMvc
                .perform(get("/projects/create"))
                .andExpect(status().isOk());
    }

    @Test
    void createProjectWithNoAuthUser() throws Exception {
        mockMvc
                .perform(post("/projects/create")
                        .param("title", "test")
                        .param("openedDescription", "test")
                        .param("closedDescription", "test")
                        .param("ownerId", "1")
                        .param("status", "CREATED")
                        .param("budget", "100"))
                .andExpect(redirectedUrl(Base.HTTP_PROTOCOL + Base.DOMAIN + "/login"));
    }

    @Test
    @WithMockUser
    void createProjectWithAuthUser() throws Exception {
        mockMvc
                .perform(post("/projects/create")
                        .param("title", "test")
                        .param("openedDescription", "test")
                        .param("closedDescription", "test")
                        .param("ownerId", "1")
                        .param("status", "CREATED")
                        .param("budget", "100"))
                .andExpect(redirectedUrl("/"));
    }

    @AfterEach
    void clearDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "projects");
    }
}
