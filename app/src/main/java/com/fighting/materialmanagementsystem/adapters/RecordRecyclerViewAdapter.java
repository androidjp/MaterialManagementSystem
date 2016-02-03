package com.fighting.materialmanagementsystem.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.beans.BorrowRecord;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/3.
 */
public class RecordRecyclerViewAdapter extends RecyclerView.Adapter<RecordRecyclerViewAdapter.mViewHolder> {

    List<BorrowRecord> recordsList;
    Context context;

    public RecordRecyclerViewAdapter(Context context,List<BorrowRecord> recordsList){
        this.recordsList = recordsList;
        this.context=context;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_record,null);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, final int position) {
        holder.tv_person_borrower.setText(recordsList.get(position).getBorrower().getUsername());
        holder.tv_person_lender.setText(recordsList.get(position).getLender().getUsername());
        holder.tv_extra_record.setText(recordsList.get(position).getExtra());
        holder.tv_department_borrower.setText(recordsList.get(position).getBorrower().getOrganization().getDepartment());
        holder.tv_department_lender.setText(recordsList.get(position).getLender().getOrganization().getDepartment());
        holder.tv_time_begin.setText(recordsList.get(position).getStartAt().getDate());
        holder.tv_time_end.setText(recordsList.get(position).getEndAt().getDate());
//        holder.tv_time_begin.setText(recordsList.get(position).getStartAt().getYear()+" 年 "+recordsList.get(position).getStartAt().getMonth()+" 月 "+recordsList.get(position).getStartAt().getDay()+" 日 ");
//        holder.tv_time_end.setText(recordsList.get(position).getEndAt().getYear()+" 年 "+recordsList.get(position).getEndAt().getMonth()+" 月 "+recordsList.get(position).getEndAt().getYear()+" 日 ");

        if(recordsList.get(position).getIsAccept()==0){
            holder.tv_state.setText("待批准");
            holder.tv_state.setBackgroundColor(context.getResources().getColor(R.color.state_wait));
        }else if(recordsList.get(position).getIsAccept()==2){
            holder.tv_state.setText("不批准");
            holder.tv_state.setBackgroundColor(context.getResources().getColor(R.color.state_reduce));
        }else {
//            if ((new Date(System.currentTimeMillis()).compareTo(recordsList.get(position).getEndAt()))<0){
//                holder.tv_state.setText("租借中");
//                holder.tv_state.setBackgroundColor(context.getResources().getColor(R.color.state_accept));
//            }else {
//                holder.tv_state.setText("逾 期");
//                holder.tv_state.setBackgroundColor(context.getResources().getColor(R.color.state_out_date));
//            }
        }

        holder.viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListner.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return null==recordsList?0:recordsList.size();
    }


    class mViewHolder extends RecyclerView.ViewHolder{
        ViewGroup viewGroup;
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
            viewGroup = (ViewGroup)itemView.findViewById(R.id.viewgroup_recorditem);
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

}
