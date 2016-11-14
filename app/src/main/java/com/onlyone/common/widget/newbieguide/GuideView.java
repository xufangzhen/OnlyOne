package com.onlyone.common.widget.newbieguide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.onlyone.common.util.AppUtils;
import com.onlyone.common.util.SizeUtils;

import java.util.List;

/**
 * 创建者：xufangzhen
 * 日期：2016/6/16
 * 模块功能：引导浮层view
 */
public class GuideView extends RelativeLayout {

    private int mBgColor = 0xb2000000;//背景色
    private float mStrokeWidth;//画笔粗度
    private List<GuideHole> mHoleList;//高亮洞洞数据集
    private RectF mBitmapRect; //该矩形为能容纳所有高亮洞洞的最小矩形
    private Paint mPaint;//画笔
    private Bitmap mBitmap;//图片
    private Canvas mCanvas;//画高亮洞洞的画布
    private PorterDuffXfermode mPdXf;

    public GuideView(Context context) {
        super(context);
        init();
    }

    public GuideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GuideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mBgColor);
        mPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.INNER));
        mPdXf = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        mBitmapRect = new RectF();
        setClickable(true);
        setWillNotDraw(false);
    }

    public void setDate(List<GuideHole> holeList) {
        mHoleList = holeList;
        if (mHoleList != null && !mHoleList.isEmpty()) {
            for (GuideHole hole : mHoleList) {
                mBitmapRect.union(hole.getRectF());
            }
        }
        if (!mBitmapRect.isEmpty()) {
            mStrokeWidth = Math.max(Math.max(mBitmapRect.left, mBitmapRect.top),
                    Math.max(SizeUtils.getScreenWidth() - mBitmapRect.right,
                            SizeUtils.getScreenHeight() - mBitmapRect.bottom));
            if (mHoleList.size() == 1 && mHoleList.get(0).getShape() == GuideHole.RECTANGLE) {
                mBitmap = Bitmap.createBitmap((int) mBitmapRect.width(), (int) mBitmapRect.height(),
                        Bitmap.Config.ALPHA_8);
            } else {
                mBitmap = Bitmap.createBitmap((int) mBitmapRect.width(), (int) mBitmapRect.height(),
                        Bitmap.Config.ARGB_8888);
            }
            mBitmap.eraseColor(mBgColor);
            mCanvas = new Canvas(mBitmap);
        } else if (AppUtils.IS_DEBUG) {
            throw new UnsupportedOperationException("需要高亮的view尚未设置或者未加载完，或者处于不可见状态，无法获取长和宽");
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mHoleList != null && !mHoleList.isEmpty() && !mBitmapRect.isEmpty()) {
            mPaint.setXfermode(mPdXf);
            mPaint.setStyle(Paint.Style.FILL);
            //画出所有高亮的洞洞
            for (GuideHole hole : mHoleList) {
                RectF rectF = hole.getRectF();
                rectF.offset(-mBitmapRect.left, -mBitmapRect.top);
                switch (hole.getShape()) {
                    case GuideHole.CIRCLE:
                        mCanvas.drawCircle(rectF.centerX(), rectF.centerY(), hole.getRadius(), mPaint);
                        break;
                    case GuideHole.RECTANGLE:
                        mCanvas.drawRect(rectF, mPaint);
                        break;
                    case GuideHole.OVAL:
                        mCanvas.drawOval(rectF, mPaint);
                        break;
                }
            }
            //画出容纳所有高亮的洞洞的最小背景矩形
            canvas.drawBitmap(mBitmap, mBitmapRect.left, mBitmapRect.top, null);
            //画个镂空的矩形填充剩余空白部分
            mPaint.setXfermode(null);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(mStrokeWidth - 0.1f);
            canvas.drawRect(fillRect(mBitmapRect), mPaint);
        }
    }

    //计算镂空矩形的长宽，填补剩余的空白
    private RectF fillRect(RectF rectF) {
        RectF fillRect = new RectF();
        fillRect.left = rectF.left - mStrokeWidth / 2;
        fillRect.top = rectF.top - mStrokeWidth / 2;
        fillRect.right = rectF.right + mStrokeWidth / 2 - 0.1f;
        fillRect.bottom = rectF.bottom + mStrokeWidth / 2 - 0.1f;
        return fillRect;
    }

    public void recycler() {
        if (mBitmap != null && !mBitmap.isRecycled()) {
            mBitmap.recycle();
            mBitmap = null;
        }
    }
}