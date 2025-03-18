package com.mty.stadium.model;


public class User{

    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String sex;
    private String phone;
    private String type;
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
    public void setRealname(String value) {
        this.realname = value;
    }
    public String getRealname() {
       return this.realname;
    }
    public void setSex(String value) {
        this.sex = value;
    }
    public String getSex() {
       return this.sex;
    }
    public void setPhone(String value) {
        this.phone = value;
    }
    public String getPhone() {
       return this.phone;
    }
    public void setType(String value) {
        this.type = value;
    }
    public String getType() {
       return this.type;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
