package com.runtai.testproject2.activity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;
import com.runtai.testproject2.view.HorizontalListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @作者：高炎鹏
 * @日期：2017/3/9时间17:39
 * @描述：水平自动循环滚动ListView
 */
public class HorizontalListViewActivity extends BaseActivity {

    private HorizontalListView horizontal_listview;
    private List<String> list;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_horizontallistview;
    }

    @Override
    protected void initView() {
        horizontal_listview = (HorizontalListView) findViewById(R.id.horizontal_listview);
        getData();
        setData();
    }

    private void getData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Text" + i);
        }
    }

    private void setData() {
        HorizontalListViewAdapter adapter = new HorizontalListViewAdapter(this, list);
        horizontal_listview.setAdapter(adapter);

        View view = adapter.getView(0, null, horizontal_listview);
        view.measure(0, 0);
        width = view.getMeasuredWidth();

        Timer timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                Log.e("run", "run");
            }
        };
        timer.schedule(task, 1000 * 2, 1000 * 2); // 2秒后
    }

    TimerTask task;
    int width = 0;
    int index = 0;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            index++;
            if (index >= list.size()) {
                index = 0;
            }
            Log.e("index", "index" + index);
//            horizontal_listview.setSelection(index);
            horizontal_listview.scrollTo(index * width);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        task.cancel();
    }
}
