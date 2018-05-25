package com.xingjiejian.spring.demo.pm.service;

import com.xingjiejian.spring.demo.pm.entity.Picture;

import java.util.List;

/**
 * @author Xing.Jiejian
 */
public interface PictureService {

    void addPicture(Picture p);

    Picture findById(int id);

    List<Picture> findAll();
}
