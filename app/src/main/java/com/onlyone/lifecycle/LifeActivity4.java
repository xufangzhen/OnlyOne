package com.onlyone.lifecycle;

import android.content.Intent;

public class LifeActivity4 extends LifeActivity1 {

    @Override
    public void initData() {
        super.initData();
    }


    @Override
    protected void jump() {
        startActivity(new Intent(this, LifeActivity1.class));
    }

}
