package com.xingjiejian.spring.demo.pm.dao.impl;

import com.xingjiejian.spring.demo.pm.dao.PictureDao;
import com.xingjiejian.spring.demo.pm.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Xing.Jiejian
 */
//@Repository
public class PictureDaoImpl implements PictureDao {
    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public void save(Picture p) {
        String sql = "INSERT INTO picture(name,url) VALUES(?,?)";
        Object[] params = {p.getName(),p.getUrl()};
        jdbcOperations.update(sql,params);
    }

    @Override
    public Picture findById(int id) {
        String sql = "SELECT * FROM picture WHERE id=?";
        return jdbcOperations.queryForObject(sql,this::rowMap,id);
    }

    @Override
    public List<Picture> findAll() {
        String sql = "SELECT * FROM picture";
        return jdbcOperations.query(sql,this::rowMap);
    }

    private Picture rowMap(ResultSet rs, int rowNum) throws SQLException{
        return new Picture(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("url")
        );
    }
}
