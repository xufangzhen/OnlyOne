package com.onlyone.common.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;

import com.onlyone.common.base.BaseApplication;

/**
 * 创建者：许方镇
 * 日期：2016/6/21
 * 功能模块：尺寸相关工具类
 */
public class SizeUtils {

    private SizeUtils() {
    }

    public static int getScreenWidth() {
        return BaseApplication.getInstance().getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return BaseApplication.getInstance().getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int getPx(float dp) {
        return (int) (dp * BaseApplication.getInstance()
                .getApplicationContext()
                .getResources()
                .getDisplayMetrics().density);
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        return frame.top;
    }
}
