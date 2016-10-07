package com.example.babarmustafa.tabs_practise;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabAdapter adapter;
    private ArrayList<Fragment> mFragmentArrayList;
    private Tab1 mTab1;
    private Tab2 mTab2;
    private Tab3 mTab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTab1 = new Tab1();
        mTab2 = new Tab2();
        mTab3 = new Tab3();

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mFragmentArrayList = new ArrayList<>();
           /*
        * add Fragment to ArrayList
        */
        mFragmentArrayList.add(mTab1);
        mFragmentArrayList.add(mTab2);
        mFragmentArrayList.add(mTab3);

        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 1").setIcon(R.drawable.d));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 3"));

        adapter = new TabAdapter(getSupportFragmentManager(), mFragmentArrayList);

        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mViewPager.setOffscreenPageLimit(0);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}