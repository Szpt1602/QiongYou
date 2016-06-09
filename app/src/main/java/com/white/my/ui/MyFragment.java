package com.white.my.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.white.R;
import com.white.other.base.BaseFragment;
import com.white.other.utils.JumpManager;

/**
 * Created by A8 on 2016/6/1.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private ImageView headiv;
    private Intent intent;
    private TextView text1,youhuijuam;
    private LinearLayout ll;
    private RelativeLayout rl;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initViews() {
        startLoading();
        headiv = (ImageView) root.findViewById(R.id.fragment_my_head_iv);
        text1 = (TextView) root.findViewById(R.id.fragment_my_login_tv);
        ll = (LinearLayout) root.findViewById(R.id.fragment_my_ll0);
        rl = (RelativeLayout) root.findViewById(R.id.fragment_my_rl);
        youhuijuam= (TextView) root.findViewById(R.id.fragment_my_youhuijuan_tv);

    }

    @Override
    protected void initEvents() {
        headiv.setOnClickListener(this);
        text1.setOnClickListener(this);
        ll.setOnClickListener(this);
        rl.setOnClickListener(this);
        youhuijuam.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean needLoading() {
        return false;
    }


    @Override
    public void onClick(View v) {
        JumpManager.jumpToLoginActivity(getActivity());
    }

}
