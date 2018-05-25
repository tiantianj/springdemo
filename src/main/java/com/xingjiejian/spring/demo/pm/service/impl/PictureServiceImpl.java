package com.xingjiejian.spring.demo.pm.service.impl;

import com.xingjiejian.spring.demo.pm.dao.PictureDao;
import com.xingjiejian.spring.demo.pm.entity.Picture;
import com.xingjiejian.spring.demo.pm.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xing.Jiejian
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    @Override
    public void addPicture(Picture p) {
        pictureDao.save(p);
    }

    @Override
    public Picture findById(int id) {
        return pictureDao.findById(id);
    }

    @Override
    public List<Picture> findAll() {
        return pictureDao.findAll();
    }
}
