package com.mty.stadium.model;

public class Notice {
    private Integer id;
    private String title;
    private String content;
    private java.util.Date createTime;


    public void setId(Integer value) { this.id = value;}
    public Integer getId() { return this.id;}
    public void setTitle(String value) { this.title = value;}
    public String getTitle() { return this.title;}
    public void setContent(String value) { this.content = value;}
    public String getContent() { return this.content;}
    public void setCreateTime(java.util.Date value) { this.createTime = value;}
    public java.util.Date getCreateTime() { return this.createTime;}
//    // 构造函数、getter 和 setter 方法
//    public Notice() {}
//
//    public Notice(Integer id, String title, String content, Date create_time) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.create_time = create_time;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Date getCreateTime() {
//        return create_time;
//    }
//
//    public void setCreateTime(Date create_time) {
//        this.create_time = create_time;
//    }
}