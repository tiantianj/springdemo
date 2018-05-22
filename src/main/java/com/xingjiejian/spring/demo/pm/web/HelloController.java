package com.xingjiejian.spring.demo.pm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制层代码示例
 * @author
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping
    public String hello(){
        return "hello";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String hello1(){
        return "hello1";
    }

    @RequestMapping("/test")
    public String test(){
        //实现重定向
        /*
        当返回的逻辑视图名前添加了“redirect”或者“forward”
        视图解析器会理解后面的路径为标准的url，将不再使用
        视图解析器去解析包装
         */
        return "redirect:/index.jsp";
    }
}
