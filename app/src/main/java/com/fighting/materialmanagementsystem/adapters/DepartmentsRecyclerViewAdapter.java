package com.fighting.materialmanagementsystem.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class DepartmentsRecyclerViewAdapter extends RecyclerView.Adapter<DepartmentsRecyclerViewAdapter.mViewHolder>{


    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class mViewHolder extends RecyclerView.ViewHolder{

        public mViewHolder(View itemView) {
            super(itemView);
        }
    }
}
