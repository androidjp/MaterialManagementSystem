package com.fighting.materialmanagementsystem.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.activities.RecordDetailsActivity;
import com.fighting.materialmanagementsystem.adapters.RecordRecyclerViewAdapter;
import com.fighting.materialmanagementsystem.tables.BorrowRecords;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * Created by laisixiang on 2016/1/2.
 */
public class RecordFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private BGARefreshLayout mRefreshLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<BorrowRecords> borrowRecords;
    private RecordRecyclerViewAdapter rvAdapter;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_record, container, false);
        initSwipeRefreshLayout(view);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        rv = (RecyclerView) view.findViewById(R.id.rv_recordlist);
        getBorrowRecords();
        rvAdapter = new RecordRecyclerViewAdapter(borrowRecords);
        rv.setAdapter(rvAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAdapter.setOnItemClickListener(new RecordRecyclerViewAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent();
                intent.putExtra("position_details", borrowRecords.get(position));
                startActivity(new Intent(getActivity(), RecordDetailsActivity.class));
            }
        });
        swipeRefreshLayout.setRefreshing(false);
    }

    private void initSwipeRefreshLayout(View view ){
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiper_record);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(getActivity().getResources().getColor(R.color.swipe_bg));
        swipeRefreshLayout.setColorSchemeColors(getActivity().getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setRefreshing(true);
    }


    public void getBorrowRecords() {
        //TODO 访问网络，并添加数据

    }

    @Override
    public void onRefresh() {
        getBorrowRecords();
        rvAdapter.notifyDataSetChanged();
    }
}
