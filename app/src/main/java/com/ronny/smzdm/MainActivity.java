package com.ronny.smzdm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ronny.smzdm.adapter.MainRecycleAdapter;
import com.ronny.smzdm.entity.MainRecycleDataEntity;

import java.io.IOException;
import java.util.Collections;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Toolbar mToolbar;
    private FloatingActionButton mFab;
    private DrawerLayout mDrawer;
    private NavigationView mNavigation;
    private RecyclerView mRecyclerView;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                initRecyclerView((MainRecycleDataEntity) message.obj);
            } else {
                Toast.makeText(MainActivity.this, (String)message.obj, Toast.LENGTH_LONG).show();
            }
            return false;
        }
    });
    private MainRecycleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        mFab = findViewById(R.id.fab);
        mDrawer = findViewById(R.id.drawer_layout);
        mNavigation = findViewById(R.id.nav_view);
        mRecyclerView = findViewById(R.id.recycler_view);

        findViewById(R.id.tv_time_sort).setOnClickListener(this);
        findViewById(R.id.tv_worthy_sort).setOnClickListener(this);
        findViewById(R.id.tv_collection_sort).setOnClickListener(this);
        findViewById(R.id.iv_recycle_manager).setOnClickListener(this);

//        initDataFromBmob();
        initData();
        initToolBar();
        initFab();
        initDrawer();
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
    }

    private void initFab() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigation.setNavigationItemSelectedListener(this);
    }

    private void initRecyclerView(MainRecycleDataEntity dataEntity) {
        mAdapter = new MainRecycleAdapter(dataEntity);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnItemClickListener(new MainRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i, String s) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url", s);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://120.77.60.87:8890/getDailyData";
                OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(url)
                        .header("Content-Type", "application/json")
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful() && response.body() != null) {

                            String res = response.body().string();

//                            DailyEntity dailyEntity = new Gson().fromJson(res, DailyEntity.class);
//
//                            List<DailyEntity.ArticleListBean> listBeans = new ArrayList<>();
//
//                            for (DailyEntity.ArticleListBean articleListBean : dailyEntity.getArticle_list()) {
//                                if (Integer.parseInt(articleListBean.getArticle_worthy()) > 10 &&
//                                        Integer.parseInt(articleListBean.getArticle_comment()) > 15) {
//                                    listBeans.add(articleListBean);
//                                }
//                            }

                        } else {
                            Message msg = Message.obtain();
                            msg.obj = "response is null";
                            msg.what = 2;
                            mHandler.sendMessage(msg);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        Message msg = Message.obtain();
                        msg.obj = "failed" + e.toString();
                        msg.what = 2;
                        mHandler.sendMessage(msg);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_time_sort:
                mAdapter.getDataEntity().setSortRule(MainRecycleDataEntity.SortRule.Time);
                Collections.sort(mAdapter.getDataEntity().getResults());
                mAdapter.notifyDataSetChanged();
                mRecyclerView.smoothScrollToPosition(0);
                break;
            case R.id.tv_worthy_sort:
                mAdapter.getDataEntity().setSortRule(MainRecycleDataEntity.SortRule.Worthy);
                Collections.sort(mAdapter.getDataEntity().getResults());
                mAdapter.notifyDataSetChanged();
                mRecyclerView.smoothScrollToPosition(0);
                break;
            case R.id.tv_collection_sort:
                mAdapter.getDataEntity().setSortRule(MainRecycleDataEntity.SortRule.Collection);
                Collections.sort(mAdapter.getDataEntity().getResults());
                mAdapter.notifyDataSetChanged();
                mRecyclerView.smoothScrollToPosition(0);
                break;
            case R.id.iv_recycle_manager:
                if (mAdapter.getLayoutType() == MainRecycleAdapter.RecycleLayoutType.VERTICAL) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                    mRecyclerView.setLayoutManager(linearLayoutManager);
                    mAdapter.setLayoutType(MainRecycleAdapter.RecycleLayoutType.HORIZONTAL);
                } else {
                    GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mAdapter.setLayoutType(MainRecycleAdapter.RecycleLayoutType.VERTICAL);
                }
                mRecyclerView.setAdapter(mAdapter);
                break;
        }
    }
}
