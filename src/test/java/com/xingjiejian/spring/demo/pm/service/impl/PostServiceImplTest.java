package com.xingjiejian.spring.demo.pm.service.impl;

import com.xingjiejian.spring.demo.pm.entity.Post;
import com.xingjiejian.spring.demo.pm.entity.Reply;
import com.xingjiejian.spring.demo.pm.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PostServiceImplTest {

    @Autowired
    private PostService postService;


    @Test
    public void test(){
        List<Post> posts = postService.findPosts();
        assertEquals(1,posts.size());
        System.out.println(posts.get(0));
    }

    @Test
    public void test1(){
        List<Post> posts = postService.findPosts("天");
        assertEquals(1,posts.size());
        System.out.println(posts.get(0));
    }


    @Test
    public void testAddReply(){
        Reply reply = new Reply(1,"好棒啊","孙旭",null);
        postService.addReply(reply);
    }

    @Test
    public void testAddPost(){
        Post post = new Post(null,"xxxx","内容","作者",null);
        int result = postService.addPost(post);
        assertEquals(1,result);
    }
}