package com.onlyone.module.launch;

import android.view.View;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

/**
 * @author xufangzhen
 * @datw 2018/3/31.
 */
public class ActivityB extends BaseActivity {

    private TextView mTvb;

    @Override
    public int getContentViewID() {
        return R.layout.activity_b;
    }

    @Override
    public void initView() {
        mTvb = (TextView) findViewById(R.id.text_b);
    }

    @Override
    public void initData() {
        mTvb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
