package com.onlyone.common.base;

import android.app.Activity;
import android.app.Application;

import com.onlyone.common.util.LogUtils;
import com.onlyone.plugin.init.OnlyOneFlutterInitial;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：许方镇
 * 日期：2016/6/21
 * 功能模块：
 */
public class BaseApplication extends Application {

    private static BaseApplication mApplication;
    private static List<Activity> mRunningActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        //前后台切换
        BaseTaskSwitch.init(this).setOnTaskSwitchListener(new BaseTaskSwitch.OnTaskSwitchListener() {
            @Override
            public void onTaskSwitchToForeground() {
                LogUtils.d("切换到前台");
            }

            @Override
            public void onTaskSwitchToBackground() {
                LogUtils.d("切换到后台");
            }
        });

        OnlyOneFlutterInitial.initBoost(this);
    }

    public static BaseApplication getInstance() {
        if (mApplication == null) {
            throw new NullPointerException("app not create or be terminated!");
        }
        return mApplication;
    }

    public static List<Activity> getRunningActivityList() {
        if (mRunningActivity == null) {
            mRunningActivity = new ArrayList<>();
        }
        return mRunningActivity;
    }
}
