package com.xingjiejian.spring.demo.pm.web;

import com.xingjiejian.spring.demo.pm.entity.Post;
import com.xingjiejian.spring.demo.pm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 发帖相关的控制器
 * @author
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping
    public ModelAndView findAllPosts(){
        //创建返回模型，设置逻辑视图名称
        ModelAndView mv = new ModelAndView("posts");
        //获取数据，加入模型（放入Servlet作用域中）
        List<Post> posts = postService.findPosts();
        mv.addObject("post",posts);
        return mv;
    }
}
