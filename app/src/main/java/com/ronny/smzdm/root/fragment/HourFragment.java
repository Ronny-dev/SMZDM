package com.ronny.smzdm.root.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ronny.smzdm.R;
import com.ronny.smzdm.WebViewActivity;
import com.ronny.smzdm.adapter.MainRecycleAdapter;
import com.ronny.smzdm.root.adapter.HourRecycleAdapter;
import com.ronny.smzdm.root.entity.HourEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Ronny
 * @date 2019-09-24.
 * description：
 */
public class HourFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private HourRecycleAdapter mRecycleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hour, container, false);

        initView(view);

        initRecycleView();

        initRecycleStateListener();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.rcv_hour);
        TextView tvTitleBar = view.findViewById(R.id.tv_title_bar_title);
        tvTitleBar.setText("超值秒杀");
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://120.77.60.87:8890/getHourData";
                OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder().url(url).header("Content-Type", "application/json").build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful() && response.body() != null) {

                            ArrayList<HourEntity> hourEntities =
                                    new Gson().fromJson(response.body().string(),
                                            new TypeToken<List<HourEntity>>(){}.getType());

                            showRcyData(siftData(hourEntities));
                        }
                    }
                });
            }
        }).start();
    }

    private void initRecycleStateListener() {
        mRecycleAdapter.setOnItemClickListener(new MainRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i, String s) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", s);
                startActivity(intent);
            }
        });
    }

    private ArrayList<HourEntity> siftData(ArrayList<HourEntity> hourEntity) {

        Collections.sort(hourEntity, new Comparator<HourEntity>() {
            @Override
            public int compare(HourEntity before, HourEntity after) {
                int beforeWorthy = Integer.parseInt(before.getArticle_worthy());
                int afterWorthy = Integer.parseInt(after.getArticle_worthy());
                return afterWorthy - beforeWorthy;
            }
        });
        return hourEntity;
    }

    private void showRcyData(final ArrayList<HourEntity> dailyProductItem) {
        if (getActivity() == null)
            return;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mRecycleAdapter.setDataEntity(dailyProductItem);
                mRecycleAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initRecycleView() {
        mRecycleAdapter = new HourRecycleAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecycleAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
