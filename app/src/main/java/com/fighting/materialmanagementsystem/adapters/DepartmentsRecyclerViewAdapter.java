package com.fighting.materialmanagementsystem.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fighting.materialmanagementsystem.MyApplication;
import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.beans.Organization;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class DepartmentsRecyclerViewAdapter extends RecyclerView.Adapter<DepartmentsRecyclerViewAdapter.mViewHolder>{

    private List<Organization> organizations;

    public DepartmentsRecyclerViewAdapter(List<Organization> organizations){
        this.organizations=organizations;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_departments,null);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, final int position) {
        holder.tv_department.setText(organizations.get(position).getDepartment());
        int i=1;
        int courtByDepartment=0;
        for(;i<=MyApplication.ShoppingCar.size();i++){
            if(organizations.get(position).getObjectId().equals(MyApplication.ShoppingCar.get(i).getMaterial().getOrganization().getObjectId())){
                courtByDepartment+=MyApplication.ShoppingCar.get(i).getCourtInCar();
            }
        }

        if(courtByDepartment!=0){
            holder.tv_count_department.setText(courtByDepartment);
        }

        holder.viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOnRcyItemClickListner.OnItemClick(v,position,organizations);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null==organizations?0:organizations.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        ViewGroup viewGroup;
        TextView tv_department;
        TextView tv_count_department;

        public mViewHolder(View itemView) {
            super(itemView);
            viewGroup = (ViewGroup)itemView.findViewById(R.id.viewgroup_department);
            tv_department = (TextView) itemView.findViewById(R.id.tv_item_departments);
            tv_count_department = (TextView) itemView.findViewById(R.id.tv_count_department);
        }
    }


    private OnRcyItemClickListener mOnRcyItemClickListner;

    public interface OnRcyItemClickListener{
        void OnItemClick(View view ,int position,List<Organization> data);
    }
    public void setOnItemClickListener(OnRcyItemClickListener onRcyItemClickListener){
        this.mOnRcyItemClickListner = onRcyItemClickListener;
    }

}
