package com.onlyone.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

/**
 * 创建者：许方镇
 * 日期：2016/6/23
 * 功能模块：启动闪屏页面
 */
public class SplashActivity extends BaseActivity {

    private ImageView mLogoImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.FullScreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void initView() {
        mLogoImg = (ImageView) findViewById(R.id.splash_img);
    }

    @Override
    public void initData() {
        mLogoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
