package com.fighting.materialmanagementsystem.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.adapters.PhonesRecyclerViewAdapter;
import com.fighting.materialmanagementsystem.beans._User;
import com.fighting.materialmanagementsystem.utils.NameSorter;
import com.fighting.materialmanagementsystem.utils.NetworkChecker;

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

        getAndSortDataSource();

        return rootView;
    }

    private void getAndSortDataSource(){
        if(NetworkChecker.isNetworkConnected(getActivity())){
            //TODO 访问网络，并添加数据 eg:borrowRecords=XXXX;

            if(this.users!=null && this.users.size()>0){
                initRecyclerView();
            }else {
                Toast.makeText(getActivity(), "你还没有记录~", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(),"没有网络信号~",Toast.LENGTH_SHORT).show();
        }
    }

    private void initRecyclerView(){
        users = NameSorter.sort(users);

        RecyclerView rv =(RecyclerView) rootView.findViewById(R.id.rv_phones);
        PhonesRecyclerViewAdapter adapter = new PhonesRecyclerViewAdapter(users);
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new PhonesRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + users.get(position).getShortMobilePhoneNumber());
                intent.setData(data);
                startActivity(intent);
            }
        });

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
