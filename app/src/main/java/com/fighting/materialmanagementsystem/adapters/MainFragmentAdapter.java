package com.fighting.materialmanagementsystem.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/2.
 */
public class MainFragmentAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;

    public MainFragmentAdapter(FragmentManager fm,List<Fragment> fragmentList){
        super(fm);
        this.fragmentList = fragmentList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return null==fragmentList?0:fragmentList.size();
    }
}
