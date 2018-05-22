package com.xingjiejian.spring.demo.pm.web;

import com.xingjiejian.spring.demo.pm.entity.Reply;
import com.xingjiejian.spring.demo.pm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 回帖相关控制器
 * @author
 */
@Controller

public class ReplyController {

    @Autowired
    private PostService postService;

    @RequestMapping("/reply")
    public ModelAndView findRelyByPostId(
            //将请求中的参数postId的值赋值给方法的参数id
            //@RequestParam("postId")
                    int id){
        ModelAndView mv = new ModelAndView("replies");
        List<Reply> replies = postService.findReplyByPostId(id);
        mv.addObject("replies",replies);
        return mv;
    }


    @RequestMapping("/post/{postId}/replies")
    public String findReplyByPostId(
            //路径参数
            @PathVariable int postId, Model model){
        List<Reply> replies = postService.findReplyByPostId(postId);
        model.addAttribute("replies",replies);
        return "replies";
    }

}
