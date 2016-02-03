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
import android.widget.Toast;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.activities.MaterialsListActivity;
import com.fighting.materialmanagementsystem.activities.RecordDetailsActivity;
import com.fighting.materialmanagementsystem.adapters.RecordRecyclerViewAdapter;
import com.fighting.materialmanagementsystem.beans.BorrowRecord;
import com.fighting.materialmanagementsystem.utils.NetworkChecker;
import com.fighting.materialmanagementsystem.views.IconFontView;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/2.
 */
public class RecordFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout swipeRefreshLayout;
    private List<BorrowRecord> borrowRecords;
    private RecordRecyclerViewAdapter rvAdapter;
    private RecyclerView rv;
    private View rootView;

    private final int INIT=0;
    private final int NOTIFY=1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_record, container, false);

        initSwipeRefreshLayout();
        initRecyclerView();
        initFloatingActionButton();

        swipeRefreshLayout.setRefreshing(true);
        getANDsetBorrowRecords(INIT);
        swipeRefreshLayout.setRefreshing(false);

        return rootView;
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        getANDsetBorrowRecords(NOTIFY);
        swipeRefreshLayout.setRefreshing(false);
    }

    /**1、判断网络情况
     * 2、获取记录
     * 3、判断记录是否Null
     * @param type 1、INIT初始化 2、NOTIFY 通过notifyDataSetChanged()
     */
    private void getANDsetBorrowRecords(int type) {
        if(NetworkChecker.isNetworkConnected(getActivity())){
            //TODO 访问网络，并添加数据 eg:borrowRecords=XXXX;

            if(this.borrowRecords!=null && this.borrowRecords.size()>0){
                if (type == INIT){
                    rvAdapter.notifyDataSetChanged();
                }else{
                    initRecyclerView();
                }
            }else {
                Toast.makeText(getActivity(),"你还没有记录~",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(),"没有网络信号~",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 初始化右下角的记录添加按钮
     */
    private void initFloatingActionButton(){
        ((IconFontView) rootView.findViewById(R.id.iconfont_addrecord)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MaterialsListActivity.class));
            }
        });
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        rv = (RecyclerView) rootView.findViewById(R.id.rv_recordlist);
        rvAdapter = new RecordRecyclerViewAdapter(getActivity(),borrowRecords);
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
    }

    /**
     * 初始化下拉刷新
     */
    private void initSwipeRefreshLayout(){
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swiper_record);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(getActivity().getResources().getColor(R.color.swipe_bg));
        swipeRefreshLayout.setColorSchemeColors(getActivity().getResources().getColor(R.color.colorPrimary));
    }
}
