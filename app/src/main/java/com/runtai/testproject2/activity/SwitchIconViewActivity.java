package com.runtai.testproject2.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.runtai.switchiconviewlibrary.SwitchIconView;
import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;

/**
 * @作者：高炎鹏
 * @日期：2017/1/13时间14:32
 * @描述：图标效果开关控件
 */
public class SwitchIconViewActivity extends BaseActivity {

    private SwitchIconView switchIcon1;
    private SwitchIconView switchIcon2;
    private SwitchIconView switchIcon3;
    private LinearLayout button1;
    private LinearLayout button2;
    private LinearLayout button3;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_switchiconview;
    }

    @Override
    protected void initView() {
        switchIcon1 = (SwitchIconView) findViewById(R.id.switchIconView1);
        switchIcon2 = (SwitchIconView) findViewById(R.id.switchIconView2);
        switchIcon3 = (SwitchIconView) findViewById(R.id.switchIconView3);
        button1 = (LinearLayout) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (LinearLayout) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (LinearLayout) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                switchIcon1.switchState();
                break;
            case R.id.button2:
                switchIcon2.switchState();
                break;
            case R.id.button3:
                switchIcon3.switchState();
                break;
            default:
                break;
        }
    }

}
