package com.runtai.testproject2.activity.vorolay;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.runtai.testproject2.R;
import com.runtai.testproject2.activity.vorolay.util.Utils;
import com.runtai.testproject2.cehua.BaseActivity;
import com.runtai.vorolaylibrary.VoronoiView;

public class SimpleDiagramActivity extends BaseActivity {

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_simple_diagram;
    }

    @Override
    protected void initView() {
        LayoutInflater layoutInflater = getLayoutInflater();

        VoronoiView voronoiView = (VoronoiView) findViewById(R.id.voronoi);

        for (int i = 0; i < 15; i++) {
            View view = layoutInflater.inflate(R.layout.item_voronoi_2, null, false);
            voronoiView.addView(view);

            View layout = view.findViewById(R.id.layout);
            int randomColor = Utils.randomColor();
            layout.setBackgroundColor(randomColor);
        }

        voronoiView.setOnRegionClickListener(new VoronoiView.OnRegionClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(SimpleDiagramActivity.this, "position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
