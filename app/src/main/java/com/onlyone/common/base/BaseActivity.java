package com.onlyone.common.base;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

/**
 * 创建者：许方镇
 * 日期：2016/6/23
 * 功能模块：基础activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (BaseApplication.getRunningActivityList() != null && !BaseApplication.getRunningActivityList()
                .contains(this)) {
            BaseApplication.getRunningActivityList().add(this);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initData();
    }

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
