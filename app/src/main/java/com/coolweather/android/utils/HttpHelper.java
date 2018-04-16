package com.coolweather.android.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpHelper {

    private static HttpHelper instance;
    private OkHttpClient okHttpClient;

    private HttpHelper() {
        //此处配置OkHttpClient的基本信息,okhttp3在new对象并需要配置参数一般通过build这个方法来实现,类似的还有Request：
        //构建形式如:new XXX.Builder().xxx().xxx().build();
        okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    //单例模式,为什么使用?有兴趣可参考：http://www.cnblogs.com/seesea125/archive/2012/04/05/2433463.html
    //个人认为：1.此类在应用中唯一,似乎没有再new的必要
    //2.此类类似于工具类,为了方便却需要提取类变量okHttpClient,因此不能作为工具类只提供静态方法(感觉不能表达清楚我的想法)
    public static HttpHelper getInstance() {
        if (instance == null) {
            synchronized (HttpHelper.class) {
                if (instance == null) {
                    instance = new HttpHelper();
                }
            }
        }
        return instance;
    }

    /**
     * 一般的get请求 对于一般的请求，我们希望给个url，然后取的返回的String。
     */
    public String get(String url) {
        return get(url, null);
    }

    public String get(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (params != null && params.size() > 0) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            sb.append("?");
            for (Map.Entry<String, String> entry : entrySet) {
                sb.append(entry.getKey());
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        Request request = new Request.Builder().url(url + sb.toString()).get().build();
        Call call = okHttpClient.newCall(request);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 一般的post请求 对于一般的请求，我们希望给个url和封装参数的Map，然后取的返回的String。
     */
    public String post(String url, Map<String, String> params) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        Request request = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
        Call call = okHttpClient.newCall(request);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
