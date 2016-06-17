package com.white.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.home.bean.HomeDetail;
import com.white.other.utils.JumpManager;

import java.util.List;

/**
 * Created by A8 on 2016/6/6.
 */
public class GearAdapter extends RecyclerView.Adapter<GearAdapter.GearViewHolder> {

    private final LayoutInflater inflater;
    private final Fragment fragment;
    private List<HomeDetail> list;

    class GearViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;

        public GearViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.home_gear_rv_iv);
        }
    }


    public GearAdapter(Fragment fragment, List<HomeDetail> gears) {
        this.fragment = fragment;
        list = gears;
        inflater = LayoutInflater.from(fragment.getActivity());
    }

    @Override
    public GearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_gear_iv, null);
        return new GearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GearViewHolder holder, final int position) {
        Glide.with(fragment)
                .load(list.get(position).getCover())
                .into(holder.iv);

        holder.iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                HomeDetail homeDetail = list.get(position);
                if (homeDetail.getName().equals("签证")) {

                    return;
                }
                switch (homeDetail.getOpen_type()) {
                    case "1":
                        JumpManager.jumpToProductActivity(fragment.getActivity(), homeDetail.getName(), 1);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

}
