package com.onlyone.module.touch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

/**
 * Created by xufangzhen on 2018/3/2.
 */

public class TouchEventActivity extends BaseActivity {

    @Override
    public int getContentViewID() {
        return R.layout.activity_touch_event;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("xfz", "activity: dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("xfz", "activity: dispatchTouchEvent ACTION_MOVE");
//                return true;
                break;
            case MotionEvent.ACTION_UP:
                Log.e("xfz", "activity: dispatchTouchEvent ACTION_UP");
                break;

        }
        return super.dispatchTouchEvent(ev);
//        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("xfz", "activity: onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("xfz", "activity: onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("xfz", "activity: onTouchEvent ACTION_UP");
                break;

        }
//        return super.onTouchEvent(event);
        return true;
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        Log.e("xfz", "activity: onUserInteraction");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("xfz", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("xfz", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("xfz", "onResume");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.e("xfz", "onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e("xfz", "onPostResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("xfz", "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("xfz", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("xfz", "onDestroy");
    }
}
