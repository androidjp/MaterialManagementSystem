package com.fighting.materialmanagementsystem.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/5.
 */
public class ViewPagerTabs implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private List<View> viewList;
    private ViewPager viewPager;
    private Context context;
    private int CurrentPage=0;

    public ViewPagerTabs(Context context,ViewPager viewPager,List<View> views){

        this.viewList=views;
        this.viewPager = viewPager;
        this.context = context;

        viewPager.addOnPageChangeListener(this);

        for (int i=0;i<views.size();i++){
            viewList.get(i).setOnClickListener(this);
        }

        viewPager.setCurrentItem(CurrentPage);
        viewList.get(CurrentPage);
    }


    @Override
    public void onClick(View v) {
        for (int i=0;i<viewList.size();i++){
            if (v.getId()==viewList.get(i).getId()){
                viewList.get(i).setSelected(true);
                viewPager.setCurrentItem(i);
            }
            viewList.get(i).setSelected(false);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<viewList.size();i++){
            if (position==i){
                viewList.get(i).setSelected(true);
            }
            viewList.get(i).setSelected(false);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
