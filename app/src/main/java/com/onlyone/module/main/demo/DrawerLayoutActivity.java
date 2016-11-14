package com.onlyone.module.main.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

/**
 * 创建者：许方镇
 * 日期：2016/11/14
 * 功能模块：
 */

public class DrawerLayoutActivity extends BaseActivity {
    private EditText mEditText;
    private Button mButton;
    private ListView mListView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
    }

    @Override
    public void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mListView = (ListView) findViewById(R.id.drawer_list);
        mButton = (Button) findViewById(R.id.drawer_btn);
        mEditText = (EditText) findViewById(R.id.drawer_edit);
    }

    @Override
    public void initData() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.END);
            }
        });
    }
}
