package com.ronny.smzdm.root.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ronny.smzdm.R;
import com.ronny.smzdm.adapter.MainRecycleAdapter;
import com.ronny.smzdm.root.entity.HourEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ronny
 * @date 2019-09-24.
 * description：
 */
public class HourRecycleAdapter extends RecyclerView.Adapter<HourRecycleAdapter.VH> {
    private List<HourEntity> dataEntity = new ArrayList<>();
    private MainRecycleAdapter.RecycleLayoutType mLayoutType = MainRecycleAdapter.RecycleLayoutType.VERTICAL;
    private MainRecycleAdapter.OnItemClickListener listener;
    private Context mContext;

    public void setDataEntity(List<HourEntity> dataEntity) {
        this.dataEntity = dataEntity;
    }

    @NonNull
    @Override
    public HourRecycleAdapter.VH onCreateViewHolder(@NonNull ViewGroup v, int viewType) {
        mContext = v.getContext();
        View view;
        if (mLayoutType == MainRecycleAdapter.RecycleLayoutType.VERTICAL) {
            view = LayoutInflater.from(v.getContext()).inflate(R.layout.item_main_recycle_vertical, v, false);
        } else {
            view = LayoutInflater.from(v.getContext()).inflate(R.layout.item_main_recycle_horizontal, v, false);
        }
        return new HourRecycleAdapter.VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourRecycleAdapter.VH vh, final int i) {
        double parseWorthy = Double.parseDouble(dataEntity.get(i).getArticle_worthy());

        double parseUnworthy = Double.parseDouble(dataEntity.get(i).getArticle_unworthy());

        int worthyProp = (int) ((parseWorthy / (parseWorthy + parseUnworthy)) * 100);
        vh.tvTitle.setText(dataEntity.get(i).getArticle_title());
        vh.tvDesc.setText(dataEntity.get(i).getArticle_mall());
        vh.tvWorthy.setText(String.format("值 %s%%", worthyProp));
        vh.tvCollection.setText(String.format("评 %s", String.valueOf(dataEntity.get(i).getArticle_comment())));
        vh.tvPrice.setText(dataEntity.get(i).getArticle_price());
        Glide.with(mContext).load(dataEntity.get(i).getArticle_pic_url()).into(vh.ivImage);
        vh.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(i, dataEntity.get(i).getArticle_url());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataEntity.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        private final ImageView ivImage;
        private final TextView tvTitle;
        private final TextView tvDesc;
        private final TextView tvWorthy;
        private final TextView tvCollection;
        private final TextView tvPrice;
        private final CardView cardView;

        private VH(View v) {
            super(v);
            ivImage = v.findViewById(R.id.rcv_iv_image);
            tvTitle = v.findViewById(R.id.rcv_tv_title);
            tvDesc = v.findViewById(R.id.rcv_tv_desc);
            tvWorthy = v.findViewById(R.id.rcv_tv_worthy);
            tvCollection = v.findViewById(R.id.rcv_tv_collection);
            tvPrice = v.findViewById(R.id.rcv_tv_price);
            cardView = v.findViewById(R.id.rcv_cardview);
        }
    }

    public void setOnItemClickListener(MainRecycleAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int i, String s);
    }
}
