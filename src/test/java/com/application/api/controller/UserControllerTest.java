package com.application.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.application.api.dto.UserDTO;
import com.application.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "/scripts/sql/users/delete_all_users.sql")
public class UserControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private UserService service;

    @Before
    public void setUp() {
        System.out.println("config mockmvc");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void shouldSaveUser() throws Exception {
        String user = "{\n" + "        \"name\": \"User Test\",\n"
                + "        \"birth_date\": \"1997-11-07\",\n"
                + "        \"identifier\": \"44455182832\"\n" + "}";

        this.mockMvc
                .perform(post("/api/users/save")
                        .contentType(MediaType.APPLICATION_JSON).content(user))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetUserByIdentifier() throws Exception {
        service.save(new UserDTO("User Test", LocalDate.of(1997, 07, 07),
                "00000000000"));

        this.mockMvc
                .perform(get("/api/user/find/" + "00000000000")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("User Test"));
    }

}
