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

    private float width;
    private float height;
    private float centerX;
    private Paint mPaint;
    private Paint wPaint;
    private float lineWidth = 200;
    private float endX;
    private float fromX;
    private boolean refresh;

    private float w1FromX;
    private float w2FromX;

    public LineRefresh(Context context) {
        super(context);
    }

    public LineRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);
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

        if (refresh) {
            centerX = width / 2;
            fromX = centerX - lineWidth;
            endX = centerX + lineWidth;
            canvas.drawLine(fromX, 0, endX, 0, mPaint);
        } else {
            canvas.drawLine(0, 0, width, 0, mPaint);

            canvas.drawLine(w1FromX, 0, w1FromX - height, 0, wPaint);
            canvas.drawLine(w2FromX, 0, w2FromX + height, 0, wPaint);

            postDelayed(new Runnable() {

                @Override
                public void run() {
                    canvas.drawLine(w1FromX, 0, w1FromX - height, 0, wPaint);
                    canvas.drawLine(w2FromX, 0, w2FromX + height, 0, wPaint);
                }
            }, 200);
        }

    }

    public void setLineWidth(float width) {
        lineWidth = width;
        refresh = false;
        invalidate();
    }

    public void setRefreshX(float w1FromX, float w2FromX) {
        refresh = true;
        this.w1FromX = w1FromX;
        this.w2FromX = w2FromX;
        invalidate();
    }


}
