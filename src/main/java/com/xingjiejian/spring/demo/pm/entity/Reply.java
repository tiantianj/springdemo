package com.xingjiejian.spring.demo.pm.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 帖子回复
 * @author Xing.Jiejian
 */
public class Reply {
    /**
     * 回帖编号
     */
    private Integer id;
    /**
     * 对应帖子编号
     */
    private Integer postId;
    /**
     * 回复内容
     * 设置字段不能为空，最少5个字符
     */
    @NotNull
    private String content;
    /**
     * 作者
     * 不能为空，且长度在2-5个字符之间
     */
    @NotNull
    @Size(min = 2,max = 5,message = "{author.size}")
    private String author;
    /**
     * 发布时间
     */
    private Date createDate;


    public Reply() {
    }

    public Reply(Integer postId, String content, String author, Date createDate) {
        this.postId = postId;
        this.content = content;
        this.author = author;
        this.createDate = createDate;
    }

    public Reply(Integer id, Integer postId, String content, String author, Date createDate) {
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.author = author;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
