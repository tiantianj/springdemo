package com.xingjiejian.spring.demo.pm.web;

import com.alibaba.fastjson.JSON;
import com.xingjiejian.spring.demo.pm.entity.Picture;
import com.xingjiejian.spring.demo.pm.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Xing.Jiejian
 */
@Controller
@RequestMapping("/pictures")
public class PictureController {

    private static Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;

    /**
     * 跳转到查看所有图片的页面
     * @param model
     * @return
     */
    @RequestMapping
    public String findAll(Model model){
        List<Picture> pictures = pictureService.findAll();
        model.addAttribute(pictures);
        return "pictures";
    }

    /**
     * 常用的JSON解析技术
     * 1)fastJson 阿里巴巴出品，效率高，速度快，但是在复杂的Bean对象解析可能有问题
     * 2)Gson 谷歌出品，解析技术比较好，基本上不会出现解析问题，但是性能不如fastJson
     * 3)Jackson Spring 内置支持的Json解析技术
     * 4)json-lib 不推荐
     *
     * 性能就考虑fastJson，安全就考虑Gson
     * 综合起来，Bean转换JSON使用Gson，JSON转换Bean使用fastJson
     * 跳转到查询指定图片的页面
     * @param id
     * @return
     *
     * 注解@ResponseBody 标记当前方法返回的不是逻辑视图，而是直接将
     * 结果返回给客户端
     *
     * 返回JSON字符串的乱码
     * 原因：Spring中默认的响应字符编码为ISO-8859-1
     * 解决途径：
     * 1)设置RequestMapping属性produces = "text/html; charset=utf-8"（就是设置Response中的contentType）
     * 2)在Spring MVC的配置文件中设置消息转换器StringHttpMessageConverter
     */
    @RequestMapping(value = "/{id}")
    @ResponseBody
    public String findPicture(@PathVariable int id){
        Picture picture = pictureService.findById(id);
        return JSON.toJSONString(picture);
    }

    /**
     * 跳转到新增图片的页面
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,path = "/add")
    public String goAddPicture(Model model){
        model.addAttribute(new Picture());
        return "picture";
    }

    /**
     * 实现图片上传的方法
     * @param file
     * @param picture
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,path = "/add")
    public String addPicture(
            //可以使用一个字节数组来接收上传的图片对象
            //@RequestPart byte[] file,
            //也可以使用更方便的MultipartFile类型来处理文件
            /**
             * 多文件上传方法
             * 1）使用MultipartFile[]接收所有表单提交的文件，然后遍历数组一个个处理
             * 2)声明多个MultipartFile参数，分别处理
             *
             * 与MultipartFile类型相似的还有javax.servlet.http.Part类型，同样可以作为接收文件对象
             * 的参数类型
             */
            @RequestPart("file") MultipartFile file,
            Picture picture) throws IOException {
        logger.info("字段名："+file.getName());
        logger.info("原始文件名："+file.getOriginalFilename());
        String url = "upload"+File.separator+file.getOriginalFilename();
        String savePath = System.getProperty("pm.webapp")+url;
        //保存文件到服务器硬件上
        file.transferTo(new File(savePath));
        logger.info("实际保存在服务器上的路径为："+savePath);
        picture.setUrl(url);
        pictureService.addPicture(picture);
        return "redirect:/pictures";
    }
}
