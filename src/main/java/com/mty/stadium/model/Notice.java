package com.mty.stadium.model;


public class Notice {
    private Integer id;
    private String title;
    private String content;
    private java.util.Date createTime;


    public void setId(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return this.id;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String value) {
        this.content = value;
    }

    public String getContent() {
        return this.content;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}
