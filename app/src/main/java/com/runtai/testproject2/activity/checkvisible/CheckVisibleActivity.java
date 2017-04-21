package com.runtai.testproject2.activity.checkvisible;

import android.util.Log;
import android.widget.TextView;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;

import static com.runtai.testproject2.activity.checkvisible.Util.checkIsVisible;

/**
 * @作者：高炎鹏
 * @日期：2017/2/9时间11:46
 * @描述：
 */

public class CheckVisibleActivity extends BaseActivity implements MyScrollView.OnScrollChangeListener {

    private Boolean isFirst = true;

    public MyScrollView scrollView;
    public TextView tvRemark;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_checkvisible;
    }

    @Override
    protected void initView() {
        scrollView = (MyScrollView) findViewById(R.id.scrollView);
        tvRemark = (TextView) findViewById(R.id.tv_remark);
        scrollView.setOnScrollChangeListener(this);
    }

    @Override
    public void onScrollChange(MyScrollView view, int x, int y, int oldx, int oldy) {
        if (checkIsVisible(this, tvRemark)) {
            Log.e("显示", "控件在屏幕范围内");
        } else {
            Log.e("隐藏", "控件不在屏幕范围内");
        }
    }

    @Override
    public void onScrollBottomListener() {
        Log.i("slantech", "滑动到底部");
    }

    @Override
    public void onScrollTopListener() {
        Log.i("slantech", "滑动到顶部");
    }

}
