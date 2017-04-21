package com.runtai.testproject2.activity.viewspread;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;
import com.runtai.viewspreadtranslationlibrary.helper.BaseViewHelper;

/**
 * @作者：高炎鹏
 * @日期：2017/1/11时间15:05
 * @描述：扩展动画
 */
public class ViewSpreadActivity extends BaseActivity {

    private Button btn_translation1, btn_translation2, btn_translation3, btn_translation4, btn_translation5, btn_translation6;
    private ImageButton ib_customImage;
    private FloatingActionButton fab;

    private View view_inflate;

    BaseViewHelper helper;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_viewspread;
    }

    @Override
    protected void initView() {
        btn_translation1 = getView(R.id.btn_translation1);
        btn_translation1.setOnClickListener(this);
        btn_translation2 = getView(R.id.btn_translation2);
        btn_translation2.setOnClickListener(this);
        btn_translation3 = getView(R.id.btn_translation3);
        btn_translation3.setOnClickListener(this);

        ib_customImage = getView(R.id.ib_customImage);
        ib_customImage.setOnClickListener(this);

        btn_translation4 = getView(R.id.btn_translation4);
        btn_translation4.setOnClickListener(this);
        btn_translation5 = getView(R.id.btn_translation5);
        btn_translation5.setOnClickListener(this);
        btn_translation6 = getView(R.id.btn_translation6);
        btn_translation6.setOnClickListener(this);

        fab = getView(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            //两个页面之间跳转
            case R.id.btn_translation1:
            case R.id.btn_translation2:
            case R.id.btn_translation3:
            case R.id.ib_customImage:
            case R.id.btn_translation4:
            case R.id.fab:
                Intent intent = new Intent(ViewSpreadActivity.this, SecondActivity.class);
                intent.putExtra("id", view.getId());
                new BaseViewHelper
                        .Builder(ViewSpreadActivity.this, view)
                        .startActivity(intent);
                break;
            //两个视图之间跳转
            case R.id.btn_translation5:
                view_inflate = View.inflate(this, R.layout.layout_second, null);
                helper = new BaseViewHelper.Builder(this, view)
                        .setTranslationView(R.id.iv_second)
                        .setEndView(view_inflate)
                        .create();
                break;
            case R.id.btn_translation6:
                view_inflate = View.inflate(this, R.layout.layout_second, null);
                helper = new BaseViewHelper.Builder(this, view)
                        .setEndView(view_inflate)
                        //.isShowTransition(false)//是否显示过渡动画(默认是true)
                        .create();
                ((TextView) view_inflate.findViewById(R.id.tv_message)).setText("我还在第一个页面");
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (helper != null && helper.isShowing()) {
            helper.back();
        } else {
            super.onBackPressed();
        }
    }
}
