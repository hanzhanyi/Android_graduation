package com.coolweather.android.response;


import com.coolweather.android.pojo.LabelDetail;

import java.util.List;

/**
 * 返回值  Response
 */
public class LabelDetailResponse {
    private Integer code;
    private String message;
    private List<LabelDetail> data;

    public List<LabelDetail> getData() {
        return data;
    }

    public void setData(List<LabelDetail> data) {
        this.data = data;
    }

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

}
