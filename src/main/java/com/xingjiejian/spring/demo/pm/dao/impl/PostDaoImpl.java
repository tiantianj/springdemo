package com.xingjiejian.spring.demo.pm.dao.impl;

import com.xingjiejian.spring.demo.pm.dao.PostDao;
import com.xingjiejian.spring.demo.pm.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 帖子相关的数据库操作实现类
 * @author
 *
 * 注解@Repository指定当前类型是一个持久化层次的Bean
 */
//@Repository
public class PostDaoImpl
//        implements PostDao
{
//    //注入JDBC模板
//    private JdbcOperations jdbcOperations;
//
//    @Autowired
//    private NamedParameterJdbcOperations npjo;
//
//    /**
//     * 在构建Dao对象时，使用构造注入jdbc模板
//     * JdbcOperations是 JdbcTemplate的接口
//     * @param jdbcOperations
//     */
//    @Inject
//    public PostDaoImpl(JdbcOperations jdbcOperations) {
//        this.jdbcOperations = jdbcOperations;
//    }
//
//    @Override
//    public List<Post> findAll() {
//        System.out.println("PostDaoImpl-findAll()");
//        String sql = "SELECT id,title,summary,author,createDate FROM post";
//        return jdbcOperations.query(sql, new PostRowMapper());
//    }
//
//    @Override
//    public List<Post> findByLikeTitle(String likeTitle) {
//        String sql = "SELECT id,title,summary,author,createDate FROM post WHERE title LIKE ?";
//        return jdbcOperations.query(sql,
//                //使用lambda表达式构建解析逻辑
//                (rs, rowNum) -> {
//                    return new Post(
//                            rs.getInt("id"),
//                            rs.getString("title"),
//                            rs.getString("summary"),
//                            rs.getString("author"),
//                            rs.getTimestamp("createDate")
//                    );
//                },"%"+likeTitle+"%");
//    }
//
//    @Override
//    public int save(Post post) {
//        String sql = "INSERT INTO post(title,summary,author) VALUES(:title,:summary,:author)";
//        Map<String,Object> params = new HashMap<>();
//        params.put("title",post.getTitle());
//        params.put("summary",post.getSummary());
//        params.put("author",post.getAuthor());
//        return npjo.update(sql,params);
//    }
//
//    public NamedParameterJdbcOperations getNpjo() {
//        return npjo;
//    }
//
//    public void setNpjo(NamedParameterJdbcOperations npjo) {
//        this.npjo = npjo;
//    }
//
//
//    /**
//     * 自定义内部类，用来构建从ResultSet中解析获取Post对象的过程
//     */
//    private static final class PostRowMapper implements RowMapper<Post>{
//
//        @Override
//        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
//            //直接编写提取一行数据库，转换成POJO的过程
//            return new Post(
//                    rs.getInt("id"),
//                    rs.getString("title"),
//                    rs.getString("summary"),
//                    rs.getString("author"),
//                    rs.getTimestamp("createDate")
//            );
//        }
//    }
//
//

}
