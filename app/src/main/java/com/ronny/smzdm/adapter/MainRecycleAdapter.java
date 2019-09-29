package com.ronny.smzdm.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ronny.smzdm.R;
import com.ronny.smzdm.entity.MainRecycleDataEntity;

public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.VH>{

    public enum RecycleLayoutType{
        VERTICAL,
        HORIZONTAL
    }

    private MainRecycleDataEntity dataEntity;
    private RecycleLayoutType mLayoutType = RecycleLayoutType.VERTICAL;
    private OnItemClickListener listener;
    private Context mContext;

    public MainRecycleAdapter(MainRecycleDataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup v, int i) {
        mContext = v.getContext();
        View view;
        if (mLayoutType == RecycleLayoutType.VERTICAL) {
            view = LayoutInflater.from(v.getContext()).inflate(R.layout.item_main_recycle_vertical, v, false);
        } else {
            view = LayoutInflater.from(v.getContext()).inflate(R.layout.item_main_recycle_horizontal, v, false);
        }
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, final int i) {
        int worthyProp = (int) (((double)dataEntity.getResults().get(i).getArticle_worthy() /
                        ((double)dataEntity.getResults().get(i).getArticle_worthy() +
                                dataEntity.getResults().get(i).getArticle_unworthy())) * 100);
        vh.tvTitle.setText(dataEntity.getResults().get(i).getArticle_title());
        vh.tvDesc.setText(dataEntity.getResults().get(i).getArticle_mall());
        vh.tvWorthy.setText(String.format("值 %s%%", worthyProp));
        vh.tvCollection.setText(String.format("评 %s", String.valueOf(dataEntity.getResults().get(i).getArticle_comment())));
        vh.tvPrice.setText(dataEntity.getResults().get(i).getArticle_price());
        Glide.with(mContext).load(dataEntity.getResults().get(i).getArticle_pic_url()).into(vh.ivImage);
        vh.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(i, dataEntity.getResults().get(i).getArticle_url());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataEntity.getResults().size();
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



    public MainRecycleDataEntity getDataEntity() {
        return dataEntity;
    }

    public void setLayoutType(RecycleLayoutType type) {
        this.mLayoutType = type;
    }

    public RecycleLayoutType getLayoutType() {
        return mLayoutType;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int i, String s);
    }
}
