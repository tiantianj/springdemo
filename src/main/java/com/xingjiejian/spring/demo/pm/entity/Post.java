package com.xingjiejian.spring.demo.pm.entity;

import java.util.Date;

/**
 * 帖子
 * @author Xing.Jiejian
 */
public class Post {
    /**
     * 帖子编号，自增
     */
    private Integer id;
    /**
     * 帖子标题
     */
    private String title;
    /**
     * 帖子摘要
     */
    private String summary;
    /**
     * 作者
     */
    private String author;
    /**
     * 发布时间
     */
    private Date createDate;

    public Post() {
    }

    public Post(Integer id, String title, String summary, String author, Date createDate) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", author='" + author + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
