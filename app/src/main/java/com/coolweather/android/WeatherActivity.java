package com.coolweather.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.coolweather.android.gson.Forecast;
import com.coolweather.android.gson.Weather;
import com.coolweather.android.pojo.CropDetail;
import com.coolweather.android.pojo.CropDetailImg;
import com.coolweather.android.response.CropDetailResponse;
import com.coolweather.android.service.AutoUpdateService;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;

    public SwipeRefreshLayout swipeRefresh;

    private ScrollView weatherLayout;

    private Button navButton;

    private Button professor;

    private TextView cropCity;

    private TextView cropBigName;

    private TextView cropEnglishText;

    private LinearLayout forecastLayout;

    private LinearLayout forecastMainLayout;

    private LinearLayout jianjie ;

    private TextView anotherName;
    private TextView introduction;
    private TextView damageSym;
    private TextView occurrenceFactor;
    private TextView morphology;
    private TextView habits;
    private TextView handleMethod;
    private TextView pathogen;
    private TextView cycle;

    private ImageView bingPicImg;

    private Long mWeatherId;
    private static String HOST_URL = "http://47.95.210.104";

    //农作物病虫害库列表信息
    private static String HOST_URL_LABEL_VIEW = HOST_URL + "/crop/label/view";
    //种类大类下细分品种名称水稻 小麦 大麦 玉米 高梁
    private static String HOST_URL_LABEL_DETAIL = HOST_URL + "/crop/label/detail";
    //每种细分类品下 病虫害名称信息
    private static String HOST_URL_TYPE_VIEW = HOST_URL + "/crop/type/view";
    //每种细分类品下 病虫害名称信息
    private static String HOST_URL_TYPE_DETAIL = HOST_URL + "/crop/type/detail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        // 初始化各控件
        bingPicImg = (ImageView) findViewById(R.id.bing_pic_img);
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        cropCity = (TextView) findViewById(R.id.crop_city);
        professor = (Button) findViewById(R.id.professor);
        cropBigName = (TextView) findViewById(R.id.crop_name_text);
        cropEnglishText = (TextView) findViewById(R.id.crop_english_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        forecastMainLayout = (LinearLayout) findViewById(R.id.forecast_layout_main);

//        aqiText = (TextView) findViewById(R.id.aqi_text);
//        pm25Text = (TextView) findViewById(R.id.pm25_text);
//        comfortText = (TextView) findViewById(R.id.comfort_text);
//        carWashText = (TextView) findViewById(R.id.car_wash_text);

        damageSym = (TextView) findViewById(R.id.damage_sym);
        occurrenceFactor = (TextView) findViewById(R.id.occurrence_factor);
        morphology = (TextView) findViewById(R.id.morphology);
        habits = (TextView) findViewById(R.id.habits);
        handleMethod = (TextView) findViewById(R.id.handleMethod);
        pathogen = (TextView) findViewById(R.id.pathogen);
        cycle = (TextView) findViewById(R.id.cycle);
        introduction = (TextView) findViewById(R.id.introduction);
        anotherName= (TextView) findViewById(R.id.another_name);
        jianjie = (LinearLayout) findViewById(R.id.jianjie);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navButton = (Button) findViewById(R.id.nav_button);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString("cropDetail", null);
        if (weatherString != null) {
            // 有缓存时直接解析天气数据
            CropDetailResponse cropDetailResponse = Utility.handleCropDetailResponse(weatherString);
            mWeatherId = cropDetailResponse.getData().getId();
            showWeatherInfo(cropDetailResponse.getData());
        } else {
            // 无缓存时去服务器查询天气
            mWeatherId = getIntent().getLongExtra("cropId",0);
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(mWeatherId);
        }
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestWeather(mWeatherId);
            }
        });
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WeatherActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        String bingPic = prefs.getString("bing_pic", null);
        if (bingPic != null) {
            Glide.with(this).load(bingPic).into(bingPicImg);
        } else {
            loadBingPic();
        }
    }

    /**
     * 根据天气id请求城市天气信息。
     */
    public void requestWeather(final Long cropId) {
        String weatherUrl =HOST_URL_TYPE_DETAIL + "?id="+cropId;
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final CropDetailResponse cropDetailResponse = Utility.handleCropDetailResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (cropDetailResponse != null && cropDetailResponse.getCode()==0) {
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("cropDetail", responseText);
                            editor.apply();
                            mWeatherId = cropDetailResponse.getData().getId();
                            showWeatherInfo(cropDetailResponse.getData());
                        } else {
                            Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                        }
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        });
        loadBingPic();
    }

    /**
     * 加载必应每日一图
     */
    private void loadBingPic() {
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 处理并展示Weather实体类中的数据。
     */
    private void showWeatherInfo(CropDetail cropDetail) {
        String cropName = cropDetail.getCropName();
        String professorr = "专家问答";
        String englishName = cropDetail.getEnglishName();
        cropCity.setText(cropName);
        professor.setText(professorr);
        cropBigName.setText(cropName);
        cropEnglishText.setText(englishName);
        forecastLayout.removeAllViews();
        forecastMainLayout.setVisibility(View.VISIBLE);
        if(cropDetail.getImgList()==null||cropDetail.getImgList().isEmpty()){
            forecastMainLayout.setVisibility(View.GONE);
        }else {
            for (CropDetailImg cropDetailImg : cropDetail.getImgList()) {
                View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
                ImageView dateText = (ImageView) view.findViewById(R.id.date_text);
                loadBingPic(cropDetailImg, dateText);
                forecastLayout.addView(view);
            }
        }
//        if (weather.aqi != null) {
//            aqiText.setText(weather.aqi.city.aqi);
//            pm25Text.setText(weather.aqi.city.pm25);
//        }
        damageSym.setVisibility(View.VISIBLE);
        occurrenceFactor.setVisibility(View.VISIBLE);
        morphology.setVisibility(View.VISIBLE);
        habits.setVisibility(View.VISIBLE);
        handleMethod.setVisibility(View.VISIBLE);
        pathogen.setVisibility(View.VISIBLE);
        cycle.setVisibility(View.VISIBLE);
        anotherName.setVisibility(View.VISIBLE);
        introduction.setVisibility(View.VISIBLE);
        jianjie.setVisibility(View.VISIBLE);

        introduction.setText(Html.fromHtml("<b>异名：</b>"+cropDetail.getIntroduction()));
        anotherName.setText(Html.fromHtml("<b>简介：</b>"+cropDetail.getAnotherName()));
        damageSym.setText(Html.fromHtml("<b>为害性状：</b>"+cropDetail.getDamageSym()));
        occurrenceFactor.setText(Html.fromHtml("<b>发生因素：</b>"+cropDetail.getOccurrenceFactor()));
        morphology.setText(Html.fromHtml("<b>形态特征：</b>"+cropDetail.getMorphology()));
        habits.setText(Html.fromHtml("<b>生活习性：</b>"+cropDetail.getHabits()));
        handleMethod.setText(Html.fromHtml("<b>防治方法：</b>"+cropDetail.getHandleMethod()));
        pathogen.setText(Html.fromHtml("<b>病原物：</b>"+cropDetail.getPathogen()));
        cycle.setText(Html.fromHtml("<b>侵染循环：</b>"+cropDetail.getCycle()));

        if(cropDetail.getIntroduction()==null||cropDetail.getIntroduction().isEmpty())
            introduction.setVisibility(View.GONE);
        if(cropDetail.getAnotherName()==null||cropDetail.getAnotherName().isEmpty())
            anotherName.setVisibility(View.GONE);
        if((cropDetail.getIntroduction()==null||cropDetail.getIntroduction().isEmpty())&&(cropDetail.getAnotherName()==null||cropDetail.getAnotherName().isEmpty())){
            jianjie.setVisibility(View.GONE);
        }
        if(cropDetail.getDamageSym()==null||cropDetail.getDamageSym().isEmpty())
            damageSym.setVisibility(View.GONE);
        if(cropDetail.getOccurrenceFactor()==null||cropDetail.getOccurrenceFactor().isEmpty())
            occurrenceFactor.setVisibility(View.GONE);
        if(cropDetail.getMorphology()==null||cropDetail.getMorphology().isEmpty())
            morphology.setVisibility(View.GONE);
        if(cropDetail.getHabits()==null||cropDetail.getHabits().isEmpty())
            habits.setVisibility(View.GONE);
        if(cropDetail.getHandleMethod()==null||cropDetail.getHandleMethod().isEmpty())
            handleMethod.setVisibility(View.GONE);
        if(cropDetail.getPathogen()==null||cropDetail.getPathogen().isEmpty())
            pathogen.setVisibility(View.GONE);
        if(cropDetail.getCycle()==null||cropDetail.getCycle().isEmpty())
            cycle.setVisibility(View.GONE);

        weatherLayout.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, AutoUpdateService.class);
        startService(intent);
    }

    /**
     * 加载图片
     */
    private void loadBingPic(final CropDetailImg cropDetailImg, final ImageView imageView) {
        HttpUtil.sendOkHttpRequest(cropDetailImg.getPicUrl(), new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(cropDetailImg.getPicUrl()).into(imageView);
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }
}
