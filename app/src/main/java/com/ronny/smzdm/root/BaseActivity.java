package com.ronny.smzdm.root;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.ronny.smzdm.R;
import com.ronny.smzdm.root.adapter.FragmentViewPagerAdapter;
import com.ronny.smzdm.root.ui.TabView;
import com.ronny.smzdm.root.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ronny
 * @date 2019-09-24.
 * description：
 */
public class BaseActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    private List<TabView> mTabViews = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        initSystemBar();

        initView();

        initViewPager();

        initViewPagerScrolledListener();
    }

    private void initViewPagerScrolledListener() {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTabViews.get(position).setXPercentage(1 - positionOffset);
                if (positionOffset > 0) {
                    mTabViews.get(position + 1).setXPercentage(positionOffset);
                }
            }
        });
    }

    private void initSystemBar() {
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            StatusBarUtil.setStatusBarColor(this, 0x55000000);
        }
    }

    private void initView() {
        viewPager2 = findViewById(R.id.view_pager);

        mTabViews.add((TabView) findViewById(R.id.tab_daily));
        mTabViews.add((TabView) findViewById(R.id.tab_hour));
        mTabViews.add((TabView) findViewById(R.id.tab_article));
        mTabViews.add((TabView) findViewById(R.id.tab_profile));
    }

    private void initViewPager() {
        FragmentViewPagerAdapter pagerAdapter =
                new FragmentViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        viewPager2.setAdapter(pagerAdapter);
    }
}
