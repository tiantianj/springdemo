package com.xingjiejian.spring.demo.pm.dao;

import com.xingjiejian.spring.demo.pm.entity.Post;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 帖子dao接口
 * @author Xing.Jiejian
 */
public interface PostDao {
    /**
     * 查询所有的帖子
     * @return
     */
    List<Post> findAll();

    /**
     * 根据标题模糊查询帖子
     * @param likeTitle 标题(模糊查询)
     * @return
     */
    List<Post> findByLikeTitle(@Param("likeTitle") String likeTitle);

    /**
     * 保存帖子
     * @param post
     * @return
     */
    int save(Post post);
}

