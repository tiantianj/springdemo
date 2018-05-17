package com.xingjiejian.spring.demo.pm.dao.impl;

import com.xingjiejian.spring.demo.pm.dao.ReplyDao;
import com.xingjiejian.spring.demo.pm.entity.Reply;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 回帖相关数据库操作实现类
 * @author
 */
@Component
public class ReplyDaoImpl implements ReplyDao {
    @Override
    public void save(Reply reply) {
        System.out.println("ReplyDaoImpl-save()");
    }

    @Override
    public List<Reply> findByPostId(int postId) {
        System.out.println("ReplyDaoImpl-findByPostId()");
        return null;
    }
}
