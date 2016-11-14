package com.onlyone.common.widget.newbieguide;

import android.graphics.RectF;
import android.view.View;

/**
 * 创建者：xufangzhen
 * 日期：2016/6/17
 * 功能模块：引导浮层高亮view的holder
 */
public class GuideHole {

    public static final int CIRCLE = 0;
    public static final int RECTANGLE = CIRCLE + 1;
    public static final int OVAL = RECTANGLE + 1;

    private View mHole;
    private int mShape;

    public GuideHole(View hole, int shape) {
        this.mHole = hole;
        this.mShape = shape;
    }

    public int getShape() {
        return mShape;
    }

    public View getHole() {
        return mHole;
    }

    public int getRadius() {
        return mHole != null ? Math.min(mHole.getWidth(), mHole.getHeight()) / 2 : 0;
    }

    public RectF getRectF() {
        RectF rectF = new RectF();
        if (mHole != null) {
            int[] location = new int[2];
            mHole.getLocationOnScreen(location);
            rectF.set(location[0], location[1], location[0] + mHole.getWidth(), location[1] + mHole.getHeight());
        }
        return rectF;
    }

}