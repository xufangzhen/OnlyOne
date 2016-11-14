package com.onlyone.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.onlyone.common.base.BaseApplication;

/**
 * 创建者：许方镇
 * 日期：2016/11/8
 * 功能模块：偏好设置工具类
 */
public class PreferencesUtils {

    public static SharedPreferences getAppPreferences() {
        Context context = BaseApplication.getInstance().getApplicationContext();
        return context.getSharedPreferences(context.getPackageName() + "_sp", Context.MODE_PRIVATE);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return getAppPreferences().getBoolean(key, defaultValue);
    }

    public static int getInt(String key, int defaultValue) {
        return getAppPreferences().getInt(key, defaultValue);
    }

    public static long getLone(String key, long defaultValue) {
        return getAppPreferences().getLong(key, defaultValue);
    }

    public static String getString(String key, String defaultValue) {
        return getAppPreferences().getString(key, defaultValue);
    }

    public static void putBoolean(String key, boolean value) {
        getAppPreferences().edit().putBoolean(key, value).apply();
    }

    public static void putInt(String key, int value) {
        getAppPreferences().edit().putInt(key, value).apply();
    }

    public static void putLong(String key, long value) {
        getAppPreferences().edit().putLong(key, value).apply();
    }

    public static void putString(String key, String value) {
        getAppPreferences().edit().putString(key, value).apply();
    }
}
