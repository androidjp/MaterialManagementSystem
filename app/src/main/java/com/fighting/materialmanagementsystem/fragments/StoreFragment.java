package com.fighting.materialmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fighting.materialmanagementsystem.R;

/**
 * Created by laisixiang on 2016/1/2.
 */
public class StoreFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_store, container, false);
        return view;
    }
}
