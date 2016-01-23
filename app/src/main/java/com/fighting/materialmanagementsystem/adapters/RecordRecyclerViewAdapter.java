package com.fighting.materialmanagementsystem.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.tables.BorrowRecords;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/3.
 */
public class RecordRecyclerViewAdapter extends RecyclerView.Adapter<RecordRecyclerViewAdapter.mViewHolder> implements View.OnClickListener{

    List<BorrowRecords> recordsList;

    public RecordRecyclerViewAdapter(List<BorrowRecords> recordsList){
        this.recordsList = recordsList;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_record,null);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        holder.tv_person_borrower.setText(recordsList.get(position).getBorrower().getUsername());
        holder.tv_person_lender.setText(recordsList.get(position).getLender().getUsername());
        holder.tv_extra_record.setText(recordsList.get(position).getExtra());
        holder.tv_department_borrower.setText(recordsList.get(position).getBorrower().getOrgization().getDepartment());
        holder.tv_department_lender.setText(recordsList.get(position).getLender().getOrgization().getDepartment());
//        holder.tv_time_begin.setText(recordsList.get(position).getStartAt().getYear()+" 年 "+recordsList.get(position).getStartAt().getMonth()+" 月 "+recordsList.get(position).getStartAt().getDay()+" 日 ");
//        holder.tv_time_end.setText(recordsList.get(position).getEndAt().getYear()+" 年 "+recordsList.get(position).getEndAt().getMonth()+" 月 "+recordsList.get(position).getEndAt().getYear()+" 日 ");
        holder.tv_time_end.setText(recordsList.get(position).getEndAt().toString());

//        if(null == recordsList.get(position).isAccept()){
//
//        }
//        if(recordsList.get(position).isAccept()){
//            if((new Date(System.currentTimeMillis()).compareTo(recordsList.get(position).getActuallyStartAt()))<0){
//                holder.tv_state.setText("已批准");
//            }else{
//                if((new Date(System.currentTimeMillis()).compareTo(recordsList.get(position).getEndAt()))<0){
//
//                }else{
//                    holder.tv_state.setText("已借出");
//                }
//            }
//        }else if(){
//            holder.tv_state.setText("已拒绝");
//        }


    }

    @Override
    public int getItemCount() {
        return null==recordsList?0:recordsList.size();
    }


    class mViewHolder extends RecyclerView.ViewHolder{
        TextView tv_department_lender;
        TextView tv_department_borrower;
        TextView tv_person_lender;
        TextView tv_person_borrower;
        TextView tv_time_begin;
        TextView tv_time_end;
        TextView tv_state;
        TextView tv_extra_record;

        public mViewHolder(View itemView) {
            super(itemView);
            tv_department_lender=(TextView)itemView.findViewById(R.id.department_lender);
            tv_department_borrower =(TextView)itemView.findViewById(R.id.department_borrower);
            tv_person_lender =(TextView)itemView.findViewById(R.id.person_lender);
            tv_person_borrower =(TextView)itemView.findViewById(R.id.person_borrower);
            tv_time_begin = (TextView)itemView.findViewById(R.id.time_begin);
            tv_time_end = (TextView)itemView.findViewById(R.id.time_end);
            tv_state = (TextView) itemView.findViewById(R.id.state);
            tv_extra_record = (TextView)itemView.findViewById(R.id.extra_record);
        }
    }

    private OnItemClickListner onItemClickListner=null;

    public void setOnItemClickListener(OnItemClickListner listener){
        if (null!=listener){
            this.onItemClickListner=listener;
        }
    }

    public interface OnItemClickListner{
        void onItemClick(int position);
    }

    @Override
    public void onClick(View v) {
        //TODO
    }

}
