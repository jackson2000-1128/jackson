package com.mty.stadium.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *  layui 专属数据格式
 */
public class PageResultVo {

    private int code;
    private List data;
    private String msg;
    @JsonProperty(value = "count")
    private Long total;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public PageResultVo(int code, List data, String msg, Long total) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.total = total;
    }
    public PageResultVo(int code, List data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
