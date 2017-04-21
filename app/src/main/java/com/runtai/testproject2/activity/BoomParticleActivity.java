package com.runtai.testproject2.activity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.runtai.boomparticlelibrary.ExplosionField;
import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;

/**
 * @作者：高炎鹏
 * @日期：2017/1/12时间08:53
 * @描述：
 */
public class BoomParticleActivity extends BaseActivity{

    private ExplosionField mExplosionField;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_boomparticle;
    }

    @Override
    protected void initView() {
        mExplosionField = ExplosionField.attach2Window(this);
        addListener(findViewById(R.id.root));
    }

    private void addListener(View root) {
        if (root instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                addListener(parent.getChildAt(i));
            }
        } else {
            root.setClickable(true);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mExplosionField.explode(v);
                    v.setOnClickListener(null);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_reset) {
            View root = findViewById(R.id.root);
            reset(root);
            addListener(root);
            mExplosionField.clear();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void reset(View root) {
        if (root instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                reset(parent.getChildAt(i));
            }
        } else {
            root.setScaleX(1);
            root.setScaleY(1);
            root.setAlpha(1);
        }
    }

}
