package com.runtai.testproject2.cehua;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.runtai.library.SwipeBackHelper;
import com.runtai.testproject2.R;

public abstract class BaseActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(true)
                .setSwipeEdgePercent(0.5f)
                .setSwipeSensitivity(0.5f)
                .setClosePercent(0.5f)
                .setSwipeRelateEnable(true).setSwipeSensitivity(1);

        beforeSetContent();
        setContentView(getView());
        init();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

    /**
     * 返回键调用此方法
     */
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        overridePendingTransition(0, R.anim.activity_close);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.activity_close);
    }

    public void skip(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.activity_open, 0);
    }

    private void init() {
        getIntentInfo();
        initViews();
        setListener();
        getDatas();
    }

    private void initViews() {
        getWindow().setWindowAnimations(R.style.ActivityAnimation);

        /**
         * 沉浸式导航栏
         */
        //透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        initView();
    }

    /**
     * 获取 意图 intent中的数据，如果不需要获取，则可以不做处理
     */
    protected void getIntentInfo() {
    }

    /**
     * 设置监听事件，如果不用设置，则不用设置
     */
    protected void setListener() {
    }

    /**
     * 获取数据,根据实际项目，放在onResume或者onPause中
     */
    protected void getDatas() {
    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void doBeforeSetContent() {
        // TODO Auto-generated method stub
        super.doBeforeSetContent();
        beforeSetContent();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    protected int getContentViewID() {
        return getView();
    }

    /**
     * 根据资源id 获取View ，不用强制转换
     */
    protected <A extends View> A getView(int id) {
        return (A) findViewById(id);
    }

    protected abstract void beforeSetContent();
    protected abstract int getView();
    protected abstract void initView();

    /**
     * 以下实现点击编辑框外空白位置 隐藏软键盘
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                hideSoftInput(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     *
     * @param v
     * @param event
     * @return boolean
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left + v.getWidth();
            // 点击EditText的事件，忽略它。
            return !(event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom);
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
