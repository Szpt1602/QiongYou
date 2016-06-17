package com.white.other.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by A8 on 2016/6/14.
 */
public class LineRefreshPoint extends View {

    private Paint wPaint;
    private float wFromX;
    private float width;

    public LineRefreshPoint(Context context) {
        super(context);

        initPaint();
    }

    public LineRefreshPoint(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        wPaint = new Paint();
        wPaint.setColor(Color.WHITE);
        wPaint.setStrokeWidth(25);
        wPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0, 0, 20, 0, wPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(20, heightMeasureSpec);
    }

}
