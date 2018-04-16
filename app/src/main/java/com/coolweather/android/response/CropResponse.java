package com.coolweather.android.response;


import com.coolweather.android.pojo.CropDetail;

import java.util.List;

/**
 * 返回值  Response
 */
public class CropResponse {
    private Integer code;
    private String message;
    private List<CropDetail> data;

    public List<CropDetail> getData() {
        return data;
    }

    public void setData(List<CropDetail> data) {
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
