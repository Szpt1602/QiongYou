package com.white.other.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.white.R;

/**
 * Created by A8 on 2016/6/3.
 */
public class ViewPagerIndex extends View {

    private int unSelectColor = Color.parseColor("#60cccccc");
    private int selectColor;
    private int count;
    private int currentIndex;
    private float pointPadding;
    private float radius;
    private Paint defaultPaint;
    private float fromY;
    private float fromX;
    private Paint selectPaint;

    public ViewPagerIndex(Context context) {
        super(context);
    }

    public ViewPagerIndex(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ViewPagerIndex);
        selectColor = a.getColor(R.styleable.ViewPagerIndex_selectColor, Color.parseColor("#40C895"));
        count = a.getInteger(R.styleable.ViewPagerIndex_pointCount, 0);
        pointPadding = a.getDimension(R.styleable.ViewPagerIndex_pointPadding, 10);

        initPaint();
    }

    private void initPaint() {
        defaultPaint = new Paint();
        defaultPaint.setDither(true);
        defaultPaint.setAntiAlias(true);
        defaultPaint.setColor(unSelectColor);

        selectPaint = new Paint();
        selectPaint.setDither(true);
        selectPaint.setAntiAlias(true);
        selectPaint.setColor(selectColor);

        radius = 8;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        float contentWidth = radius * count * 2 + pointPadding * (count - 1);

        fromX = (width - contentWidth) / 2 + radius;
        fromY = height / 2;

        for (int i = 0; i < count; i++) {
            if (i == currentIndex) {
                canvas.drawCircle(fromX + i * (radius * 2 + pointPadding), fromY, radius, selectPaint);
            } else {
                canvas.drawCircle(fromX + i * (radius * 2 + pointPadding), fromY, radius, defaultPaint);
            }
        }

    }

    public void setIndex(int currentIndex) {
        this.currentIndex = currentIndex;
        invalidate();
    }

    public void setViewPager(ViewPager vp) {
        count = vp.getAdapter().getCount();
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentIndex = position;
                invalidate();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        invalidate();
    }

    public void setCount(int count) {
        this.count = count;
        invalidate();
    }

}
