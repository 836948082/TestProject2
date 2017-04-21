package com.runtai.testproject2.activity;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;

/**
 * @作者：高炎鹏
 * @日期：2017/3/22时间17:23
 * @描述：
 */

public class SpannableStringActivity extends BaseActivity {

    private TextView span_tv;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_spannablestring;
    }

    @Override
    protected void initView() {
        span_tv = (TextView) findViewById(R.id.span_tv);
        addspannablestringbuilderSpan();

        underline_btn = (Button) this.findViewById(R.id.underline_btn);
        strike_btn = (Button) this.findViewById(R.id.strike_btn);
        style_btn = (Button) this.findViewById(R.id.style_btn);
        font_btn = (Button) this.findViewById(R.id.font_btn);
        color_btn1 = (Button) this.findViewById(R.id.color_btn1);
        color_btn2 = (Button) this.findViewById(R.id.color_btn2);
        url_btn = (Button) this.findViewById(R.id.url_btn);
        image_btn = (Button) this.findViewById(R.id.image_btn);
        maskfilte_btn = (Button) this.findViewById(R.id.maskfilte_btn);
        Rasterizer_btn = (Button) this.findViewById(R.id.Rasterizer_btn);
        spannablestringbuilder = (Button) this.findViewById(R.id.spannablestringbuilder);

        underline_btn.setOnClickListener(this);
        strike_btn.setOnClickListener(this);
        style_btn.setOnClickListener(this);
        font_btn.setOnClickListener(this);
        color_btn1.setOnClickListener(this);
        color_btn2.setOnClickListener(this);
        url_btn.setOnClickListener(this);
        image_btn.setOnClickListener(this);
        maskfilte_btn.setOnClickListener(this);
        Rasterizer_btn.setOnClickListener(this);
        spannablestringbuilder.setOnClickListener(this);
    }

    /**
     * spannablestringbuilder
     */
    private void addspannablestringbuilderSpan() {
        SpannableStringBuilder ssb = new SpannableStringBuilder("红色超链接斜体删除线绿色下划线图片:.");
        //用颜色标记文本
        ssb.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //setSpan时需要指定的 flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括).
        //用超链接标记文本
        ssb.setSpan(new URLSpan("tel:4155551212"), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用样式标记文本（斜体）
        ssb.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用删除线标记文本
        ssb.setSpan(new StrikethroughSpan(), 7, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用下划线标记文本
        ssb.setSpan(new UnderlineSpan(), 10, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用颜色标记
        ssb.setSpan(new ForegroundColorSpan(Color.GREEN), 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //获取Drawable资源
        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        //创建ImageSpan
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        //用ImageSpan替换文本
        ssb.setSpan(span, 18, 19, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.setText(ssb);
        span_tv.setMovementMethod(LinkMovementMethod.getInstance()); //实现文本的滚动
    }

    private Button underline_btn;
    private Button strike_btn;
    private Button style_btn;
    private Button font_btn;
    private Button color_btn1;
    private Button color_btn2;
    private Button url_btn;
    private Button image_btn;
    private Button maskfilte_btn;
    private Button Rasterizer_btn;
    private Button spannablestringbuilder;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.underline_btn:
                addUnderLineSpan();
                break;
            case R.id.strike_btn:
                addStrikeSpan();
                break;
            case R.id.style_btn:
                addStyleSpan();
                break;
            case R.id.font_btn:
                addFontSpan();
                break;
            case R.id.color_btn1:
                addForeColorSpan();
                break;
            case R.id.color_btn2:
                addBackColorSpan();
                break;
            case R.id.url_btn:
                addUrlSpan();
                break;
            case R.id.image_btn:
                addImageSpan();
                break;
            case R.id.maskfilte_btn:
                addmaskfilteSpan();
                break;
            case R.id.Rasterizer_btn:
                addRasterizerSpan();
                break;
            case R.id.spannablestringbuilder:
                addspannablestringbuilderSpan();
                break;
        }
    }

    /*
     * Spannable.SPAN_EXCLUSIVE_EXCLUSIVE：前后都不包括，即在指定范围的前面和后面插入新字符都不会应用新样式
     * Spannable.SPAN_EXCLUSIVE_INCLUSIVE ：前面不包括，后面包括。即仅在范围字符的后面插入新字符时会应用新样式
     * Spannable.SPAN_INCLUSIVE_EXCLUSIVE ：前面包括，后面不包括。
     * Spannable.SPAN_INCLUSIVE_INCLUSIVE ：前后都包括。
     */

    /**
     * 光栅效果
     */
    private void addRasterizerSpan() {
        SpannableString spanText = new SpannableString("StrikethroughSpan");
        spanText.setSpan(new StrikethroughSpan(), 0, 7, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanText);

    }

    /**
     * 修饰效果
     */
    private void addmaskfilteSpan() {
        SpannableString spanText = new SpannableString("benzlocke6666666");
        int length = spanText.length();
        //模糊(BlurMaskFilter)
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(3, BlurMaskFilter.Blur.OUTER));
        spanText.setSpan(maskFilterSpan, 0, length - 10, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        //浮雕(EmbossMaskFilter)
        maskFilterSpan = new MaskFilterSpan(new EmbossMaskFilter(new float[]{1, 1, 3}, 1.5f, 8, 3));
        spanText.setSpan(maskFilterSpan, length - 10, length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanText);

    }

    /**
     * 超链接
     */
    private void addUrlSpan() {
        SpannableString spanString = new SpannableString("超链接");
        URLSpan span = new URLSpan("tel:0123456789");
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanString);

        span_tv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * 文字背景颜色
     */
    private void addBackColorSpan() {
        SpannableString spanString = new SpannableString("文字背景颜色");
        BackgroundColorSpan span = new BackgroundColorSpan(Color.YELLOW);
        spanString.setSpan(span, 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanString);
    }

    /**
     * 文字颜色
     */
    private void addForeColorSpan() {
        SpannableString spanString = new SpannableString("文字颜色");
        ForegroundColorSpan span = new ForegroundColorSpan(Color.BLUE);
        spanString.setSpan(span, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanString);
    }

    /**
     * 字体大小
     */
    private void addFontSpan() {
        SpannableString spanString = new SpannableString("36号字体");
        AbsoluteSizeSpan span = new AbsoluteSizeSpan(36);
        spanString.setSpan(span, 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanString);
    }

    /**
     * 粗体，斜体
     */
    private void addStyleSpan() {
        SpannableString spanString = new SpannableString("ABCDEF");
        StyleSpan span = new StyleSpan(Typeface.BOLD_ITALIC);
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanString);
    }

    /**
     * 删除线
     */
    private void addStrikeSpan() {
        SpannableString spanString = new SpannableString("删除线");
        StrikethroughSpan span = new StrikethroughSpan();
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanString);
    }

    /**
     * 下划线
     */
    private void addUnderLineSpan() {
        SpannableString spanString = new SpannableString("下划线");
        UnderlineSpan span = new UnderlineSpan();
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanString);
    }

    /**
     * 图片
     */
    private void addImageSpan() {
        SpannableString spanString = new SpannableString(" ");
        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        spanString.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span_tv.append("\n");
        span_tv.append(spanString);
    }
}
