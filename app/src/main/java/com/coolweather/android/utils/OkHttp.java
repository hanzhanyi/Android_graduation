package com.coolweather.android.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/2/28.
 */

public class OkHttp {
    private static OkHttp okHttp = new OkHttp();

    public static OkHttp getOkHttpInstence() {
        return okHttp;
    }

    private OkHttp() {
    }

    public String getMethod(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
            return response.body().string();
        } catch (IOException e) {
            System.out.println("网络请求异常");
            e.printStackTrace();
        }
        return null;
    }
}
