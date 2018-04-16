package com.coolweather.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.coolweather.android.pojo.CropDetail;
import com.coolweather.android.response.SearchResponse;
import com.coolweather.android.service.AutoUpdateService;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchActivity extends AppCompatActivity {
    private static String HOST_URL = "http://47.95.210.104";
    //农作物病虫害库列表信息
    private static String HOST_URL_LABEL_VIEW = HOST_URL + "/crop/label/view";
    //种类大类下细分品种名称水稻 小麦 大麦 玉米 高梁
    private static String HOST_URL_LABEL_DETAIL = HOST_URL + "/crop/label/detail";
    //每种细分类品下 病虫害名称信息
    private static String HOST_URL_TYPE_VIEW = HOST_URL + "/crop/type/view";
    //每种细分类品下 病虫害名称信息
    private static String HOST_URL_TYPE_DETAIL = HOST_URL + "/crop/type/detail";
    //全文搜索
    private static String HOST_URL_SEARCH = HOST_URL + "/crop/type/search";



    private String[] mStrs = {"aaa", "bbb", "ccc", "airsaid"};
    private SearchView mSearchView;

    private ListView searchList;
    private LinearLayout search_layout;
    private List<CropDetail> mData;
    private Context mContext = null;
    private MyAdapter mAdapter = null;

    private Button profButton ;
    private Button highButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mContext = SearchActivity.this;
        mSearchView = (SearchView) findViewById(R.id.searchView);
        searchList = (ListView) findViewById(R.id.search_list);
        search_layout= (LinearLayout) findViewById(R.id.search_layout);
        profButton = (Button) findViewById(R.id.profSearch);
        highButton = (Button) findViewById(R.id.highSearch);

        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this, ProfSearchActivity.class);
                startActivity(intent);
            }
        });
        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this, HighSearchActivity.class);
                startActivity(intent);
            }
        });

        mAdapter = new MyAdapter((ArrayList<CropDetail>) mData,mContext);
        searchList.setAdapter(mAdapter);
        searchList.addHeaderView(new ViewStub(this));
        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Long  cropId = mData.get(position-1).getId();
                Intent intent = new Intent(mContext, WeatherActivity.class);
                intent.putExtra("cropId", cropId);
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(SearchActivity.this).edit();
                editor.putString("cropDetail", null);
                editor.apply();
                startActivity(intent);
                    }
        });
//        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
//        mListView.setTextFilterEnabled(true);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!TextUtils.isEmpty(query)){
                    requestWeather(query);
                }else{
                    searchList.clearTextFilter();
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
    public void requestWeather(final String query) {
        String weatherUrl =HOST_URL_SEARCH + "?wd="+query;
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final SearchResponse searchResponse = Utility.handleSearchResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (searchResponse != null && searchResponse.getCode()==0) {
                            handleDate(searchResponse);
                        } else {
                            Toast.makeText(SearchActivity.this, "无查找结果，请重新输入", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(SearchActivity.this, "请检查网络", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    private void handleDate(SearchResponse searchResponse){
        mAdapter.clear();
        if(searchResponse.getData()!=null){
            mData = searchResponse.getData();
            for(CropDetail cropDetail : searchResponse.getData()){
                mAdapter.add(cropDetail);
            }
        }
    }
    }
