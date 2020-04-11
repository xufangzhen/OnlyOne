package com.onlyone.common.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建者：许方镇
 * 日期：2016/6/23
 * 功能模块：基础activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (BaseApplication.getRunningActivityList() != null
                && !BaseApplication.getRunningActivityList().contains(this)) {
            BaseApplication.getRunningActivityList().add(this);
        }
        setContentView(getContentViewID());
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initData();
    }

    public abstract @LayoutRes
    int getContentViewID();

    public abstract void initView();

    public abstract void initData();

    @Override
    public void finish() {
        if (BaseApplication.getRunningActivityList() != null && BaseApplication.getRunningActivityList()
                .contains(this)) {
            BaseApplication.getRunningActivityList().remove(this);
        }
        super.finish();
    }

    public void showDialog(String title, String msg, int style) {

    }

}
