package com.coolweather.android.response;

import com.coolweather.android.pojo.CropDetail;

import java.util.List;

/**
 * Created by Administrator on 2018/3/18.
 */

public class SearchResponse {

    private Integer code;
    private String message;
    private List<CropDetail> data;

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

    public List<CropDetail> getData() {
        return data;
    }

    public void setData(List<CropDetail> data) {
        this.data = data;
    }
}
