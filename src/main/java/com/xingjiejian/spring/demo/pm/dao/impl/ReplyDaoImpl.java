package com.xingjiejian.spring.demo.pm.dao.impl;

import com.xingjiejian.spring.demo.pm.dao.ReplyDao;
import com.xingjiejian.spring.demo.pm.entity.Post;
import com.xingjiejian.spring.demo.pm.entity.Reply;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 回帖相关数据库操作实现类
 * @author
 */
//@Repository
public class ReplyDaoImpl implements ReplyDao {

    private JdbcOperations jdbcOperations;

    @Inject
    public ReplyDaoImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void save(Reply reply) {
        String sql = "INSERT INTO reply(postId,content,author) VALUES (?,?,?)";
        Object[] params = {reply.getPostId(),reply.getContent(),reply.getAuthor()};
        jdbcOperations.update(sql,params);
    }

    @Override
    public List<Reply> findByPostId(int postId) {
        String sql = "SELECT * FROM reply WHERE postId=?";
        //this::mapRow 使用Java 8 中的Lambda表达式实现——方法引用
        return jdbcOperations.query(sql,this::mapRow,postId);
    }

    @Override
    public Reply findById(int id) {
        String sql = "SELECT * FROM reply WHERE id=?";
        return jdbcOperations.queryForObject(sql,this::mapRow ,id);
    }

    /**
     * 在单独的方法中定义映射逻辑
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    private Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Reply(
                rs.getInt("id"),
                rs.getInt("postId"),
                rs.getString("content"),
                rs.getString("author"),
                rs.getTimestamp("createDate")
        );
    }
}
