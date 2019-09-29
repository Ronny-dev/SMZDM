package com.ronny.smzdm.root.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.ronny.smzdm.R;
import com.ronny.smzdm.WebViewActivity;
import com.ronny.smzdm.adapter.MainRecycleAdapter;
import com.ronny.smzdm.root.adapter.ArticleRecycleAdapter;
import com.ronny.smzdm.root.entity.ArticleEntity;
import java.io.IOException;
import java.util.ArrayList;
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
public class ArticleFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArticleRecycleAdapter mRecycleAdapter;
    private ArrayList<ArticleEntity.DataBean> articleListBeans = new ArrayList<>();
    private int page = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);

        initView(view);

        initRecycleView();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    private void initData() {
        page++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://120.77.60.87:8890/getArticle?pager=" + page;
                OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder().url(url).header("Content-Type", "application/json").build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful() && response.body() != null) {

                            ArticleEntity articleEntity = new Gson().fromJson(response.body().string(), ArticleEntity.class);

                            if (articleEntity == null || articleEntity.getData().size() == 0) {
                                showToast("无数据");
                                return;
                            }

                            showRcyData(siftShowData(articleEntity));
                        }
                    }
                });
            }
        }).start();
    }

    private List<ArticleEntity.DataBean> siftShowData(ArticleEntity dailyProductItem) {

        articleListBeans.addAll(dailyProductItem.getData());

        return articleListBeans;
    }

    private void showRcyData(final List<ArticleEntity.DataBean> articleEntity) {
        if (getActivity() == null)
            return;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mRecycleAdapter.setDailyEntity(articleEntity);
                mRecycleAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView(View view) {
        TextView tvTitleBar = view.findViewById(R.id.tv_title_bar_title);
        tvTitleBar.setText("精选文章");
        mRecyclerView = view.findViewById(R.id.rcv_article);
        mRecycleAdapter = new ArticleRecycleAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecycleAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initRecycleView() {
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
