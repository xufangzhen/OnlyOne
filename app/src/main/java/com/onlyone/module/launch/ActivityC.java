package com.onlyone.module.launch;

import android.view.View;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

/**
 * @author xufangzhen
 * @datw 2018/3/31.
 */
public class ActivityC extends BaseActivity {

    private TextView mTvc;

    @Override
    public int getContentViewID() {
        return R.layout.activity_c;
    }

    @Override
    public void initView() {
        mTvc = (TextView) findViewById(R.id.text_c);
    }

    @Override
    public void initData() {
        mTvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
