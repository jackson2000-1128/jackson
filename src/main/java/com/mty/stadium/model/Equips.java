package com.mty.stadium.model;


public class Equips{

    private Integer id;
    private String cid;
    private String name;
    private Integer num;
    private String purpose;
    private java.util.Date createTime;

    private String cname;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setCid(String value) {
        this.cid = value;
    }
    public String getCid() {
       return this.cid;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setNum(Integer value) {
        this.num = value;
    }
    public Integer getNum() {
       return this.num;
    }
    public void setPurpose(String value) {
        this.purpose = value;
    }
    public String getPurpose() {
       return this.purpose;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
