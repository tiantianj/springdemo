package com.xingjiejian.spring.demo.pm.service;

import com.xingjiejian.spring.demo.pm.entity.Picture;

import java.util.List;

/**
 * @author Xing.Jiejian
 */
public interface PictureService {

    /**
     * 新增图片
     * @param p
     */
    void addPicture(Picture p);

    /**
     * 查找指定图片
     * @param id
     * @return
     */
    Picture findById(int id);

    /**
     * 查找所有图片
     * @return
     */
    List<Picture> findAll();
}
