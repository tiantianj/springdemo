package com.xingjiejian.spring.demo.pm.dao;

import com.xingjiejian.spring.demo.pm.entity.Picture;

import java.util.List;

/**
 * @author Xing.Jiejian
 */
public interface PictureDao {
    void save(Picture p);
    Picture findById(int id);
    List<Picture> findAll();
}
