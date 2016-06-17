package com.white.home.adapter;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
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
import com.white.other.utils.HttpUtil;
import com.white.other.utils.ImageUtil;

import java.util.List;

/**
 * Created by A8 on 2016/6/8.
 */
public class HomeItemAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final Fragment fragment;
    private List<Choiceness> list;

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


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.adapter_home_item, null);
            holder.iv = (ImageView) convertView.findViewById(R.id.adapter_home_iv);
            holder.price = (TextView) convertView.findViewById(R.id.adapter_home_price);
            holder.leftTag = (TextView) convertView.findViewById(R.id.adapter_home_sale_tag);
            holder.content = (TextView) convertView.findViewById(R.id.adapter_home_tv_content);
            holder.sell = (TextView) convertView.findViewById(R.id.adapter_home_tv_sell);
            holder.rightTag = (TextView) convertView.findViewById(R.id.adapter_home_right_tag);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Choiceness choiceness = getItem(position);

        Glide.with(fragment)
                .load(choiceness.getPic())
                .centerCrop()
                .into(holder.iv);

        holder.price.setText(choiceness.getPrice().substring(4, choiceness.getPrice().lastIndexOf("<")));
        if (!TextUtils.isEmpty(choiceness.getTag_txt())) {
            holder.leftTag.setText(choiceness.getTag_txt());
            holder.leftTag.setVisibility(View.VISIBLE);
        }
        holder.content.setText(choiceness.getTitle());

        if (choiceness.getSale_count() != 0) {
            holder.sell.setTextColor(Color.parseColor("#50000000"));
            holder.sell.setText(choiceness.getSale_count() + "件已售出");
        } else {
            holder.sell.setTextColor(Color.parseColor("#ff7467"));
            holder.sell.setText("新品上架");
        }
        holder.rightTag.setText(choiceness.getCate_short_name());

        choiceness.getPtype_icon();

        ImageUtil.setTextDrawableForUrl(choiceness.getPtype_icon(),
                new HttpUtil.RequestCallback() {

                    @Override
                    public void success(Object result) {
                        holder.rightTag.setCompoundDrawables((BitmapDrawable) result, null, null, null);
                    }

                    @Override
                    public void fail() {

                    }
                });

        return convertView;
    }

    class ViewHolder {

        ImageView iv;
        TextView price;
        TextView leftTag;
        TextView content;
        TextView sell;
        TextView rightTag;

    }

    public void addData(List<Choiceness> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public List<Choiceness> getData() {
        return list;
    }

}
