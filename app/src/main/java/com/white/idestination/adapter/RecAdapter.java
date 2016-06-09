package com.white.idestination.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.white.R;
import com.white.idestination.bean.DesRecommend;

import java.util.List;

/**
 * Created by Administrator on 2016/6/5.
 */
public class RecAdapter extends BaseAdapter {

    private List<DesRecommend> dlist;

    private Context dcontext = null;

    private IMyIdCallback myIdCallback;

    private int id;

    private int lastIndex = -1;


    public List<DesRecommend> getDlist() {
        return dlist;
    }

    public void setDlist(List<DesRecommend> dlist) {
        this.dlist = dlist;
    }

    public RecAdapter(List<DesRecommend> list, Context context, IMyIdCallback listener) {
        this.dlist = list;
        this.dcontext = context;
        this.myIdCallback = listener;
    }

    public RecAdapter() {
    }

    @Override
    public int getCount() {
        return dlist == null ? 0 : dlist.size();
    }

    @Override
    public Object getItem(int position) {
        if (lastIndex != position)
            id = 0;
        myIdCallback.getId(id);
        lastIndex = position;
        return dlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHoler myHoler = null;
        if (convertView == null) {
            myHoler = new MyHoler();
            convertView = LayoutInflater.from(dcontext).inflate(R.layout.widget_des_list_item, parent, false);
            myHoler.tv_name = (TextView) convertView.findViewById(R.id.des_list_tv);
            convertView.setTag(myHoler);
        } else {
            myHoler = (MyHoler) convertView.getTag();
        }
        DesRecommend desRecommend = dlist.get(position);
        myHoler.tv_name.setText(desRecommend.getName());
        return convertView;
    }

    class MyHoler {

        private TextView tv_name;
    }

    public interface IMyIdCallback {

        void getId(int id);


    }
}
