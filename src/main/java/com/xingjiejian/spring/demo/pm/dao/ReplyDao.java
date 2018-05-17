package com.xingjiejian.spring.demo.pm.dao;

import com.xingjiejian.spring.demo.pm.entity.Reply;

import java.util.List;

/**
 * 回帖Dao操作接口
 * @author Xing.Jiejian
 */
public interface ReplyDao {
    /**
     * 新增回复
     * @param reply
     */
    void save(Reply reply);

    /**
     * 根据帖子Id查询所有回帖
     * @param postId
     * @return
     */
    List<Reply> findByPostId(int postId);
}
