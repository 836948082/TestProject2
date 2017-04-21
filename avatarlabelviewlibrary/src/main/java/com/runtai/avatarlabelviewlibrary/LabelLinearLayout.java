package com.runtai.avatarlabelviewlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * A ViewGroup's Label implementation View.
 * Other ViewGroup's Label implement can refer to this.
 */
public class LabelLinearLayout extends LinearLayout {
    private LabelViewHelper mLabelViewHelper;

    public LabelLinearLayout(Context context) {
        this(context, null);
    }

    public LabelLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLabelViewHelper = new LabelViewHelper(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mLabelViewHelper.drawLabel(this, canvas);
    }

    public void setTextContent(String content) {
        mLabelViewHelper.setTextContent(content);
        invalidate();
    }

    public void setTextTitle(String title) {
        mLabelViewHelper.setTextTitle(title);
        invalidate();
    }

    public void setLabelBackGroundColor(int color) {
        mLabelViewHelper.setLabelBackGroundColor(color);
        invalidate();
    }
}
