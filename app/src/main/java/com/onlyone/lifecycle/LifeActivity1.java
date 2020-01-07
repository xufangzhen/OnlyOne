package com.onlyone.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

public class LifeActivity1 extends BaseActivity {

    private String tag = "";
    private TextView textView;

    @Override
    public int getContentViewID() {
        tag = getClass().getSimpleName();
        return R.layout.activity_life;

    }

    @Override
    public void initView() {
        textView = (TextView) findViewById(R.id.text_life);
        textView.setText(tag + "-跳转");
    }

    @Override
    public void initData() {
        textView.setOnClickListener(v -> jump());

        Looper.myQueue().addIdleHandler(() -> {
            Log.e(tag, "queueIdle");
            return false;
        });
    }

    protected void jump() {
        startActivity(new Intent(this, LifeActivity2.class));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(tag, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(tag, "onRestoreInstanceState");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(tag, "onCreate");

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.e(tag, "onPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(tag, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(tag, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(tag, "onResume");

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e(tag, "onWindowFocusChanged " + hasFocus);
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e(tag, "onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(tag, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(tag, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(tag, "onDestroy");
    }

}
