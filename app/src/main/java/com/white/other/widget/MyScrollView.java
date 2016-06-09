package com.white.other.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by A8 on 2016/6/6.
 */
public class MyScrollView extends ScrollView {

    private ScrollStateListener listener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private static int state = 0;

    private static final int bottom = 1;
    private static final int top = 2;
    private static final int scroll = 3;

    @Override
    protected synchronized void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (t + getHeight() >= computeVerticalScrollRange() && state != bottom) {
            state = bottom;
        } else if (t <= 0 && state != top) {
            state = top;
        } else if (state != scroll) {
            state = scroll;
            mHandler.post(observer);
        }
        if (listener != null) {
            notifyListener(t, oldt);
        }
    }

    private Handler mHandler = new Handler();

    private Runnable observer = new Runnable() {

        @Override
        public void run() {
            mHandler.removeCallbacks(this);
            moveState = STOP;
            mHandler.postDelayed(this, 50);
        }
    };

    private void notifyListener(int t, int oldt) {
        if (first) {
            if (t == 0 && state == top) {
                listener.top();
                first = false;
                return;
            }
            if (t == this.t && state == bottom) {
                listener.bottom();
                first = false;
                return;
            }
        }
        if (state == scroll) {
            listener.scroll(t, oldt);
            first = true;
        }
    }

    private static int moveState = 0;
    private static final int DRAGGING = 1;
    private static final int INERTIA = 2;
    private static final int STOP = 3;

    private boolean first;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_MOVE:
                moveState = DRAGGING;
                break;

            case MotionEvent.ACTION_UP:
            default:
                if (state == scroll) {
                    moveState = INERTIA;
                } else {
                    moveState = STOP;
                }
        }
        return super.onTouchEvent(ev);
    }

    public interface ScrollStateListener {

        void top();

        void bottom();

        void scroll(int y, int oldy);
    }

    public void setScrollListener(ScrollStateListener listener) {
        this.listener = listener;
    }

    private int t;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.t = computeVerticalScrollRange() - getHeight();
    }
}
