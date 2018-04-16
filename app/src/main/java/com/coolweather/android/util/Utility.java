package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.Weather;
import com.coolweather.android.pojo.CropDetail;
import com.coolweather.android.pojo.Label;
import com.coolweather.android.pojo.LabelDetail;
import com.coolweather.android.response.CropDetailResponse;
import com.coolweather.android.response.CropResponse;
import com.coolweather.android.response.LabelDetailResponse;
import com.coolweather.android.response.LabelResponse;
import com.coolweather.android.response.SearchResponse;
import com.coolweather.android.utils.JsonHelper;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    LabelDetailResponse labelDetailResponse;
    CropDetailResponse cropDetailResponse;
    /**
     * 解析和处理服务器返回的科类数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
                LabelResponse labelResponse ;
                labelResponse = JsonHelper.toObject(response, LabelResponse.class);
                for(Label label : labelResponse.getData()){
                    label.setLabelId(label.getId());
                    label.save();
                }
                return true;
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            LabelDetailResponse labelDetailResponse ;
            labelDetailResponse = JsonHelper.toObject(response, LabelDetailResponse.class);
            for(LabelDetail labelDetail : labelDetailResponse.getData()){
                labelDetail.setLabelDetailId(labelDetail.getId());
                labelDetail.save();

            }
            return true;
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            CropResponse cropResponse ;
            cropResponse = JsonHelper.toObject(response, CropResponse.class);
            for(CropDetail cropDetail : cropResponse.getData()){
                cropDetail.setCropId(cropDetail.getId());
                cropDetail.save();
            }
            return true;
        }
        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather实体类
     */
    public static CropDetailResponse handleCropDetailResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            CropDetailResponse cropDetailResponse ;
            cropDetailResponse = JsonHelper.toObject(response, CropDetailResponse.class);
            return cropDetailResponse;
        }
        return null;
    }
    /**
     * 将返回的JSON数据解析成Search实体类
     */
    public static SearchResponse handleSearchResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            SearchResponse searchResponse ;
            searchResponse = JsonHelper.toObject(response, SearchResponse.class);
            return searchResponse;
        }
        return null;
    }



}
