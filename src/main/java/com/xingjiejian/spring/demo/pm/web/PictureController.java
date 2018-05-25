package com.xingjiejian.spring.demo.pm.web;

import com.xingjiejian.spring.demo.pm.entity.Picture;
import com.xingjiejian.spring.demo.pm.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Xing.Jiejian
 */
@Controller
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping
    public String findAll(Model model){
        List<Picture> pictures = pictureService.findAll();
        model.addAttribute(pictures);
        return "pictures";
    }

    @RequestMapping("/{id}")
    public String findPicture(@PathVariable int id,Model model){
        model.addAttribute(pictureService.findById(id));
        return "picture";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/add")
    public String goAddPicture(Model model){
        model.addAttribute(new Picture());
        return "picture";
    }

    @RequestMapping(method = RequestMethod.POST,path = "/add")
    public String addPicture(Model model){
        model.addAttribute(new Picture());
        return "picture";
    }
}
