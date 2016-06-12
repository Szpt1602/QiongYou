package com.white.idestination.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.white.R;
import com.white.idestination.adapter.CityAdapter;
import com.white.idestination.adapter.RecAdapter;
import com.white.idestination.bean.DesCity;
import com.white.idestination.bean.DesRecommend;
import com.white.other.base.BaseFragment;
import com.white.other.utils.Constant;
import com.white.other.utils.LogUtil;
import com.white.other.utils.QyerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A8 on 2016/6/1.
 */
public class DesFragment extends BaseFragment {

    private ImageView iv_et;
    private RecyclerView recyclerView;
    private ListView lv;
    private List<DesCity> list = new ArrayList<>();
    private List<DesRecommend> dlist;
    private int i = 0;
    private int lastId = -1;
    private RecAdapter.IMyIdCallback callback = new RecAdapter.IMyIdCallback() {

        @Override
        public void getId(int id) {
            i = id;
        }
    };
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_des;
    }

    @Override
    protected void initViews() {
        recyclerView = (RecyclerView) root.findViewById(R.id.des_content_rv);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(manager);
        iv_et = (ImageView) root.findViewById(R.id.fragment_des_ed_im);
        lv = (ListView) root.findViewById(R.id.fragment_des_listview);
    }

    @Override
    protected void initEvents() {


    }

    @Override
    protected void initData() {
        final CityAdapter cityAdapter = new CityAdapter(getActivity(), list);
        recyclerView.setAdapter(cityAdapter);
        Constant.getDes(new QyerTask.IRequestCallback() {

            @Override
            public void success(Object obj) {
                try {
                    JSONObject jo = new JSONObject(obj.toString());
                    String joString = jo.getString("trace_switch");
                    if ("true".equals(joString)) {
                        JSONArray data = jo.getJSONArray("data");
                        LogUtil.w(data.toString());
                        dlist = DesRecommend.arrayDesRecommendFromData(data.toString());
                        LogUtil.w("List<DesRecommend> = " + dlist.size());
                        RecAdapter recAdapter = new RecAdapter(dlist, getContext(), callback);

                        lv.setAdapter(recAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void error(String msg) {

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list != null)
                    list.clear();
                DesRecommend desRecommend = dlist.get(position);
                List<DesCity> destinations = desRecommend.getDestinations();
                list.addAll(destinations);
                LogUtil.d("lv onItemClick  size == " + list.size());
                cityAdapter.notifyDataSetChanged();
                cityAdapter.setList(list);
            }
        });


    }
}
