package com.custom.FreelanceProjectFinder.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void loginPageSuccess() throws Exception {
        mockMvc
                .perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void registrationPageSuccess() throws Exception {
        mockMvc
                .perform(get("/registration"))
                .andExpect(status().isOk());
    }

    @Test
    void successRegistration() throws Exception {
        mockMvc
                .perform(post("/registration")
                        .param("firstName", "Alex")
                        .param("lastName", "Jonson")
                        .param("email", "test@gmail.com")
                        .param("password", "testPassword"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void failedRegistration() throws Exception {
        MockHttpServletRequestBuilder request = post("/registration")
                .param("firstName", "Alex")
                .param("lastName", "Jonson")
                .param("email", "test@gmail.com")
                .param("password", "testPassword");
        mockMvc
                .perform(request)
                .andExpect(status().is3xxRedirection());
        mockMvc
                .perform(request)
                .andExpect(model().attribute("errorMessage", "Пошта має бути унікальною"));
    }

    @Test
    void loginSuccess() throws Exception {
        mockMvc
                .perform(post("/login")
                        .param("email", "test@gmail.com")
                        .param("password", "testPassword"))
                .andExpect(status().is3xxRedirection());
    }
    @Test
    void loginFailure() throws Exception {
        mockMvc
                .perform(post("/login")
                        .param("email", "test1@gmail.com")
                        .param("password", "testPassword"))
                .andExpect(redirectedUrl("/login?error"));
    }

    @AfterEach
    void clearDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "users");
    }
}
