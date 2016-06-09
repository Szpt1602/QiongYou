package com.white.other.base;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.white.R;

/**
 * Created by A8 on 2016/6/1.
 */
public abstract class BaseFragment extends Fragment {

    protected ViewGroup root;
    private AnimationDrawable drawable;
    private ImageView loading;
    private FrameLayout view;
    private FrameLayout content;
    private FrameLayout title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(getLayoutResId(), null);
        view = (FrameLayout) inflater.inflate(R.layout.base_fragment, null);
        content = (FrameLayout) view.findViewById(R.id.base_fragment_content_fl);
        title = (FrameLayout) view.findViewById(R.id.base_custom_title_bar_root);
        content.addView(root);
        if (needLoading()) {
            initLoading();
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initEvents();
        initData();
    }

    protected boolean needLoading() {
        return false;
    }

    private void initLoading() {
        loading = (ImageView) view.findViewById(R.id.base_bg_loading);
        loading.setVisibility(View.VISIBLE);
        drawable = (AnimationDrawable) loading.getDrawable();
    }

    protected void startLoading() {
        if (needLoading()) {
            drawable.start();
        }
    }

    protected void stopLoading() {
        if (needLoading()) {
            drawable.stop();
            loading.setVisibility(View.GONE);
            content.addView(root);
        }
    }

    protected void hideTitle() {
        title.setVisibility(View.GONE);
    }

    protected void setTitleView(int layoutResId) {
        View view = getActivity().getLayoutInflater().inflate(layoutResId, null, false);
        title.addView(view);
    }

    protected View getTitleView() {
        return title;
    }

    protected void setTitleView(View view) {
        title.addView(view);
    }

    protected abstract int getLayoutResId();

    protected abstract void initViews();

    protected abstract void initEvents();

    protected abstract void initData();

}
