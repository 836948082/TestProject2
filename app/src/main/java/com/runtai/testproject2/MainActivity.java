package com.runtai.testproject2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.runtai.library.SwipeBackHelper;
import com.runtai.testproject2.activity.AvatarLabelViewActivity;
import com.runtai.testproject2.activity.BoomParticleActivity;
import com.runtai.testproject2.activity.HorizontalListViewActivity;
import com.runtai.testproject2.activity.JumpActivity;
import com.runtai.testproject2.activity.RandomTextViewActivity;
import com.runtai.testproject2.activity.SpannableStringActivity;
import com.runtai.testproject2.activity.SweetAlertDialogActivity;
import com.runtai.testproject2.activity.SwitchIconViewActivity;
import com.runtai.testproject2.activity.TagsEditTextActivity;
import com.runtai.testproject2.activity.baiduload.BaiduLoadingActivity;
import com.runtai.testproject2.activity.checkvisible.CheckVisibleActivity;
import com.runtai.testproject2.activity.coverflow.CoverFlowActivity;
import com.runtai.testproject2.activity.fastblur.FastBlurActivity;
import com.runtai.testproject2.activity.image_gallery.ImageGalleryActivity;
import com.runtai.testproject2.activity.logintransition.LoginTransitionActivity;
import com.runtai.testproject2.activity.viewspread.ViewSpreadActivity;
import com.runtai.testproject2.activity.vorolay.VorolayActivity;
import com.runtai.testproject2.cehua.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button vorolay, spread, boomparticle, avatarlabelview, logintransition, switchicon, randomtextview,
            baiduloading, coverflow, checkvisible, horizontalListView, sweetalertdialog, jump, test, spannable,
            tagsedittext, image_gallery, fastblur;
    private Intent intent;
    private long exitTime = 0;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(false);
        vorolay = (Button) findViewById(R.id.vorolay);
        vorolay.setOnClickListener(this);
        spread = (Button) findViewById(R.id.spread);
        spread.setOnClickListener(this);
        boomparticle = (Button) findViewById(R.id.boomparticle);
        boomparticle.setOnClickListener(this);
        avatarlabelview = (Button) findViewById(R.id.avatarlabelview);
        avatarlabelview.setOnClickListener(this);
        logintransition = (Button) findViewById(R.id.logintransition);
        logintransition.setOnClickListener(this);
        switchicon = (Button) findViewById(R.id.switchicon);
        switchicon.setOnClickListener(this);
        randomtextview = (Button) findViewById(R.id.randomtextview);
        randomtextview.setOnClickListener(this);
        baiduloading = (Button) findViewById(R.id.baiduloading);
        baiduloading.setOnClickListener(this);
        coverflow = (Button) findViewById(R.id.coverflow);
        coverflow.setOnClickListener(this);
        checkvisible = (Button) findViewById(R.id.checkvisible);
        checkvisible.setOnClickListener(this);
        horizontalListView = (Button) findViewById(R.id.horizontalListView);
        horizontalListView.setOnClickListener(this);
        sweetalertdialog = (Button) findViewById(R.id.sweetalertdialog);
        sweetalertdialog.setOnClickListener(this);
        jump = (Button) findViewById(R.id.jump);
        jump.setOnClickListener(this);
        test = (Button) findViewById(R.id.test);
        test.setOnClickListener(this);
        spannable = (Button) findViewById(R.id.spannable);
        spannable.setOnClickListener(this);
        tagsedittext = (Button) findViewById(R.id.tagsedittext);
        tagsedittext.setOnClickListener(this);
        image_gallery = (Button) findViewById(R.id.image_gallery);
        image_gallery.setOnClickListener(this);
        fastblur = (Button) findViewById(R.id.fastblur);
        fastblur.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vorolay:
                intent = new Intent(MainActivity.this, VorolayActivity.class);
                skip(intent);
                break;
            case R.id.spread://扩展动画
                intent = new Intent(MainActivity.this, ViewSpreadActivity.class);
                skip(intent);
                break;
            case R.id.boomparticle://粒子粉碎效果
                intent = new Intent(MainActivity.this, BoomParticleActivity.class);
                skip(intent);
                break;
            case R.id.avatarlabelview://Label(贴纸效果)
                intent = new Intent(MainActivity.this, AvatarLabelViewActivity.class);
                skip(intent);
                break;
            case R.id.logintransition://登录转场动画
                intent = new Intent(MainActivity.this, LoginTransitionActivity.class);
                skip(intent);
                break;
            case R.id.switchicon://图标效果开关控件
                intent = new Intent(MainActivity.this, SwitchIconViewActivity.class);
                skip(intent);
                break;
            case R.id.randomtextview://滚动显示TextView的数字,支持自定义每个字符速度
                intent = new Intent(MainActivity.this, RandomTextViewActivity.class);
                skip(intent);
                break;
            case R.id.baiduloading://仿百度加载动画
                intent = new Intent(MainActivity.this, BaiduLoadingActivity.class);
                skip(intent);
                break;
            case R.id.coverflow://图片墙(CoverFlow)水平滑动效果
                intent = new Intent(MainActivity.this, CoverFlowActivity.class);
                skip(intent);
                break;
            case R.id.checkvisible://判断控件是否在屏幕范围内
                intent = new Intent(MainActivity.this, CheckVisibleActivity.class);
                skip(intent);
                break;
            case R.id.horizontalListView://水平自动循环滚动ListView
                intent = new Intent(MainActivity.this, HorizontalListViewActivity.class);
                skip(intent);
                break;
            case R.id.sweetalertdialog:
                intent = new Intent(MainActivity.this, SweetAlertDialogActivity.class);
                skip(intent);
                break;
            case R.id.jump:
//                intent = new Intent(MainActivity.this, JumpActivity.class);
//                skip(intent);
                /**
                 * 启动广播
                 */
                Intent it = new Intent();
                if (one) {
                    it.setAction(LOG_TAG);
                } else {
                    it.setAction(LOG_TAG2);
                }
                sendBroadcast(it);
                one = !one;
                break;
            case R.id.test:
                intent = new Intent(MainActivity.this, TestActivity.class);
                skip(intent);
                break;
            case R.id.spannable:
                intent = new Intent(MainActivity.this, SpannableStringActivity.class);
                skip(intent);
                break;
            case R.id.tagsedittext:
                intent = new Intent(MainActivity.this, TagsEditTextActivity.class);
                skip(intent);
                break;
            case R.id.image_gallery:
                intent = new Intent(MainActivity.this, ImageGalleryActivity.class);
                skip(intent);
                break;
            case R.id.fastblur:
                intent = new Intent(MainActivity.this, FastBlurActivity.class);
                skip(intent);
                break;
            default:
                break;
        }
    }
    boolean one = true;
    private final static String LOG_TAG = "com.runtai.testproject2";
    private final static String LOG_TAG2 = "com.runtai.testproject20";

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter counterActionFilter = new IntentFilter(LOG_TAG);
        registerReceiver(receive, counterActionFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receive);
    }

    private BroadcastReceiver receive = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.runtai.testproject2")) {
                Toast.makeText(context, "Taction", Toast.LENGTH_SHORT).show();

                intent = new Intent(context, JumpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }
    };


    /**
     * // * 菜单、返回键响应 //
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 双击退出程序函数
     */
    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
