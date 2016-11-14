package com.onlyone.common.widget.newbieguide;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.onlyone.R;
import com.onlyone.common.util.ListUtils;
import com.onlyone.common.util.PreferencesUtils;
import com.onlyone.common.util.SizeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：xufangzhen
 * 日期：2016/6/16
 * 功能模块：引导浮层管理类
 */
public class GuideBuilder {

    public static final int CENTER = 0;

    private int mType;
    private boolean mEveryWhereTouchable = true;
    private OnGuideChangedListener mOnGuideChangedListener;
    private List<GuideHole> mHoleList;
    private Activity mActivity;
    private GuideView mGuideView;
    private ViewGroup mParentView;

    public GuideBuilder(Activity activity, int type) {
        mActivity = activity;
        mType = type;
        mParentView = (ViewGroup) mActivity.getWindow().getDecorView();
        mGuideView = new GuideView(mActivity);
        mHoleList = new ArrayList<>();
    }

    /**
     * @param view 需要高亮显示的view
     * @param shape 设置的形状 圆形:HoleBean.CIRCLE 矩形:HoleBean.RECTANGLE  椭圆:HoleBean.OVAL
     */
    public GuideBuilder addHighLightView(View view, int shape) {
        GuideHole hole = new GuideHole(view, shape);
        mHoleList.add(hole);
        return this;
    }

    /**
     * 添加指示箭头图标等图片image
     *
     * @param resId 图片id
     * @param offsetX 水平偏移量，负数为右侧开始
     * @param offsetY 垂直偏移量，负数为底侧开始
     */
    public GuideBuilder addIndicateImg(int resId, int offsetX, int offsetY) {
        ImageView arrowImg = new ImageView(mActivity);
        arrowImg.setImageResource(resId);
        mGuideView.addView(arrowImg, getLp(offsetX, offsetY));
        return this;
    }

    /**
     * @param msg 提示文本信息
     * @param offsetX 水平偏移量，负数为右侧开始
     * @param offsetY 垂直偏移量，负数为底侧开始
     */
    public GuideBuilder addMessage(String msg, int offsetX, int offsetY) {
        mGuideView.addView(generateMsgTv(msg), getLp(offsetX, offsetY));
        return this;
    }

    /**
     * @param text 按钮文本信息
     * @param offsetX 水平偏移量，负数为右侧开始
     * @param offsetY 垂直偏移量，负数为底侧开始
     */
    public GuideBuilder addKnowTv(String text, int offsetX, int offsetY) {
        mGuideView.addView(generateKnowTv(text), getLp(offsetX, offsetY));
        return this;
    }

    /**
     * @param msg 提示文本信息
     * @param offsetY 垂直偏移量，负数为底侧开始
     * @return
     */
    public GuideBuilder addMsgAndKnowTv(String msg, int offsetY) {
        mGuideView.addView(generateMsgAndKnowTv(msg), getLp(CENTER, offsetY));
        return this;
    }

    //生成提示文本
    private TextView generateMsgTv(String msg) {
        TextView msgTv = new TextView(mActivity);
        msgTv.setText(msg);
        msgTv.setTextColor(0xffffffff);
        msgTv.setTextSize(15);
        msgTv.setLineSpacing(SizeUtils.getPx(5), 1f);
        msgTv.setGravity(Gravity.CENTER);
        return msgTv;
    }

    //生成我知道了文本
    private TextView generateKnowTv(String text) {
        TextView knowTv = new TextView(mActivity);
        knowTv.setTextColor(0xffffffff);
        knowTv.setTextSize(15);
        knowTv.setPadding(SizeUtils.getPx(15), SizeUtils.getPx(5), SizeUtils.getPx(15), SizeUtils.getPx(5));
        knowTv.setBackgroundResource(R.drawable.white_border_bg);
        knowTv.setText(text);
        knowTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove();
            }
        });
        return knowTv;
    }

    //生成提示文本和我知道了文本
    private LinearLayout generateMsgAndKnowTv(String msg) {
        LinearLayout container = new LinearLayout(mActivity);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setGravity(Gravity.CENTER_HORIZONTAL);
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        container.addView(generateMsgTv(msg), lp);
        lp.topMargin = SizeUtils.getPx(10);
        container.addView(generateKnowTv("我知道啦"), lp);
        return container;
    }

    //生成布局参数
    private RelativeLayout.LayoutParams getLp(int offsetX, int offsetY) {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //水平方向
        if (offsetX == CENTER) {
            lp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        } else if (offsetX < 0) {
            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            lp.rightMargin = -offsetX;
        } else {
            lp.leftMargin = offsetX;
        }
        //垂直方向
        if (offsetY == CENTER) {
            lp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        } else if (offsetY < 0) {
            lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            lp.bottomMargin = -offsetY;
        } else {
            lp.topMargin = offsetY;
        }
        return lp;
    }

    /**
     * 展示新手引导浮层
     */
    public void show() {
        if (ListUtils.isInvalid(mHoleList)) return;
        PreferencesUtils.putBoolean(GuideTypeManager.TAG + mType, false);
        final GuideHole lastHole = mHoleList.get(mHoleList.size() - 1);
        if (lastHole.getRectF().isEmpty()) {
            lastHole.getHole()
                    .getViewTreeObserver()
                    .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            lastHole.getHole().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            setup();
                        }
                    });
        } else {
            setup();
        }
    }

    private void setup() {
        mGuideView.setDate(mHoleList);

        mParentView.removeView(mGuideView);
        mParentView.addView(mGuideView,
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ObjectAnimator.ofFloat(mGuideView, "alpha", 0.0F, 1F).setDuration(500).start();
        if (mOnGuideChangedListener != null) {
            mOnGuideChangedListener.onShowed();
        }
        if (mEveryWhereTouchable) {
            mGuideView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    remove();
                    return false;
                }
            });
        }
    }

    public void show(long delayTime) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show();
            }
        }, delayTime);
    }

    //移除新手引导浮层
    private void remove() {
        if (mGuideView != null && mGuideView.getParent() != null) {
            mGuideView.recycler();
            ((ViewGroup) mGuideView.getParent()).removeView(mGuideView);
            if (mOnGuideChangedListener != null) {
                mOnGuideChangedListener.onRemoved();
            }
        }
    }

    /**
     * @param everyWhereTouchable 是否可以点击任何地方来移除新手引导浮层
     */
    public GuideBuilder setEveryWhereTouchable(boolean everyWhereTouchable) {
        mEveryWhereTouchable = everyWhereTouchable;
        return this;
    }

    public GuideBuilder setOnGuideChangedListener(OnGuideChangedListener onGuideChangedListener) {
        this.mOnGuideChangedListener = onGuideChangedListener;
        return this;
    }

    //浮层显示和消失后的回调
    public interface OnGuideChangedListener {
        void onShowed();

        void onRemoved();
    }
}
