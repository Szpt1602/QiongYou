package com.white.home.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.white.R;
import com.white.home.bean.HomeDetail;

import java.util.List;

/**
 * Created by A8 on 2016/6/4.
 */
public class BarFragment extends Fragment {

    private List<HomeDetail> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.widget_bar_double_line, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getView() != null) {
            BarItem top = (BarItem) getView().findViewById(R.id.widget_bar_top);
            BarItem bottom = (BarItem) getView().findViewById(R.id.widget_bar_bottom);

            top.setData(list.subList(0, 4));
            if (list.size() > 4) {
                bottom.setData(list.subList(4, 8));
            }
        }
    }

    public void setDataList(List<HomeDetail> list) {
        this.list = list;
    }
}
