package com.runtai.testproject2.activity;

import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.runtai.tagsedittextlibrary.TagsEditText;
import com.runtai.testproject2.R;
import com.runtai.testproject2.cehua.BaseActivity;

import java.util.Arrays;
import java.util.Collection;

/**
 * @作者：高炎鹏
 * @日期：2017/3/23时间10:52
 * @描述：标签输入控件
 */
public class TagsEditTextActivity extends BaseActivity implements TagsEditText.TagsEditListener {

    private static final String TAG = "TagsEditTextActivity";
    private TagsEditText mTagsEditText;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_tagsedittext;
    }

    @Override
    protected void initView() {
        mTagsEditText = (TagsEditText) findViewById(R.id.tagsEditText);
        mTagsEditText.setHint("Enter names of fruits");
        mTagsEditText.setTagsListener(this);
        mTagsEditText.setTagsWithSpacesEnabled(true);
        //设置符合出现提示时的列表内容
        mTagsEditText.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.fruits)));
        mTagsEditText.setThreshold(1);//设置至少输入一个字符时出现提示

        setButtonClickListener(R.id.btnChangeTags);
        setButtonClickListener(R.id.btnChangeBackground);
        setButtonClickListener(R.id.btnChangeColor);
        setButtonClickListener(R.id.btnChangeSize);
        setButtonClickListener(R.id.btnChangeDrawableLeft);
        setButtonClickListener(R.id.btnChangeDrawableRight);
        setButtonClickListener(R.id.btnChangeClosePadding);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mTagsEditText.showDropDown();
        }
    }

    private void setButtonClickListener(@IdRes int id) {
        findViewById(id).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChangeTags: {
                mTagsEditText.setTags(new String[]{"1","2","3","4"});
                break;
            }
            case R.id.btnChangeBackground: {
                mTagsEditText.setTagsBackground(R.drawable.square);
                break;
            }
            case R.id.btnChangeColor: {
                mTagsEditText.setTagsTextColor(R.color.blackOlive);
                break;
            }
            case R.id.btnChangeSize: {
                mTagsEditText.setTagsTextSize(R.dimen.larger_text_size);
                break;
            }
            case R.id.btnChangeDrawableLeft: {
                mTagsEditText.setCloseDrawableLeft(R.drawable.dot);
                break;
            }
            case R.id.btnChangeDrawableRight: {
                mTagsEditText.setCloseDrawableRight(R.drawable.tag_close);
                break;
            }
            case R.id.btnChangeClosePadding: {
                mTagsEditText.setCloseDrawablePadding(R.dimen.larger_padding);
                break;
            }
        }
    }

    @Override
    public void onTagsChanged(Collection<String> tags) {
        Log.d(TAG, "Tags changed: ");
        Log.d(TAG, Arrays.toString(tags.toArray()));
    }

    @Override
    public void onEditingFinished() {
        Log.d(TAG,"OnEditing finished");
    }

}
