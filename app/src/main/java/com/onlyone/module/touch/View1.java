package com.onlyone.module.touch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by xufangzhen on 2018/3/2.
 */

public class View1 extends View {


    public View1(Context context) {
        super(context);
    }

    public View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("xfz", "View1: dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("xfz", "View1: dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("xfz", "View1: dispatchTouchEvent ACTION_UP");
                break;

        }
        return super.dispatchTouchEvent(ev);
//        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Thread.dumpStack();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("xfz", "View1: onTouchEvent ACTION_DOWN 父view 拦截");

                getParent().requestDisallowInterceptTouchEvent(true);
                break;
//                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("xfz", "View1: onTouchEvent ACTION_MOVE 父view 拦截");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("xfz", "View1: onTouchEvent ACTION_UP 父view 拦截");
                break;

        }
        return super.onTouchEvent(event);
//        return true;
    }
}
