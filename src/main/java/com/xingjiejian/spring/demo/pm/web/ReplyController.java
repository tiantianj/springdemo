package com.xingjiejian.spring.demo.pm.web;

import com.xingjiejian.spring.demo.pm.entity.Reply;
import com.xingjiejian.spring.demo.pm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * 回帖相关控制器
 * @author
 */
@Controller

public class ReplyController {

    @Autowired
    private PostService postService;

    @RequestMapping("/replies")
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


    /**
     * 跳转到新增回帖页面
     * @param postId 对应的帖子ID
     * @param model
     * @return
     */
    @RequestMapping(value = "/post/{postId}/reply",method = RequestMethod.GET)
    public String goAddReply(@PathVariable int postId,Model model){
        Reply reply = new Reply();
        reply.setPostId(postId);
        model.addAttribute(reply);
        return "reply";
    }

    @RequestMapping(value = "/reply/{id}",method = RequestMethod.GET)
    public String goUpdateReply(@PathVariable int id,Model model){
        model.addAttribute(postService.findReplyById(id));
        return "reply";
    }

    /**
     * 新增回帖操作
     * 使用Spring表单标签可以自动将表单属性绑定成指定的命令对象
     * @param reply
     * @param postId
     * @return
     */
    @RequestMapping(value = "/post/{postId}/reply",method = RequestMethod.POST)
    public String addReply(
            //声明控制器在注入当前对象时，会按照对象的Bean声明去校验
            @Valid Reply reply,
            //在前一个对象校验不通过时，获取相关信息
            Errors errors,
            @PathVariable int postId,
            HttpSession session){

        //如果校验出现错误，则重新返回表单
        if(errors.hasErrors()){
            return "reply";
        }
        //保存回帖
        postService.addReply(reply);
        //跳转到对应帖子的所有回帖页面
        return "redirect:/post/"+postId+"/replies";
    }




}
