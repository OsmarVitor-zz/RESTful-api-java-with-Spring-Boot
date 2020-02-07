package com.application.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.application.api.repository.UsersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    // @Autowired
    // private UserService service;

    @Autowired
    private UsersRepository repository;

    @Before
    public void setUp() {
        repository.deleteAll();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void shouldSaveUser() throws Exception {
        String user = "{    \"name\": \"User Test\",\n"
                + "        \"birth_date\": \"1997-11-07\",\n"
                + "        \"identifier\": \"44455182832\"\n" + "}";

        this.mockMvc
                .perform(post("/api/users/save").content(user)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}
