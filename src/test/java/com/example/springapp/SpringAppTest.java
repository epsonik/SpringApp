package com.example.springapp;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringAppTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnHttpBadRequest() throws Exception {
        this.mockMvc.perform(get("/routing/CZE/SUR")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnContentType() throws Exception {
        this.mockMvc.perform(get("/routing/CZE/ITA")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldReturnList() throws Exception {
        this.mockMvc.perform(get("/routing/CZE/ITA")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\"route\":[\"CZE\",\"AUT\",\"ITA\"]}"));
    }
}