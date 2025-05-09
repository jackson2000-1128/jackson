package com.mty.stadium.model;


public class Apply{

    private Integer id;
    private String sid;
    private String uid;
    private String applyDate;
    private String applyTime;
    private String status;
    private java.util.Date createTime;

    private String sdname;
    private String sname;
    private String uname;
    private String utype;

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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUtype() { return utype; }

    public void setUtype(String utype) { this.utype = utype; }
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
    public void setUid(String value) {
        this.uid = value;
    }
    public String getUid() {
       return this.uid;
    }
    public void setApplyDate(String value) {
        this.applyDate = value;
    }
    public String getApplyDate() {
       return this.applyDate;
    }

    public String getApplyTime() { return applyTime;}
    public void setApplyTime(String applyTime) { this.applyTime = applyTime;}

    public void setStatus(String value) {
        this.status = value;
    }
    public String getStatus() {
       return this.status;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
