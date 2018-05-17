package com.xingjiejian.spring.demo.pm.dao.impl;

import com.xingjiejian.spring.demo.pm.dao.PostDao;
import com.xingjiejian.spring.demo.pm.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 帖子相关的数据库操作实现类
 * @author
 */
@Component
public class PostDaoImpl implements PostDao {
    @Override
    public List<Post> findAll() {
        System.out.println("PostDaoImpl-findAll()");
        return null;
    }

    @Override
    public List<Post> findByLikeTitle(String likeTitle) {
        System.out.println("PostDaoImpl-findByLikeTitle()");
        return null;
    }
}
