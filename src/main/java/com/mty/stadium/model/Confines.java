package com.mty.stadium.model;


public class Confines{

    private Integer id;
    private String sid;
    private String applyDate;
    private String applyTime;
    private java.util.Date createTime;

    private String sdname;
    private String sname;

    public String getSdname() {
        return sdname;
    }

    public void setSdname(String sdname) {
        this.sdname = sdname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setSid(String value) {
        this.sid = value;
    }
    public String getSid() {
       return this.sid;
    }
    public void setApplyDate(String value) {
        this.applyDate = value;
    }
    public String getApplyDate() {
       return this.applyDate;
    }
    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
    public String getApplyTime() {
        return applyTime;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
