package com.runtai.testproject2.activity.checkvisible;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * @作者：高炎鹏
 * @日期：2017/2/9时间11:44
 * @描述：重写onScrollChanged用于监听控件内是否在屏幕范围内、是否滚动到顶部、是否滚动到底部
 */
public class MyScrollView extends ScrollView {

    private OnScrollChangeListener onScrollChangeListener;
    private View contentView;
    private boolean isScrolledToTop;
    private boolean isScrolledToBottom;

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.onScrollChangeListener = onScrollChangeListener;
    }

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            contentView = getChildAt(0);
        }
    }

    /**
     * l当前水平滚动的开始位置
     * t当前的垂直滚动的开始位置
     * oldl上一次水平滚动的位置。
     * oldt上一次垂直滚动的位置。
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, l, t, oldl, oldt);
        }
        isScrolledToBottom = false;
        isScrolledToTop = false;
        if (contentView.getBottom() - (getHeight() + getScrollY()) == 0) {
            isScrolledToBottom = true;
            if (onScrollChangeListener != null)
                onScrollChangeListener.onScrollBottomListener();
        } else if (getScrollY() == 0) {
            isScrolledToTop = true;
            if (onScrollChangeListener != null)
                onScrollChangeListener.onScrollTopListener();
        }
    }

    public boolean isScrolledToTop() {
        return isScrolledToTop;
    }

    public boolean isScrolledToBottom() {
        return isScrolledToBottom;
    }

    public interface OnScrollChangeListener {
        void onScrollChange(MyScrollView view, int x, int y, int oldx, int oldy);

        void onScrollBottomListener();

        void onScrollTopListener();
    }

}