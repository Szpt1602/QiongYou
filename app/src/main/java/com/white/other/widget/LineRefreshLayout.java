package com.white.other.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.FrameLayout;

/**
 * Created by A8 on 2016/6/13.
 */
public class LineRefreshLayout extends FrameLayout {

    /**
     * 子布局(被刷新的目标布局)
     */
    private View mTarget;

    /**
     * 刷新头部
     */
    private LineRefresh mLineView;

    /**
     * 按下的初始Y坐标
     */
    private float downY;

    /**
     * 移动的Y左边
     */
    private float moveY;

    /**
     * 是否为更新状态
     */
    private boolean refresh;

    /**
     * 是否已触发接口的方法
     */
    private boolean hasDone;

    public LineRefreshLayout(Context context) {
        super(context);
    }

    public LineRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //查找子布局的View
        if (mTarget == null) {
            ensureTarget();
        }
        if (mTarget == null) {
            return;
        }
        //创建刷新头部进度View
        createProgressView();
    }

    private void ensureTarget() {
        if (mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (!child.equals(mLineView)) {
                    mTarget = child;
                    break;
                }
            }
        }
    }

    private RefreshListener listener;
    private LineRefreshPoint view1;
    private LineRefreshPoint view2;
    private LineRefreshPoint view3;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //第一次按下坐标
                downY = event.getY();
                moveY = downY;
                break;
            case MotionEvent.ACTION_MOVE:
                //如果为刷新状态 跳出switch
                if (refresh) {
                    break;
                }

                //滑步布局不在顶部
                if (canChildScrollUp(mTarget)) {
                    //初始化坐标
                    downY = event.getY();

                    /**
                     * 如果更新动画正在运行 并且不在刷新状态 说明进度条到满屏状态并且开启了动画 此时又不在顶部
                     * 应当关闭刷新的动画
                     */
                    if (refreshAnimatorIsRunning() && !refresh) {
                        refreshComplete();
                        break;
                    }

                    /**
                     * 此处无论如何都应当隐藏顶部headerView 如果隐藏进度条动画没有进行 开启
                     */
                    if (!progressAnimatorIsRunning() && !hasRunnable) {
                        removeProgressView();
                    }

                } else
                //在顶部 并且手势向下移动 应当下拉刷新
                if (moveY < event.getY()) {
                    //触发下拉刷新事件
                    startRefreshEvent(event);
                    //消费事件
                    return true;
                } else {
                    downY = event.getY();
                }
                moveY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                //如果动画正在运行 更新状态
                if (refreshAnimatorIsRunning()) {
                    refresh = true;
                    if (hasDone) {
                        //Nope
                    } else if (listener != null) {
                        //调用接口方法
                        hasDone = true;
                        listener.onRefresh();
                    }
                    break;
                }
                if (!progressAnimatorIsRunning() && !hasRunnable) {
                    removeProgressView();
                }
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return super.onInterceptTouchEvent(ev);
    }

    private ObjectAnimator animator1;
    private ObjectAnimator animator2;
    private ObjectAnimator animator3;

    private void startRefreshEvent(MotionEvent event) {
        //如果隐藏动画正在进行 取消
        if (hasRunnable) {
            hasRunnable = false;
            mHandler.removeCallbacks(runnable);
        }
        if (progressAnimatorIsRunning()) {
            hideAnimator.cancel();
        }

        //已有动画进行
        if (refreshAnimatorIsRunning()) {
            return;
        }

        //以上条件不符合则改变进度条长度
        mLineView.setVisibility(VISIBLE);
        moveY = event.getY();
        //1.2f为阻尼系数
        if (moveY > downY) {
            mLineView.setLineWidth(1.2f * (moveY - downY));
        }
        if (mLineView.getLineWidth() >= getMeasuredWidth() / 2 && !refresh) {
            startRefreshAnimation();
        }
    }

    /**
     * 开始刷新动画
     */
    private void startRefreshAnimation() {
        mHandler.removeCallbacks(runnable);


        //三个动画分别延时开启
        view1.setVisibility(VISIBLE);
        animator1.start();
        mHandler.postDelayed(r1, 400);
        mHandler.postDelayed(r2, 800);

    }

    /**
     * 判断刷新动画是否正在运行
     */
    private boolean refreshAnimatorIsRunning() {
        return animator1 != null && animator1.isRunning() || animator2 != null && animator2.isRunning() || animator3 != null && animator3.isRunning();
    }


    private Runnable r1 = new Runnable() {

        @Override
        public void run() {
            view2.setVisibility(VISIBLE);
            animator2.start();
        }
    };

    private Runnable r2 = new Runnable() {

        @Override
        public void run() {
            view3.setVisibility(VISIBLE);
            animator3.start();
        }
    };

    private Handler mHandler = new Handler();

    /**
     * 创建view和初始化属性动画
     */
    private void createProgressView() {
        if (mLineView == null) {
            mLineView = new LineRefresh(getContext());
            addView(mLineView);

            view1 = new LineRefreshPoint(getContext());
            addView(view1);
            view2 = new LineRefreshPoint(getContext());
            addView(view2);
            view3 = new LineRefreshPoint(getContext());
            addView(view3);

            view1.setVisibility(GONE);
            view2.setVisibility(GONE);
            view3.setVisibility(GONE);

            animator1 = ObjectAnimator.ofFloat(view1, "translationX", -40, getResources().getDisplayMetrics().widthPixels);
            animator1.setInterpolator(new AccelerateInterpolator());
            animator1.setRepeatCount(Animation.INFINITE);
            animator1.setDuration(1200);

            animator2 = ObjectAnimator.ofFloat(view2, "translationX", -40, getResources().getDisplayMetrics().widthPixels);
            animator2.setInterpolator(new AccelerateInterpolator());
            animator2.setRepeatCount(Animation.INFINITE);
            animator2.setDuration(1200);

            animator3 = ObjectAnimator.ofFloat(view3, "translationX", -40, getResources().getDisplayMetrics().widthPixels);
            animator3.setInterpolator(new AccelerateInterpolator());
            animator3.setRepeatCount(Animation.INFINITE);
            animator3.setDuration(1200);
        }
    }

    private View getLineView() {
        return mLineView;
    }

    /**
     * 隐藏(移除)头部进度View
     */
    private void removeProgressView() {
        if (refresh) {
            return;
        }
        if (progressAnimatorIsRunning()) {
            return;
        }
        hasRunnable = true;
        mHandler.postDelayed(runnable, 400);
    }

    //隐藏动画
    private ObjectAnimator hideAnimator;

    /**
     * 隐藏动画runnable
     */
    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            if (hideAnimator == null) {
                hideAnimator = ObjectAnimator.ofFloat(getLineView(), "scaleX", 1, 0).setDuration(400);
                hideAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                hideAnimator.addListener(animatorListener);
            }
            hideAnimator.start();
        }
    };

    /**
     * 判断隐藏动画是否在运行
     *
     * @return
     */
    private boolean progressAnimatorIsRunning() {
        return hideAnimator != null && hideAnimator.isRunning();
    }

    private boolean hasRunnable;
    private Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            hasRunnable = false;
            mLineView.setLineWidth(0);
            mLineView.setScaleX(1);
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };

    public void setRefreshListener(RefreshListener listener) {
        this.listener = listener;
    }

    public interface RefreshListener {

        void onRefresh();
    }

    public boolean isRefreshing() {
        return refresh;
    }


    /**
     * 刷新完成 重置参数.
     */
    public void refreshComplete() {
        refresh = false;
        hasDone = false;

        moveY = 0;
        downY = 0;

        removeProgressView();

        mHandler.removeCallbacks(r1);
        mHandler.removeCallbacks(r2);

        animator1.end();
        animator2.end();
        animator3.end();

        view1.setVisibility(GONE);
        view2.setVisibility(GONE);
        view3.setVisibility(GONE);
    }

    public static boolean canChildScrollUp(View view) {
        if (android.os.Build.VERSION.SDK_INT < 14) {

            if (view instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) view;
                return absListView.getChildCount() > 0
                        && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0)
                        .getTop() < absListView.getPaddingTop());
            } else {
                return view.getScrollY() > 0;
            }
        } else {
            return view.canScrollVertically(-1);
        }
    }

}
