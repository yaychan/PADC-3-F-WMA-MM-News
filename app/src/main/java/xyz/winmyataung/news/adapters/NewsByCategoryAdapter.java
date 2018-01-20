package xyz.winmyataung.news.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 1/7/2018.
 */

public class NewsByCategoryAdapter extends FragmentStatePagerAdapter {
    /**
     * thu nae twell mae fragment list ta khu setup loat
     * tab Title a twat  collection attribute ta khu setup loat
     */
    private List<Fragment> mFragments;
    private List<String> mTabTitles;

    public NewsByCategoryAdapter(FragmentManager fm) {
        super(fm);
        /**
         * list ko intialize loat
         * ma loat yin null pointer exception tat mal
         */
        mFragments = new ArrayList<>();
        mTabTitles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }

    /**
     * tab ta khu lar htae pay pho method title and fragment (2 parameters)
     */
    public void addTab(String tabTitle, Fragment fragment){
        mTabTitles.add(tabTitle);
        mFragments.add(fragment);
        notifyDataSetChanged();

    }
}
