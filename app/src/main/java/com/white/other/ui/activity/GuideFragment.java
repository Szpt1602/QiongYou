package com.white.other.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.white.R;

/**
 * Created by Exp on 2016/6/6.
 */
public class GuideFragment extends Fragment {

    private int img;
    private ImageView iv;
    private Button btn;
    private boolean show;
    private int index;
    private boolean show1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        img = getArguments().getInt("img");
        show = getArguments().getBoolean("show",false);
        return inflater.inflate(R.layout.fragment_guide,null);
    }

    private void intEvents() {

        if (show){
            btn.setVisibility(View.VISIBLE);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iv = (ImageView) getView().findViewById(R.id.fragment_guide_iv);
        btn = (Button) getView().findViewById(R.id.guide_fragment_btn);
        iv.setImageResource(img);
        intEvents();
    }

    public GuideFragment(int index) {
        this.index = index;
    }
}
