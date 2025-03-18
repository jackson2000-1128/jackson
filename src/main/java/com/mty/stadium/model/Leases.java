package com.mty.stadium.model;


public class Leases{

    private Integer id;
    private String uid;
    private String eid;
    private Integer num;
    private Integer gnum;
    private String lendDate;
    private String returnDate;
    private String status;
    private java.util.Date createTime;

    private String uname;
    private String ename;

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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
    public void setEid(String value) {
        this.eid = value;
    }
    public String getEid() {
       return this.eid;
    }
    public void setNum(Integer value) {
        this.num = value;
    }
    public Integer getNum() {
       return this.num;
    }
    public void setLendDate(String value) {
        this.lendDate = value;
    }
    public String getLendDate() {
       return this.lendDate;
    }
    public void setReturnDate(String value) {
        this.returnDate = value;
    }
    public String getReturnDate() {
       return this.returnDate;
    }
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
