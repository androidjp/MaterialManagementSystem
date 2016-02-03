package com.fighting.materialmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.beans._User;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/2.
 */
public class PhonesFragment extends Fragment{
    private List<_User> users;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_phones, container, false);





        return rootView;
    }

    private void initDataSource(){
        for(_User user:users){

        }
    }

    private void initRecyclerView(){
        RecyclerView rv =(RecyclerView) rootView.findViewById(R.id.rv_phones);
        rv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
