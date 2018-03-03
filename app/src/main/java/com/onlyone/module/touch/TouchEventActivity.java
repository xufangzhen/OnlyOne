package com.onlyone.module.touch;

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
                break;
            case MotionEvent.ACTION_UP:
                Log.e("xfz", "activity: dispatchTouchEvent ACTION_UP");
                break;

        }
        return super.dispatchTouchEvent(ev);
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
        return super.onTouchEvent(event);
    }
}
