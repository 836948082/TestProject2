package com.runtai.testproject2.activity;

import android.view.View;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;
import com.runtai.testproject2.view.RandomTextView;

/**
 * @作者：高炎鹏
 * @日期：2017/1/18时间09:43
 * @描述：滚动显示TextView的数字,支持自定义每个字符速度
 */
public class RandomTextViewActivity extends BaseActivity{

    private RandomTextView mRandomTextView;
    private int[] pianyiliang = new int[6];

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_randomtextview;
    }

    @Override
    protected void initView() {
        mRandomTextView = (RandomTextView) findViewById(R.id.rtv);
        pianyiliang[0] = 10;
        pianyiliang[1] = 9;
        pianyiliang[2] = 8;
        pianyiliang[3] = 7;
        pianyiliang[4] = 6;
        pianyiliang[5] = 5;
        mRandomTextView.setPianyilian(pianyiliang);
        mRandomTextView.start();
    }

    public void start(View v) {
        mRandomTextView.setText("876543");
        mRandomTextView.setPianyilian(RandomTextView.ALL);
        mRandomTextView.start();
    }

    public void start2(View v) {
        mRandomTextView.setText("909878");
        pianyiliang[0] = 7;
        pianyiliang[1] = 6;
        pianyiliang[2] = 12;
        pianyiliang[3] = 8;
        pianyiliang[4] = 18;
        pianyiliang[5] = 10;
        mRandomTextView.setMaxLine(50);
        mRandomTextView.setPianyilian(pianyiliang);
        mRandomTextView.start();
    }

    public void start3(View v) {
        mRandomTextView.setText("9078111123");
        mRandomTextView.setPianyilian(RandomTextView.FIRSTF_LAST);
        mRandomTextView.start();
    }

    public void start4(View v) {
        mRandomTextView.setText("12313288");
        mRandomTextView.setPianyilian(RandomTextView.FIRSTF_FIRST);
        mRandomTextView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRandomTextView.destroy();
    }

}
