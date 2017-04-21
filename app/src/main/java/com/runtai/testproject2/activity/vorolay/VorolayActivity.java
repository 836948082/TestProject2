package com.runtai.testproject2.activity.vorolay;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;

/**
 * @作者：高炎鹏
 * @日期：2017/1/10时间15:22
 * @描述：罗诺伊图
 */
public class VorolayActivity extends BaseActivity implements View.OnClickListener {

    private Button btnSimple, btnSettings, btnSimpleList, btnCustomRegions, btnAddRegion;
    private Intent intent;


    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_vorolay;
    }

    @Override
    protected void initView() {
        btnSimple = (Button) findViewById(R.id.btn_simple_diagram);
        btnSimple.setOnClickListener(this);

        btnSettings = (Button) findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(this);

        btnSimpleList = (Button) findViewById(R.id.btn_simple_list);
        btnSimpleList.setOnClickListener(this);

        btnCustomRegions = (Button) findViewById(R.id.btn_custom_regions);
        btnCustomRegions.setOnClickListener(this);

        btnAddRegion = (Button) findViewById(R.id.btn_add_region);
        btnAddRegion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_simple_diagram:
                intent = new Intent(VorolayActivity.this, SimpleDiagramActivity.class);
                skip(intent);
                break;
            case R.id.btn_settings:
                intent = new Intent(VorolayActivity.this, SettingsActivity.class);
                skip(intent);
                break;
            case R.id.btn_simple_list:
                intent = new Intent(VorolayActivity.this, SimpleListActivity.class);
                skip(intent);
                break;
            case R.id.btn_custom_regions:
                intent = new Intent(VorolayActivity.this, CustomRegionsActivity.class);
                skip(intent);
                break;
            case R.id.btn_add_region:
                intent = new Intent(VorolayActivity.this, AddRegionsActivity.class);
                skip(intent);
                break;
            default:
                break;
        }
    }

}
