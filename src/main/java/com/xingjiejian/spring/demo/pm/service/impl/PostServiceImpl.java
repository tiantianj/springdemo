package com.xingjiejian.spring.demo.pm.service.impl;

import com.xingjiejian.spring.demo.pm.dao.PostDao;
import com.xingjiejian.spring.demo.pm.dao.ReplyDao;
import com.xingjiejian.spring.demo.pm.entity.Post;
import com.xingjiejian.spring.demo.pm.entity.Reply;
import com.xingjiejian.spring.demo.pm.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统相关业务方法的实现类
 * @author
 */
@Component
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;
    @Autowired
    private ReplyDao replyDao;

    private static Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @Override
    public int addPost(Post post) {
        return postDao.save(post);
    }

    @Override
    public List<Post> findPosts() {
        return postDao.findAll();
    }

    @Override
    public List<Post> findPosts(String likeName) {
        if("".equals(likeName)){
            return findPosts();
        }
        return postDao.findByLikeTitle(likeName);
    }

    @Override
    public boolean addReply(Reply reply) {
        replyDao.save(reply);
        logger.info("保存回帖信息");
        return true;
    }

    @Override
    public List<Reply> findReplyByPostId(int postId) {
        return replyDao.findByPostId(postId);
    }

    @Override
    public Reply findReplyById(int id) {
        return replyDao.findById(id);
    }


    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    public ReplyDao getReplyDao() {
        return replyDao;
    }

    public void setReplyDao(ReplyDao replyDao) {
        this.replyDao = replyDao;
    }
}
