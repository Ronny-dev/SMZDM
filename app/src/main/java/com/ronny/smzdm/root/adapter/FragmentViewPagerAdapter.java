package com.ronny.smzdm.root.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ronny.smzdm.root.fragment.ArticleFragment;
import com.ronny.smzdm.root.fragment.DailyFragment;
import com.ronny.smzdm.root.fragment.HourFragment;
import com.ronny.smzdm.root.fragment.SettingFragment;

/**
 * @author Ronny
 * @date 2019-09-24.
 * description：
 */
public class FragmentViewPagerAdapter extends FragmentStateAdapter {

    public FragmentViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DailyFragment();
            case 1:
                return new HourFragment();
            case 2:
                return new ArticleFragment();
            case 3:
                return new SettingFragment();
        }
        return new DailyFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
