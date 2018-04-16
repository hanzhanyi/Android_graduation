package com.coolweather.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.coolweather.android.enums.CropNameEnums;
import com.coolweather.android.pojo.CropDetail;
import com.coolweather.android.response.SearchResponse;
import com.coolweather.android.source.RadioGroupEx;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ProfSearchActivity extends AppCompatActivity {
    private static String HOST_URL = "http://47.95.210.104";
    //专业搜索
    private static String HOST_URL_SEARCH = HOST_URL + "/crop/type/profsearch";

    private SearchView mSearchView;
    private ListView searchList;
    private LinearLayout search_layout;
    private List<CropDetail> mData;
    private Context mContext = null;
    private MyAdapter mAdapter = null;
    private RadioGroupEx radioGroupEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_search);
        mContext = ProfSearchActivity.this;
        mSearchView = (SearchView) findViewById(R.id.searchView);
        searchList = (ListView) findViewById(R.id.search_list);
        search_layout = (LinearLayout) findViewById(R.id.search_layout);
        radioGroupEx = (RadioGroupEx) findViewById(R.id.radioGroup);
        mAdapter = new MyAdapter((ArrayList<CropDetail>) mData, mContext);
        searchList.setAdapter(mAdapter);
        searchList.addHeaderView(new ViewStub(this));
        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Long cropId = mData.get(position - 1).getId();
                Intent intent = new Intent(mContext, WeatherActivity.class);
                intent.putExtra("cropId", cropId);
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(ProfSearchActivity.this).edit();
                editor.putString("cropDetail", null);
                editor.apply();
                startActivity(intent);
            }
        });

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                for (int i = 0; i < radioGroupEx.getChildCount(); i++) {
                    RadioButton rd = (RadioButton) radioGroupEx.getChildAt(i);
                    if (rd.isChecked()) {
                        CropNameEnums cropNameEnums = CropNameEnums.getCropNameEnumByDesc(rd.getText().toString());
                        if (!TextUtils.isEmpty(query)) {
                            requestWeather(query, cropNameEnums.getCropNo());
                        } else {
                            searchList.clearTextFilter();
                        }
                        break;
                    }
                }

                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    /**
     * 根据天气id请求城市天气信息。
     */
    public void requestWeather(final String query, final int type) {
        String weatherUrl = HOST_URL_SEARCH + "?wd=" + query + "&type=" + type;
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final SearchResponse searchResponse = Utility.handleSearchResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (searchResponse != null && searchResponse.getCode() == 0) {
                            handleDate(searchResponse);
                        } else {
                            mAdapter.clear();
                            Toast.makeText(ProfSearchActivity.this, "无查找结果，请重新输入", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ProfSearchActivity.this, "请检查网络", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    private void handleDate(SearchResponse searchResponse) {
        mAdapter.clear();
        if (searchResponse.getData() != null) {
            mData = searchResponse.getData();
            for (CropDetail cropDetail : searchResponse.getData()) {
                mAdapter.add(cropDetail);
            }
        }
    }
}
