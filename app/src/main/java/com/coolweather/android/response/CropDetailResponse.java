package com.coolweather.android.response;


import com.coolweather.android.pojo.CropDetail;

/**
 * 返回值  Response
 */
public class CropDetailResponse {
    private Integer code;
    private String message;
    private CropDetail data;

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

    public CropDetail getData() {
        return data;
    }

    public void setData(CropDetail data) {
        this.data = data;
    }
}
