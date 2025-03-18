package com.mty.stadium.model;


public class Stadium{

    private Integer id;
    private String name;
    private String remark;
    private java.util.Date createTime;

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setRemark(String value) {
        this.remark = value;
    }
    public String getRemark() {
       return this.remark;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
