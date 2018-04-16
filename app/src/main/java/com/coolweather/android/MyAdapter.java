package com.coolweather.android;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolweather.android.pojo.CropDetail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jay on 2015/9/21 0021.
 */
public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<CropDetail> mData;

    public MyAdapter() {
    }

    public MyAdapter(ArrayList<CropDetail> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        if(mData==null){
            return 0;
        }
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
            holder = new ViewHolder();
            holder.search_title = (TextView) convertView.findViewById(R.id.search_title);
            holder.search_context = (TextView) convertView.findViewById(R.id.search_context);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.search_title.setText(Html.fromHtml(mData.get(position).getCropName()==null?"":mData.get(position).getCropName()));
        holder.search_context.setText(Html.fromHtml(mData.get(position).getIntroduction()==null?"":mData.get(position).getIntroduction()));
        return convertView;
    }

    //添加一个元素
    public void add(CropDetail data) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    public void remove(CropDetail data) {
        if(mData != null) {
            mData.remove(data);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if(mData != null) {
            mData.clear();
        }
        notifyDataSetChanged();
    }
    private class ViewHolder {
        TextView search_title;
        TextView search_context;
    }

}
