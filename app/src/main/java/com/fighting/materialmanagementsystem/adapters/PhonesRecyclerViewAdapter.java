package com.fighting.materialmanagementsystem.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.beans._User;

import java.util.List;

/**
 * Created by laisixiang on 2016/2/4.
 */
public class PhonesRecyclerViewAdapter extends RecyclerView.Adapter<PhonesRecyclerViewAdapter.Holder>{
    List<_User> users;

    public PhonesRecyclerViewAdapter(List<_User> users){
        this.users = users;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_phone,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.tv_name.setText(users.get(position).getUsername());
        holder.tv_department.setText(users.get(position).getOrganization().getDepartment());
        holder.tv_phone.setText(users.get(position).getShortMobilePhoneNumber());
        // TODO: 2016/2/4 等确定UserDailyLevel 再说
//        switch (users.get(position).getUserLevel()){
//            case
//        }

        holder.viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users==null?0:users.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ViewGroup viewGroup;
        TextView tv_name;
        TextView tv_level;
        TextView tv_department;
        TextView tv_phone;

        public Holder(View itemView) {
            super(itemView);
            viewGroup=(ViewGroup)itemView.findViewById(R.id.viewgroup_phone);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_level=(TextView)itemView.findViewById(R.id.tv_level);
            tv_department=(TextView)itemView.findViewById(R.id.tv_department);
            tv_phone=(TextView)itemView.findViewById(R.id.tv_phone);
        }
    }

    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
    public void setOnItemClickListener(PhonesRecyclerViewAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
}
