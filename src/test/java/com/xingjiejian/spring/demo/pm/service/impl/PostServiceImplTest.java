package com.xingjiejian.spring.demo.pm.service.impl;

import com.xingjiejian.spring.demo.pm.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PostServiceImplTest {

    @Autowired
    private PostService postService;

    @Test
    public void test(){
        postService.findPosts();
    }
}