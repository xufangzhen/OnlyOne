package com.onlyone.module.launch;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.base.BaseActivity;

/**
 * @author xufangzhen
 * @datw 2018/3/31.
 */
public class ActivityA extends BaseActivity {

    private TextView mTva;

    @Override
    public int getContentViewID() {
        return R.layout.activity_a;
    }

    @Override
    public void initView() {
        mTva = (TextView) findViewById(R.id.text_a);
    }

    @Override
    public void initData() {
        mTva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("activity2");
                intent.addCategory("myCategory");
                startActivity(intent);
            }
        });
    }
}
