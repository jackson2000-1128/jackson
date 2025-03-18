package com.mty.stadium.model;


public class Admin{

    private Integer id;
    private String username;
    private String password;
    private java.util.Date createTime;

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setUsername(String value) {
        this.username = value;
    }
    public String getUsername() {
       return this.username;
    }
    public void setPassword(String value) {
        this.password = value;
    }
    public String getPassword() {
       return this.password;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
