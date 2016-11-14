package com.onlyone.common.widget.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以设置两端对齐的流式布局
 * Created by xufangzhen on 2015/9/25.
 */

public class JustifyFlowLayout extends ViewGroup {

    private List<List<View>> mAllViews;//存储所有的View
    private List<Integer> mLineHeight;//每一行的高度
    private List<Integer> mLineExtraInterval;//每一行的额外增加的间隔
    private int mMinExtraInterval;//不算margin，padding，额外的水平最小间隔
    private boolean isJustify;//是否需要两端对齐

    public JustifyFlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public JustifyFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public JustifyFlowLayout(Context context) {
        this(context, null);
        init();
    }

    private void init() {
        mAllViews = new ArrayList<>();
        mLineHeight = new ArrayList<>();
        mLineExtraInterval = new ArrayList<>();
        mMinExtraInterval = 0;
        isJustify = true;
    }

    /**
     * 设置水平最小间隔，单位为像素
     *
     * @param mMinInterval
     */
    public void setMinInterval(int mMinInterval) {
        this.mMinExtraInterval = mMinInterval;
    }

    /**
     * 设置两端对齐
     *
     * @param isJustify 默认为true，两端对齐，false则不对齐
     */
    public void setJustify(boolean isJustify) {
        this.isJustify = isJustify;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        // 该布局的宽和高
        int width = 0;
        int height = 0;

        // 记录每一行的宽度与高度,子view个数
        int lineWidth = -mMinExtraInterval;
        int lineHeight = 0;

        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);

            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

            if (lineWidth + childWidth + mMinExtraInterval < sizeWidth - getPaddingLeft() - getPaddingRight()) {
                lineWidth += childWidth + mMinExtraInterval;
                lineHeight = Math.max(lineHeight, childHeight);
            } else {
                width = Math.max(width, lineWidth);
                height += lineHeight;
                lineWidth = childWidth;
                lineHeight = childHeight;
            }
            // 最后一个控件
            if (i == count - 1) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
            }
        }

        if (modeWidth != MeasureSpec.EXACTLY) sizeWidth = width + getPaddingLeft() + getPaddingRight();
        if (modeHeight != MeasureSpec.EXACTLY) sizeHeight = height + getPaddingTop() + getPaddingBottom();

        setMeasuredDimension(sizeWidth, sizeHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllViews.clear();
        mLineHeight.clear();
        mLineExtraInterval.clear();
        // 当前ViewGroup的宽度
        int width = getWidth();
        // 当前行的额外增加的间隔
        int interval;
        int lineWidth = 0;
        int lineHeight = 0;

        List<View> lineViews = new ArrayList<>();

        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight();
            int lineChildNum = lineViews.size();
            // 如果需要换行
            if (lineWidth + childWidth + lineChildNum * mMinExtraInterval
                    > width - getPaddingLeft() - getPaddingRight()) {
                // 记录LineHeight
                mLineHeight.add(lineHeight);
                // 记录当前行的Views
                mAllViews.add(lineViews);
                // 记录每行的额外需要增加的空间
                mLineExtraInterval.add((width - getPaddingLeft() - getPaddingRight() - lineWidth) / (lineChildNum - 1));
                // 重置行宽和行高
                lineWidth = 0;
                lineHeight = childHeight + lp.topMargin + lp.bottomMargin;
                // 重置View集合
                lineViews = new ArrayList<>();
            }
            lineWidth += childWidth;
            lineHeight = Math.max(lineHeight, childHeight + lp.topMargin + lp.bottomMargin);
            lineViews.add(child);
        }// for end
        // 处理最后一行
        mLineExtraInterval.add(mMinExtraInterval);
        mLineHeight.add(lineHeight);
        mAllViews.add(lineViews);

        // 设置子View的位置

        int left = getPaddingLeft();
        int top = getPaddingTop();

        // 行数
        int lineNum = mAllViews.size();

        for (int i = 0; i < lineNum; i++) {
            // 当前行的所有的View
            lineViews = mAllViews.get(i);
            lineHeight = mLineHeight.get(i);
            interval = mLineExtraInterval.get(i);
            for (int j = 0; j < lineViews.size(); j++) {
                View child = lineViews.get(j);
                // 判断child的状态
                if (child.getVisibility() == View.GONE) {
                    continue;
                }

                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

                int lc = left + lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();

                // 为子View进行布局
                child.layout(lc, tc, rc, bc);
                if (!isJustify) interval = 0;
                left += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin + interval;
            }
            left = getPaddingLeft();
            top += lineHeight;
        }
    }

    /**
     * 与当前ViewGroup对应的LayoutParams
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
