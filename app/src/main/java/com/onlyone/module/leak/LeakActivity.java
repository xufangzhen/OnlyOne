package com.onlyone.module.leak;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

public class LeakActivity extends BaseActivity {


    public static Leak leak;

    @Override
    public int getContentViewID() {
        return R.layout.activity_a;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        leak = new Leak();
    }

    class Leak {
    }
}
