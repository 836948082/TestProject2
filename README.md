# TestProject2
# 测试工程2


# ViewSpreadTranslationController
# 波纹切换效果
https://github.com/zhangke3016/ViewSpreadTranslationController
http://blog.csdn.net/zhangke3016/article/details/54285749



滚动显示TextView的数字,支持自定义每个字符速度
<com.runtai.testproject2.view.RandomTextView
    android:id="@+id/rtv"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_centerHorizontal="true"
    android:layout_centerVertical="true"
    android:padding="0px"
    android:text="123456"
    android:textSize="28sp" />



所有位数相同速度滚动：

mRandomTextView.setText("876543");
mRandomTextView.setPianyilian(RandomTextView.ALL);
mRandomTextView.start();
从左到右侧由快到慢滚动：

mRandomTextView.setText("12313288");
mRandomTextView.setPianyilian(RandomTextView.FIRSTF_FIRST);
mRandomTextView.start();

从左到右侧由慢到快滚动：

mRandomTextView.setText("9078111123");
mRandomTextView.setPianyilian(RandomTextView.FIRSTF_LAST);
mRandomTextView.start();
自定义每位数字的速度滚动（每帧滚动的像素）：

mRandomTextView.setText("909878");
        pianyiliang[0] = 7;
        pianyiliang[1] = 6;
        pianyiliang[2] = 12;
        pianyiliang[3] = 8;
        pianyiliang[4] = 18;
        pianyiliang[5] = 10;
        mRandomTextView.setPianyilian(pianyiliang);
        mRandomTextView.start();
自定义滚动行数（默认10行）：

mRandomTextView.setMaxLine(20);
防止泄漏

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRandomTextView.destroy();
    }