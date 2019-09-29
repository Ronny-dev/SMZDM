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
import com.ronny.smzdm.root.entity.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ronny
 * @date 2019-09-24.
 * description：
 */
public class ArticleRecycleAdapter extends RecyclerView.Adapter<ArticleRecycleAdapter.VH> {

    private List<ArticleEntity.DataBean> dataEntity = new ArrayList<>();
    private MainRecycleAdapter.OnItemClickListener listener;
    private Context mContext;

    public void setDailyEntity(List<ArticleEntity.DataBean> dataEntity) {
        this.dataEntity = dataEntity;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup v, int viewType) {
        mContext = v.getContext();
        View view = LayoutInflater.from(v.getContext()).inflate(R.layout.item_main_recycle_article, v, false);
        return new ArticleRecycleAdapter.VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, final int i) {
        vh.tvTitle.setText(dataEntity.get(i).getTitle());
        vh.tvDesc.setText(dataEntity.get(i).getContent());
        vh.tvLike.setText(String.format("👍 %s", dataEntity.get(i).getCollection_count()));
        vh.tvCollection.setText(String.format("❤ %s", dataEntity.get(i).getComment_count()));
        vh.tvUser.setText(dataEntity.get(i).getNickname());
        Glide.with(mContext).load(dataEntity.get(i).getPic_url()).into(vh.ivImage);
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
        private final TextView tvLike;
        private final TextView tvCollection;
        private final TextView tvUser;
        private final CardView cardView;

        private VH(View v) {
            super(v);
            ivImage = v.findViewById(R.id.rcv_iv_image);
            tvTitle = v.findViewById(R.id.rcv_tv_title);
            tvDesc = v.findViewById(R.id.rcv_tv_content);
            tvLike = v.findViewById(R.id.rcv_tv_like);
            tvCollection = v.findViewById(R.id.rcv_tv_collection);
            tvUser = v.findViewById(R.id.rcv_tv_user);
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
