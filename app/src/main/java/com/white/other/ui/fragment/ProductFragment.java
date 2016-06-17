package com.white.other.ui.fragment;

import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.white.R;
import com.white.other.base.BaseFragment;
import com.white.other.widget.LineRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A8 on 2016/6/16.
 */
public class ProductFragment extends BaseFragment {

    private LineRefreshLayout lrl;
    private ListView lv;
    private ArrayAdapter adapter;
    private int i;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_product;
    }

    @Override
    protected void initViews() {
        lrl = (LineRefreshLayout) root.findViewById(R.id.product_fragment_lrl);
        lv = (ListView) root.findViewById(R.id.product_fragment_lv);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, getData());
//        lv.setAdapter(adapter);
        lrl.setRefreshListener(new LineRefreshLayout.RefreshListener() {

            @Override
            public void onRefresh() {
                adapter.add("item" + i++);
                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        lrl.refreshComplete();
                    }
                }, 500);
            }
        });
    }

    private Handler mHandler = new Handler();

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("item" + i);
        }
        return list;
    }
}
