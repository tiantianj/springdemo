package com.xingjiejian.spring.demo.pm.service;

import com.xingjiejian.spring.demo.pm.entity.Post;
import com.xingjiejian.spring.demo.pm.entity.Reply;

import java.util.List;

/**
 * 帖子管理相关业务类
 */
public interface PostService {
    /**
     * 发帖
     * @param post
     * @return
     */
    int addPost(Post post);

    /**
     * 查询帖子集合
     * @return 名称为空或者空字符串时，返回所有帖子集合
     */
    List<Post> findPosts();

    /**
     * 查询帖子集合
     * @param likeName 模糊查询名称
     * @return 模糊查询帖子集合
     */
    List<Post> findPosts(String likeName);

    /**
     * 发表回帖
     * @param reply 回帖
     * @return
     */
    boolean addReply(Reply reply);

    /**
     * 根据发帖id查询所有回帖
     * @param postId 发帖Id
     * @return
     */
    List<Reply> findReplyByPostId(int postId);

    Reply findReplyById(int id);
}
