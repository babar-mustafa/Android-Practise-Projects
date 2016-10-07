package com.example.babarmustafa.tabs_practise;

/**
 * Created by Babar Mustafa on 10/7/2016.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/*
FragmentStatePagerAdapter:

with FragmentStatePagerAdapter,your unneeded fragment is destroyed.A transaction is committed to
completely remove the fragment from your activity's FragmentManager.
The state in FragmentStatePagerAdapter comes from the fact that it will save out your fragment's
Bundle from savedInstanceState when it is destroyed.When the user navigates back,the new fragment
will be restored using the fragment's state.
FragmentPagerAdapter:

By comparision FragmentPagerAdapter does nothing of the kind.When the fragment is no longer needed.
FragmentPagerAdapter calls detach(Fragment) on the transaction instead of remove(Fragment).
This destroy's the fragment's view but leaves the fragment's instance alive in the FragmentManager.
so the fragments created in the FragmentPagerAdapter are never destroyed.


 */

public class TabAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragmentArrayList;
    private Context mContext;

    public TabAdapter(FragmentManager fm, ArrayList<Fragment> mFragmentArrayList) {
        super(fm);
        this.mFragmentArrayList = mFragmentArrayList;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentArrayList.size();
    }
}
