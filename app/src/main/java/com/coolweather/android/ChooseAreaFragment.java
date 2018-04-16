package com.coolweather.android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.pojo.CropDetail;
import com.coolweather.android.pojo.CropDetailImg;
import com.coolweather.android.pojo.Label;
import com.coolweather.android.pojo.LabelDetail;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.Utility;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ChooseAreaFragment extends Fragment {

    private static final String TAG = "ChooseAreaFragment";

    public static final int LEVEL_PROVINCE = 0;

    public static final int LEVEL_CITY = 1;

    public static final int LEVEL_COUNTY = 2;

    private ProgressDialog progressDialog;

    private TextView titleText;

    private Button backButton;

    private ListView listView;

    private ArrayAdapter<String> adapter;

    private List<String> dataList = new ArrayList<>();

    /**
     * 种类大类名称,如： 农作物—禾本科
     */
    private List<Label> labelList;

    /**
     * 种类大类下细分品种名称水稻 小麦 大麦 玉米 高梁
     */
    private List<LabelDetail> labelDetailList;

    /**
     * 每种细分类品下 病虫害名称信息
     */
    private List<CropDetail> cropDetailList;

    /**
     * 每种细分类品下 图片的列别
     */
    private List<CropDetailImg> cropDetailImgList;
    /**
     * 选中的种类大类
     */
    private Label selectedLabel;

    /**
     * 选中的细分品种
     */
    private LabelDetail selectedLabelDetail;

    /**
     * 当前选中的级别
     */
    private int currentLevel;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_area, container, false);
        titleText = (TextView) view.findViewById(R.id.title_text);
        backButton = (Button) view.findViewById(R.id.back_button);
        listView = (ListView) view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == LEVEL_PROVINCE) {
                    selectedLabel = labelList.get(position);
                    queryCities();
                } else if (currentLevel == LEVEL_CITY) {
                    selectedLabelDetail = labelDetailList.get(position);
                    queryCounties();
                } else if (currentLevel == LEVEL_COUNTY) {
                    Long  cropId = cropDetailList.get(position).getCropId();
                    if (getActivity() instanceof MainActivity) {
                        Intent intent = new Intent(getActivity(), WeatherActivity.class);
                        intent.putExtra("cropId", cropId);
                        startActivity(intent);
                        getActivity().finish();
                    } else if (getActivity() instanceof WeatherActivity) {
                        WeatherActivity activity = (WeatherActivity) getActivity();
                        activity.drawerLayout.closeDrawers();
                        activity.swipeRefresh.setRefreshing(true);
                        activity.requestWeather(cropId);
                    }
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentLevel == LEVEL_COUNTY) {
                    queryCities();
                } else if (currentLevel == LEVEL_CITY) {
                    queryProvinces();
                }
            }
        });
        queryProvinces();
    }

    /**
     * 查询全国所有的省，优先从数据库查询，如果没有查询到再去服务器上查询。
     */
    private void queryProvinces() {
        titleText.setText("所属品类");
        backButton.setVisibility(View.GONE);
//        DataSupport.deleteAll(Label.class,null);
        labelList = DataSupport.findAll(Label.class);
        if (labelList.size() > 0) {
            dataList.clear();
            for (Label label : labelList) {
                dataList.add(label.getTypeName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_PROVINCE;
        } else {
            queryFromServer(HOST_URL_LABEL_VIEW, "province");
        }
    }

    /**
     * 查询选中省内所有的市，优先从数据库查询，如果没有查询到再去服务器上查询。
     */
    private void queryCities() {
        titleText.setText(selectedLabel.getTypeName());
        backButton.setVisibility(View.VISIBLE);
        labelDetailList= DataSupport.where("labelid = ?", String.valueOf(selectedLabel.getLabelId())).find(LabelDetail.class);
        if (labelDetailList.size() > 0) {
            dataList.clear();
            for (LabelDetail labelDetail : labelDetailList) {
                dataList.add(labelDetail.getLabelName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_CITY;
        } else {
            long labelId = selectedLabel.getLabelId();
            String address = HOST_URL_LABEL_DETAIL + "?id="+labelId;
            queryFromServer(address, "city");
        }
    }

    /**
     * 查询选中市内所有的县，优先从数据库查询，如果没有查询到再去服务器上查询。
     */
    private void queryCounties() {
        titleText.setText(selectedLabelDetail.getLabelName());
        backButton.setVisibility(View.VISIBLE);
        cropDetailList = DataSupport.where("labeldetail = ?", String.valueOf(selectedLabelDetail.getLabelDetailId())).find(CropDetail.class);
        if (cropDetailList.size() > 0) {
            dataList.clear();
            for (CropDetail cropDetail : cropDetailList) {
                dataList.add(cropDetail.getCropName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_COUNTY;
        } else {
            String address = HOST_URL_TYPE_VIEW + "?id="+selectedLabelDetail.getLabelDetailId();
            queryFromServer(address, "county");
        }
    }

    /**
     * 根据传入的地址和类型从服务器上查询省市县数据。
     */
    private void queryFromServer(String address, final String type) {
        showProgressDialog();
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                    boolean result = false;
                if ("province".equals(type)) {
                    result = Utility.handleProvinceResponse(responseText);
                } else if ("city".equals(type)) {
                    result = Utility.handleCityResponse(responseText);
                } else if ("county".equals(type)) {
                    result = Utility.handleCountyResponse(responseText);
                }
                if (result) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                            if ("province".equals(type)) {
                                queryProvinces();
                            } else if ("city".equals(type)) {
                                queryCities();
                            } else if ("county".equals(type)) {
                                queryCounties();
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                // 通过runOnUiThread()方法回到主线程处理逻辑
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /**
     * 显示进度对话框
     */
    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    /**
     * 关闭进度对话框
     */
    private void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

}
