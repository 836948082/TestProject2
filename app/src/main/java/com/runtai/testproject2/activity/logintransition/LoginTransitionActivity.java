package com.runtai.testproject2.activity.logintransition;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;
import com.runtai.testproject2.view.ProgressButton;

/**
 * @作者：高炎鹏
 * @日期：2017/1/13时间13:54
 * @描述：
 */
public class LoginTransitionActivity extends BaseActivity {

    private Intent intent;
    private ProgressButton pb_button;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            pb_button.stopAnim(new ProgressButton.OnStopAnim() {
                @Override
                public void Stop() {
                    intent = new Intent();
                    intent.setClass(LoginTransitionActivity.this, LoginTransitionSecondActivity.class);
                    startActivity(intent);
                }
            });
        }
    };

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_logintransition;
    }

    @Override
    protected void initView() {
        pb_button = (ProgressButton) findViewById(R.id.pb_btn);
        pb_button.setBgColor(Color.RED);
        pb_button.setTextColor(Color.WHITE);
        pb_button.setProColor(Color.WHITE);
        pb_button.setButtonText("Login in");
        pb_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pb_btn:
                pb_button.startAnim();
                Message msg = mHandler.obtainMessage();
                mHandler.sendMessageDelayed(msg, 1500);
                break;
            default:
                break;
        }
    }

}
