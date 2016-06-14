package com.white.idestination.widget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.white.R;
import com.white.idestination.bean.LocalBlock;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class City_Fragment extends Fragment {

    private List<LocalBlock> list;

    public City_Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    public void setData(List<LocalBlock> list) {
        this.list = list;
    }
}
