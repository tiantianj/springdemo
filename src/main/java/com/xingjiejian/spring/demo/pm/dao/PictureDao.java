package com.xingjiejian.spring.demo.pm.dao;

import com.xingjiejian.spring.demo.pm.entity.Picture;

import java.util.List;

/**
 * @author Xing.Jiejian
 */
public interface PictureDao {
    /**
     * 保存图片
     * @param p
     */
    void save(Picture p);

    /**
     * 根据ID查询图片
     * @param id
     * @return
     */
    Picture findById(int id);

    /**
     * 查询所有图片
     * @return
     */
    List<Picture> findAll();
}
