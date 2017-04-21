package com.runtai.testproject2.activity.vorolay;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;
import com.runtai.vorolaylibrary.VoronoiView;

public class CustomRegionsActivity extends BaseActivity {

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_custom_regions;
    }

    @Override
    protected void initView() {
        LayoutInflater layoutInflater = getLayoutInflater();

        VoronoiView voronoiView = (VoronoiView) findViewById(R.id.voronoi);

        for (int i = 0; i < 15; i++) {
            View view = layoutInflater.inflate(R.layout.item_voronoi_1, null, false);
            voronoiView.addView(view);

            int resourceId = getResources().getIdentifier("image"+((i%10)+1), "drawable", this.getPackageName());

            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            imageView.setImageResource(resourceId);

            final TextView textView = (TextView) view.findViewById(R.id.text);
            textView.setText("image "+i);

            Button button = (Button) view.findViewById(R.id.btn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CustomRegionsActivity.this, "Govno " + textView.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        voronoiView.setOnRegionClickListener(new VoronoiView.OnRegionClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.v("Region", "Region: " + position);
            }
        });
    }

}
