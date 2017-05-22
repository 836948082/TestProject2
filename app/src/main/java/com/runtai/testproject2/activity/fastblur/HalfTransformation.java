package com.runtai.testproject2.activity.fastblur;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.squareup.picasso.Transformation;

/**
 * @作者：高炎鹏
 * @日期：2017/2/7时间10:11
 * @描述：
 */

public class HalfTransformation implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        Matrix matrix = new Matrix();
        matrix.postScale(0.8f, 0.8f);

        Bitmap newBitmap = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
        source.recycle();//一定要回收原图
        return newBitmap;
    }

    @Override
    public String key() {
        return "HalfTransformation";
    }
}