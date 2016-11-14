package com.onlyone.module.main.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;
import com.onlyone.common.util.SizeUtils;
import com.onlyone.common.widget.flowlayout.JustifyFlowLayout;

/**
 * 创建者：许方镇
 * 日期：2016/11/13
 * 功能模块：
 */

public class FlowLayoutActivity extends BaseActivity {

    private JustifyFlowLayout mFlowLayout;
    private String[] mValues = new String[] {
            "Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello", "Android", "Weclome", "Button ImageView",
            "TextView", "Helloworld", "Android", "Weclome Hello", "Button Text", "TextView"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.justify_flow_activity);
    }

    @Override
    public void initView() {
        mFlowLayout = (JustifyFlowLayout) findViewById(R.id.main_flow_layout);
    }

    @Override
    public void initData() {
        mFlowLayout.setMinInterval(SizeUtils.getPx(20));
        LayoutInflater mInflater = LayoutInflater.from(this);
        for (int i = 0; i < mValues.length; i++) {
            TextView tv = (TextView) mInflater.inflate(R.layout.justify_flow_tv, mFlowLayout, false);
            tv.setText(mValues[i]);
            mFlowLayout.addView(tv);
        }
    }
}