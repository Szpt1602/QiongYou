package com.white.my.adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.white.R;

import java.util.List;

/**
 * Created by Exp on 2016/6/13.
 */
public class DialogAdapter extends BaseAdapter {

    private List<String> list;
    private Context mcontext;
    private View view;
    private String list2;
    private TextView text1,text2;
    private String[] split;

    public DialogAdapter(List<String> list, Context mcontext) {
        this.list=list;
        this.mcontext=mcontext;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        view = View.inflate(mcontext, R.layout.dialog_item, null);
        list2 = list.get(position);
        text1 = (TextView) view.findViewById(R.id.dialog_tv1);
        text2 = (TextView) view.findViewById(R.id.dialog_tv2);
        split = list2.split(",");
        text1.setText(split[0]);
        text2.setText(split[1]);
        return view;
    }
}
