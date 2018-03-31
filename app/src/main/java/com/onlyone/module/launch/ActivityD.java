package com.onlyone.module.launch;

import android.view.View;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

/**
 * @author xufangzhen
 * @datw 2018/3/31.
 */
public class ActivityD extends BaseActivity {

    private TextView mTvd;

    @Override
    public int getContentViewID() {
        return R.layout.activity_d;
    }

    @Override
    public void initView() {
        mTvd =findViewById(R.id.text_d);
    }

    @Override
    public void initData() {
        mTvd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
