package com.runtai.testproject2.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.runtai.testproject2.R;

import java.util.List;

/**
 * @作者：高炎鹏
 * @日期：2017/3/9时间17:49
 * @描述：水平自动循环滚动ListView适配器
 */
public class HorizontalListViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public HorizontalListViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int index, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.horizontal_adapter_item, null);
            holder.hori_bt = (TextView) view.findViewById(R.id.hori_bt);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.hori_bt.setText(list.get(index));
        return view;
    }

    static class ViewHolder{
        TextView hori_bt;
    }

}
