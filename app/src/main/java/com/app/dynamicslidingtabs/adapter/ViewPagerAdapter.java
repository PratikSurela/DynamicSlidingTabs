package com.app.dynamicslidingtabs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.app.dynamicslidingtabs.fragments.MainFragment;
import com.app.dynamicslidingtabs.model.WorldpopulationItem;

import java.util.ArrayList;

/**
 * Created by Pratik Surela on 13/6/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private MainFragment fragment = null;
    private ArrayList<WorldpopulationItem> arrayList = new ArrayList();

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs, ArrayList<WorldpopulationItem> arrayList) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.arrayList = arrayList;
    }

    @Override
    public Fragment getItem(int position) {

        for (int i = 0; i < mNumOfTabs; i++) {
            if (i == position) {
                fragment = new MainFragment();
                fragment.update(arrayList, position);
                break;
            }
        }
        return fragment;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position).getCountry();
    }
}