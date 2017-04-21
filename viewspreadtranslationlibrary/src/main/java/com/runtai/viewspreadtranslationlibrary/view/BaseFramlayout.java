package com.runtai.viewspreadtranslationlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class BaseFramlayout extends FrameLayout {

    public BaseFramlayout(Context context) {
        super(context);
    }

    public BaseFramlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseFramlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

}
