package com.white.home.adapter;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.home.bean.Choiceness;

import java.util.List;

/**
 * Created by A8 on 2016/6/8.
 */
public class HomeItemAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final Fragment fragment;
    private List<Choiceness> list;
    private Handler mHandler = new Handler();

    public HomeItemAdapter(Fragment fragment) {
        this.fragment = fragment;
        inflater = LayoutInflater.from(fragment.getActivity());
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Choiceness getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ViewHolder holder;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_home_item, null);
            holder = new ViewHolder(convertView);
        }

        Choiceness choiceness = getItem(position);

        Glide.with(fragment)
                .load(choiceness.getPic())
                .into(holder.iv);

        Glide.with(fragment)
                .load(choiceness.getPtype_icon())
                .into(holder.smallIv);

        holder.price.setText(Html.fromHtml(choiceness.getPrice().substring(0, choiceness.getPrice().lastIndexOf(">"))));
        holder.price.append("元起");
        if (!TextUtils.isEmpty(choiceness.getTag_txt())) {
            holder.leftTag.setText(choiceness.getTag_txt());
            holder.leftTag.setVisibility(View.VISIBLE);
        }
        holder.content.setText(choiceness.getTitle());

        if (choiceness.getSale_count() != 0) {
            holder.sell.setTextColor(Color.parseColor("#50000000"));
            holder.sell.setText(choiceness.getSale_count() + "件已售出");
        } else {
            holder.sell.setTextColor(Color.parseColor("#f9014f"));
            holder.sell.setText("新品上架");
        }
        holder.rightTag.setText(choiceness.getCate_short_name());
        return convertView;
    }

    class ViewHolder {

        ImageView smallIv;
        ImageView iv;
        TextView price;
        TextView leftTag;
        TextView content;
        TextView sell;
        TextView rightTag;

        public ViewHolder(View view) {
            smallIv = (ImageView) view.findViewById(R.id.adapter_home_right_tag_iv);
            iv = (ImageView) view.findViewById(R.id.adapter_home_iv);
            price = (TextView) view.findViewById(R.id.adapter_home_price);
            leftTag = (TextView) view.findViewById(R.id.adapter_home_sale_tag);
            content = (TextView) view.findViewById(R.id.adapter_home_tv_content);
            sell = (TextView) view.findViewById(R.id.adapter_home_tv_sell);
            rightTag = (TextView) view.findViewById(R.id.adapter_home_right_tag);
        }
    }

    public void addData(List<Choiceness> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }
}
