package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest (HelloController.class)
public class HelloControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void sayHello_noParam_rtnHelloWorld() throws Exception {
        //hello String "hello World"

        //act
        mockMvc.perform(get("/hello"))

        //assert
        .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void sayHello_myName_rtnHelloName() throws Exception {
        mockMvc.perform(get("/hello?name=Dominik"))
                .andExpect(status().isOk())
                .andExpect(content().string("<h1>hello Dominik<h1/>"));
    }
}
