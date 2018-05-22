package com.xingjiejian.spring.demo.pm.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class HelloControllerTest {

    @Test
    public void testHello() throws Exception {
        HelloController controller = new HelloController();
        //搭建MockMvc请求
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        //对"/hello"执行GET请求，
        mockMvc.perform(get("/hello"))
                //预期得到"hello1"的视图
                .andExpect(MockMvcResultMatchers.view().name("hello"));
    }

}