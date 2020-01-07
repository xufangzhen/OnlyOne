package com.onlyone.lifecycle;

import android.content.Intent;

public class LifeActivity2 extends LifeActivity1 {

    @Override
    protected void jump() {
        startActivity(new Intent(this, LifeActivity3.class));
    }
}
