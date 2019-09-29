package com.ronny.smzdm.root.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ronny.smzdm.MainActivity;
import com.ronny.smzdm.R;
import com.ronny.smzdm.WebViewActivity;
import com.ronny.smzdm.adapter.MainRecycleAdapter;
import com.ronny.smzdm.root.adapter.DailyRecycleAdapter;
import com.ronny.smzdm.root.entity.DailyEntity;
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
public class DailyFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private DailyRecycleAdapter mRecycleAdapter;
    private ArrayList<DailyEntity> articleListBeans = new ArrayList<>();
    private int page = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily, container, false);

        initView(view);

        initRecycleStateListener();

        return view;
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

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();

                    if (manager == null)
                        return;

                    if (mRecycleAdapter == null)
                        return;

                    int lastPos = manager.findLastCompletelyVisibleItemPosition();

                    if (manager.getChildCount() > 0 &&
                            lastPos > manager.getItemCount() - 2 &&
                            manager.getItemCount() > manager.getChildCount()) {
                        initData();
                    }
                }
            }
        });
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.rcv_daily);
        TextView tvBarTitle = view.findViewById(R.id.tv_title_bar_title);
        tvBarTitle.setText("每日精选");

        mRecycleAdapter = new DailyRecycleAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecycleAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        page++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://120.77.60.87:8890/getDailyData?pager=" + page;
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

                            ArrayList<DailyEntity> dailyEntities =
                                    new Gson().fromJson(response.body().string(),
                                            new TypeToken<List<DailyEntity>>(){}.getType());

                            if (dailyEntities == null || dailyEntities.size() == 0) {
                                showToast("无数据");
                                return;
                            }

                            Log.i("Ronny", dailyEntities.size()+"");

                            showRcyData(siftShowData(dailyEntities));
                        }
                    }
                });
            }
        }).start();
    }

    private List<DailyEntity> siftShowData(ArrayList<DailyEntity> dailyProductItem) {

        Collections.sort(dailyProductItem, new Comparator<DailyEntity>() {
            @Override
            public int compare(DailyEntity o1, DailyEntity o2) {
                int beforeComment = Integer.parseInt(o1.getArticle_comment());
                int afterComment = Integer.parseInt(o2.getArticle_comment());
                return afterComment - beforeComment;
            }
        });

        articleListBeans.addAll(dailyProductItem);

        return articleListBeans;
    }

    private void showRcyData(final List<DailyEntity> dailyProductItem) {
        if (getActivity() == null)
            return;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mRecycleAdapter.setDailyEntity(dailyProductItem);
                mRecycleAdapter.notifyDataSetChanged();
            }
        });
    }

    private void showToast(final String s) {
        if (getActivity() == null) return;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
            }
        });
    }
}
