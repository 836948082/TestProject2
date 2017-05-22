package com.runtai.testproject2.activity.fastblur;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;

/**
 * @作者：高炎鹏
 * @日期：2017/5/22时间11:52
 * @描述：
 */

public class FastBlurActivity extends BaseActivity {

    private static final String TAG = "FastBlur";

    private ImageView imageView;
    private FrameLayout frameLayout;
    private RelativeLayout relativeLayout;

    private ImageView imageView2;
    private FrameLayout frameLayout2;
    private RelativeLayout relativeLayout2;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_fastblur;
    }

    @Override
    protected void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        frameLayout2 = (FrameLayout) findViewById(R.id.frameLayout2);
        relativeLayout2 = (RelativeLayout) findViewById(R.id.relativeLayout2);

        String url = "http://tupian.enterdesk.com/2013/mxy/12/10/15/3.jpg";
        ImageLoader.getInstance().displayImage(url, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                attachImage(loadedImage, relativeLayout, frameLayout);

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

        String url2 = "http://pic1a.nipic.com/2008-12-23/2008122319435535_2.jpg";
        ImageLoader.getInstance().displayImage(url2, imageView2, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                attachImage(loadedImage, relativeLayout2, frameLayout2);

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

    }

    private void attachImage(Bitmap loadedImage, ViewGroup parent, ViewGroup child) {
        long time = System.currentTimeMillis();

        Bitmap bmp = FastBlur.doBlur(loadedImage);

        Log.i(TAG, "bmp width:" + bmp.getWidth());
        Log.i(TAG, "bmp height:" + bmp.getHeight());
        Log.i(TAG, "frameLayout width:" + frameLayout.getWidth());
        Log.i(TAG, "frameLayout height:" + child.getHeight());


        float rates = (float) bmp.getHeight() / (float) parent.getHeight();

        int y = (int) (rates * (child.getHeight()));

        Log.i(TAG, " relativeLayout.getHeight():" + parent.getHeight());
        Log.i(TAG, "y:" + y);

        int width = bmp.getWidth() < child.getWidth() ? bmp.getWidth() : child.getWidth();
        int height = child.getHeight() < y ? child.getHeight() : y;

        Log.i(TAG, "bmp.getHeight() - y：" + (bmp.getHeight() - y));

        Bitmap newBitmap = Bitmap.createBitmap(bmp, 0, bmp.getHeight() - y, width, height);
        child.setBackgroundDrawable(new BitmapDrawable(newBitmap));

        Log.i(TAG, "spend time:" + (System.currentTimeMillis() - time));
    }

}
