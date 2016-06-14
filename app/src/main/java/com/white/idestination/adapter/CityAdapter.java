package com.white.idestination.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.white.R;
import com.white.idestination.bean.DesCity;
import com.white.idestination.city.City;
import com.white.other.ui.activity.Des_City_Activity;
import com.white.other.utils.ImageUtil;
import com.white.other.utils.LogUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.RecyclerViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<DesCity> list;
    private int cId = 1955;


    public CityAdapter(Context context, List<DesCity> list) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.widget_des_item, null);
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.widget_des_item, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        DesCity desCity = list.get(position);
        ImageLoader.getInstance().displayImage(desCity.getPic(), holder.iv, ImageUtil.getNormalImageOptions());
        holder.tv_ch.setText(desCity.getName());
        holder.tv_en.setText(desCity.getName_en());
        holder.relativeContainer.setId(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relativeContainer;
        ImageView iv;
        TextView tv_ch, tv_en;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            relativeContainer = (RelativeLayout) itemView.findViewById(R.id.des_item_rootrl);
            iv = (ImageView) itemView.findViewById(R.id.des_item_iv);
            tv_ch = (TextView) itemView.findViewById(R.id.des_item_ch_tv);
            tv_en = (TextView) itemView.findViewById(R.id.des_item_en_tv);
            relativeContainer.setOnClickListener(this);
        }


        //设置cityid  便利循环拿到点击的cityid 传入URL
        @Override
        public void onClick(View v) {
            LogUtil.e("点击事件测试！！！" + v.getId());
            LogUtil.e("list.size()===" + list.size());
            Activity activity = (Activity) CityAdapter.this.mContext;
            String country_id = list.get(v.getId()).getCountry_id();
            LogUtil.e("list.get(v.getId()).getCountry_id()====" + list.get(v.getId()).getCountry_id());

            String city_id = list.get(v.getId()).getCity_id();
            if (city_id != null) {
                int coun_Id = Integer.parseInt(country_id);
                coun_Id = coun_Id + cId + v.getId();
                country_id = coun_Id + "";
            }
            String url = City.getURL(country_id, city_id);

            LogUtil.d(" City.getURL == " + url);

            Intent intent = new Intent(activity, Des_City_Activity.class);
            intent.putExtra("city", url);
            intent.putExtra("cityId", city_id);
            activity.startActivity(intent);
        }
    }
}