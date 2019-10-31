package com.github.artus.cicdtutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CicdTutorialApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void get_request_should_return_HelloWorld() throws Exception {
        MvcResult result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals("Hello World!", result.getResponse().getContentAsString());
    }

    @Test
    void get_request_should_return_greeting_based_on_supplied_name() throws Exception {
        MvcResult result = mockMvc.perform(post("/")
                .param("name", "John"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals("Hello John!", result.getResponse().getContentAsString());
    }
}
