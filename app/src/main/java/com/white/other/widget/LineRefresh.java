package com.white.other.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by A8 on 2016/6/12.
 */
public class LineRefresh extends View {

    private int width;
    private int height;
    private float centerX;
    private Paint mPaint;
    private Paint wPaint;
    private float lineWidth;
    private float endX;
    private float fromX;
    private boolean refresh;

    public LineRefresh(Context context) {
        super(context);

        initPaint();
    }

    public LineRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#41BA8F"));
        mPaint.setStrokeWidth(25);

        wPaint = new Paint();
        wPaint.setColor(Color.WHITE);
        wPaint.setStrokeWidth(25);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        if (!refresh) {
            centerX = width / 2;
            fromX = centerX - lineWidth;
            endX = centerX + lineWidth;
            canvas.drawLine(fromX, 0, endX, 0, mPaint);
        } else {
            canvas.drawLine(0, 0, width, 0, mPaint);
        }

    }

    public void setLineWidth(float width) {
        lineWidth = width;
        if (width > this.width / 2) {
            refresh = true;
        } else {
            refresh = false;
        }
        invalidate();
    }

    public float getLineWidth() {
        return lineWidth;
    }


}
