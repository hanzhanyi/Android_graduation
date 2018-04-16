package com.coolweather.android.response;


import com.coolweather.android.pojo.Label;

import java.util.List;

/**
 * 返回值  Response
 */
public class LabelResponse {
    private Integer code;
    private String message;
    private List<Label> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Label> getData() {
        return data;
    }

    public void setData(List<Label> data) {
        this.data = data;
    }
}
