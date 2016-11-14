package com.onlyone.common.util;

import android.util.Log;

/**
 * 创建者：许方镇
 * 日期：2016/6/21
 * 功能模块：日志打印工具类
 */
public class LogUtils {

    public static void d(int num) {
        d(num + "");
    }

    public static void d(float num) {
        d(num + "");
    }

    public static void d(String msg) {
        Log.d("xfz", msg);
    }
}
