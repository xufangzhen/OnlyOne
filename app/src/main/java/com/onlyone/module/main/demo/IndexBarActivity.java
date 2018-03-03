package com.onlyone.module.main.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;
import com.onlyone.common.util.LogUtils;
import com.onlyone.common.widget.indexbar.SideIndexBar;

/**
 * 创建者：许方镇
 * 日期：2016/11/14
 * 功能模块：
 */

public class IndexBarActivity extends BaseActivity {
    private TextView mText;
    private SideIndexBar indexBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentViewID() {
        return R.layout.activity_index_bar;
    }

    @Override
    public void initView() {
        mText = (TextView) findViewById(R.id.text_dialog);
        indexBar = (SideIndexBar) findViewById(R.id.index_bar);
    }

    @Override
    public void initData() {
        indexBar.setLetters("ABCDEFHIJKLMOPQSTUVXYZ#");
        indexBar.setTextDialog(mText);
        indexBar.setOnLetterChangedListener(new SideIndexBar.OnLetterChangedListener() {
            @Override
            public void onChanged(String s, int position) {
                LogUtils.d(s + " position:" + position);
            }
        });
    }
}
