package com.mty.stadium.model;


public class Sites{

    private Integer id;
    private String image;
    private String sid;
    private String name;
    private String address;
    private String startTime;
    private java.util.Date createTime;

    private String sdname;

    public String getSdname() {
        return sdname;
    }

    public void setSdname(String sdname) {
        this.sdname = sdname;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setImage(String value) {
        this.image = value;
    }
    public String getImage() {
       return this.image;
    }
    public void setSid(String value) {
        this.sid = value;
    }
    public String getSid() {
       return this.sid;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setAddress(String value) {
        this.address = value;
    }
    public String getAddress() {
       return this.address;
    }
    public void setStartTime(String value) {
        this.startTime = value;
    }
    public String getStartTime() {
       return this.startTime;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
