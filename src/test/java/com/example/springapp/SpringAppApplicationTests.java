package com.example.springapp;

import com.example.springapp.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringAppApplicationTests {

    @Autowired
    private CountryController countryController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(countryController).isNotNull();
    }

}
