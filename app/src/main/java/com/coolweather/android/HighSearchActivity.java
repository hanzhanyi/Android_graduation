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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.coolweather.android.enums.CropNameEnums;
import com.coolweather.android.enums.IncludeEnums;
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

public class HighSearchActivity extends AppCompatActivity {
    private static String HOST_URL = "http://47.95.210.104";
    //专业搜索
    private static String HOST_URL_SEARCH = HOST_URL + "/crop/type/seniorsearch";

    private ListView searchList;
    private LinearLayout search_layout;
    private List<CropDetail> mData;
    private Context mContext = null;
    private MyAdapter mAdapter = null;

    private Spinner spin_one_1 ;
    private Spinner spin_one_2 ;
    private EditText text_1 ;

    private Spinner spin_two_1 ;
    private Spinner spin_two_2 ;
    private EditText text_2 ;

    private Spinner spin_three_1 ;
    private Spinner spin_three_2 ;
    private EditText text_3 ;

    private Spinner spin_four_1 ;
    private Spinner spin_four_2 ;
    private EditText text_4 ;

    private Spinner spin_five_1 ;
    private Spinner spin_five_2 ;
    private EditText text_5 ;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_search);
        mContext = HighSearchActivity.this;
        searchList = (ListView) findViewById(R.id.search_list);
        search_layout= (LinearLayout) findViewById(R.id.search_layout);

        spin_one_1 = (Spinner)findViewById(R.id.spin_one_1);
        spin_one_2 = (Spinner)findViewById(R.id.spin_one_2);
        text_1 = (EditText) findViewById(R.id.text_1);

        spin_two_1 = (Spinner)findViewById(R.id.spin_two_1);
        spin_two_2 = (Spinner)findViewById(R.id.spin_two_2);
        text_2 = (EditText) findViewById(R.id.text_2);

        spin_three_1 = (Spinner)findViewById(R.id.spin_three_1);
        spin_three_2 = (Spinner)findViewById(R.id.spin_three_2);
        text_3 = (EditText) findViewById(R.id.text_3);

        spin_four_1 = (Spinner)findViewById(R.id.spin_four_1);
        spin_four_2 = (Spinner)findViewById(R.id.spin_four_2);
        text_4 = (EditText) findViewById(R.id.text_4);

        spin_five_1 = (Spinner)findViewById(R.id.spin_five_1);
        spin_five_2 = (Spinner)findViewById(R.id.spin_five_2);
        text_5 = (EditText) findViewById(R.id.text_5);

        button = (Button)findViewById(R.id.highButton);

        mAdapter = new MyAdapter((ArrayList<CropDetail>) mData,mContext);
        searchList.setAdapter(mAdapter);
        searchList.addHeaderView(new ViewStub(this));
        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Long  cropId = mData.get(position-1).getId();
                Intent intent = new Intent(mContext, WeatherActivity.class);
                intent.putExtra("cropId", cropId);
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(HighSearchActivity.this).edit();
                editor.putString("cropDetail", null);
                editor.apply();
                startActivity(intent);
                    }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = handleSearchQuery();
                if (!TextUtils.isEmpty(query)){
                    requestWeather(query);
                }else{
                    searchList.clearTextFilter();
                }
            }
        });
    }

    /**
     * 处理提交query数据
     * @return
     */
    private String handleSearchQuery(){
        StringBuilder query = new StringBuilder();
        if(text_1.getText().toString()!=null&&!text_1.getText().toString().isEmpty()){
            IncludeEnums includeEnums = IncludeEnums.getIncludeEnumsByDesc(spin_one_1.getSelectedItem().toString());
            CropNameEnums cropNameEnums = CropNameEnums.getCropNameEnumByDesc(spin_one_2.getSelectedItem().toString());
            query.append(includeEnums.getSymbol());
            query.append(cropNameEnums.getCropName()+":");
            query.append(text_1.getText().toString());

        } if(text_2.getText().toString()!=null&&!text_2.getText().toString().isEmpty()){
            IncludeEnums includeEnums = IncludeEnums.getIncludeEnumsByDesc(spin_two_1.getSelectedItem().toString());
            CropNameEnums cropNameEnums = CropNameEnums.getCropNameEnumByDesc(spin_two_2.getSelectedItem().toString());
            query.append(includeEnums.getSymbol());
            query.append(cropNameEnums.getCropName()+":");
            query.append(text_2.getText().toString());

        } if(text_3.getText().toString()!=null&&!text_3.getText().toString().isEmpty()){
            IncludeEnums includeEnums = IncludeEnums.getIncludeEnumsByDesc(spin_three_1.getSelectedItem().toString());
            CropNameEnums cropNameEnums = CropNameEnums.getCropNameEnumByDesc(spin_three_2.getSelectedItem().toString());
            query.append(includeEnums.getSymbol());
            query.append(cropNameEnums.getCropName()+":");
            query.append(text_3.getText().toString());

        } if(text_4.getText().toString()!=null&&!text_4.getText().toString().isEmpty()){
            IncludeEnums includeEnums = IncludeEnums.getIncludeEnumsByDesc(spin_four_1.getSelectedItem().toString());
            CropNameEnums cropNameEnums = CropNameEnums.getCropNameEnumByDesc(spin_four_2.getSelectedItem().toString());
            query.append(includeEnums.getSymbol());
            query.append(cropNameEnums.getCropName()+":");
            query.append(text_4.getText().toString());
        } if(text_5.getText().toString()!=null&&!text_5.getText().toString().isEmpty()){
            IncludeEnums includeEnums = IncludeEnums.getIncludeEnumsByDesc(spin_five_1.getSelectedItem().toString());
            CropNameEnums cropNameEnums = CropNameEnums.getCropNameEnumByDesc(spin_five_2.getSelectedItem().toString());
            query.append(includeEnums.getSymbol());
            query.append(cropNameEnums.getCropName()+":");
            query.append(text_5.getText().toString());
        }
        return query.toString();
    }

    /**
     * 根据天气id请求城市天气信息。
     */
    public void requestWeather(final String query) {
        String weatherUrl =HOST_URL_SEARCH + "?wd="+query;
        System.out.println(weatherUrl);
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
                            mAdapter.clear();
                            Toast.makeText(HighSearchActivity.this, "无查找结果，请重新输入", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(HighSearchActivity.this, "请检查网络", Toast.LENGTH_SHORT).show();
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
