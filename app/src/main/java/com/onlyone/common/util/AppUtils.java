package com.onlyone.common.util;

import android.content.Context;
import android.util.Log;

import com.onlyone.common.base.BaseApplication;

import java.lang.reflect.Field;

import dalvik.system.DexClassLoader;

/**
 * 创建者：许方镇
 * 日期：2016/11/8
 * 功能模块：app信息获取工具类
 */
public class AppUtils {

    public static final boolean IS_DEBUG = true;

    /**
     * 获取当前应用的版本号
     */
    public static int getVersionCode() {
        int visionCode = -1;
        try {
            Context context = BaseApplication.getInstance().getApplicationContext();
            visionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e("xfz", "AppUtilsClassLoader = " + String.class.getClassLoader().toString());

        DexClassLoader dexClassLoader;

        Field field;

        return visionCode;



    }
}