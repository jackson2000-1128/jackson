package com.mty.stadium.model;


public class Message{

    private Integer id;
    private String uid;
    private String content;
    private String reply;
    private java.util.Date createTime;

    private String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setUid(String value) {
        this.uid = value;
    }
    public String getUid() {
       return this.uid;
    }
    public void setContent(String value) {
        this.content = value;
    }
    public String getContent() {
       return this.content;
    }
    public void setReply(String value) {
        this.reply = value;
    }
    public String getReply() {
       return this.reply;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
