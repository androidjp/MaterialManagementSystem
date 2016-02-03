package com.fighting.materialmanagementsystem.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.fighting.materialmanagementsystem.MyApplication;
import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.beans.Material;
import com.fighting.materialmanagementsystem.beans.Organization;
import com.fighting.materialmanagementsystem.beans.ShoppingCarBean;
import com.fighting.materialmanagementsystem.views.IconFontView;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class MaterialsRecyclerViewAdapter extends RecyclerView.Adapter<MaterialsRecyclerViewAdapter.mViewHolder>{

    private Organization org;
    private List<Material> materials_department;
    private MaterialsRecyclerViewAdapter materialsRecyclerViewAdapter;
    private DepartmentsRecyclerViewAdapter departmentsRecyclerViewAdapter;


    public MaterialsRecyclerViewAdapter(List<Material> materials,Organization org,DepartmentsRecyclerViewAdapter adapter){
        this.org=org;

        if (null!=materials_department){
            materials_department.clear();
        }

        if(null!=materials){
            for(Material material:materials){
                if(material.getOrganization().getDepartment().equals(org.getDepartment())){
                    materials_department.add(material);
                }
            }
        }
        this.materialsRecyclerViewAdapter=this;
        this.departmentsRecyclerViewAdapter=adapter;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_materials,null);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final mViewHolder holder, final int position) {
        holder.tv_material_name.setText(materials_department.get(position).getName());
        holder.tv_actuallynum.setText(materials_department.get(position).getAllNumber()-materials_department.get(position).getBrokenNumber());
        holder.tv_totalnum.setText(materials_department.get(position).getAllNumber());
        holder.tv_material_money.setText(materials_department.get(position).getRentPrice().toString());

        holder.if_material_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=1;
                for(;i<=MyApplication.ShoppingCar.size();i++){
                    if(materials_department.get(position).getObjectId().equals(MyApplication.ShoppingCar.get(i).getMaterial().getObjectId())){
                        MyApplication.ShoppingCar.get(i).addCourtInCar(1);
                        break;
                    }
                }
                MyApplication.ShoppingCar.add(new ShoppingCarBean(materials_department.get(position), 1));

                holder.if_material_remove.setVisibility(View.VISIBLE);
                holder.et_requested_num.setVisibility(View.VISIBLE);
                holder.et_requested_num.setText(MyApplication.ShoppingCar.get(i).getCourtInCar());
                materialsRecyclerViewAdapter.notifyItemChanged(position);
                departmentsRecyclerViewAdapter.notifyDataSetChanged();
            }
        });

        holder.if_material_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=1;
                for(;i<=MyApplication.ShoppingCar.size();i++){
                    if(materials_department.get(position).getObjectId().equals(MyApplication.ShoppingCar.get(i).getMaterial().getObjectId())){
                        MyApplication.ShoppingCar.get(i).removeCourtInCar(1);
                        break;
                    }
                }
                if(MyApplication.ShoppingCar.get(i).getCourtInCar()==0){
                    holder.if_material_remove.setVisibility(View.GONE);
                    holder.et_requested_num.setVisibility(View.GONE);
                }

                materialsRecyclerViewAdapter.notifyItemChanged(position);
                departmentsRecyclerViewAdapter.notifyDataSetChanged();

            }
        });

        holder.rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnRcyItemClickListner.OnItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null==materials_department?0:materials_department.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder{
        TextView tv_material_name;
        TextView tv_actuallynum;
        TextView tv_totalnum;
        TextView tv_material_money;
        ViewGroup rootview;
        IconFontView if_material_remove;
        IconFontView if_material_add;
        EditText et_requested_num;

        public mViewHolder(View itemView) {
            super(itemView);
            tv_material_name=(TextView)itemView.findViewById(R.id.tv_material_name);
            tv_actuallynum=(TextView) itemView.findViewById(R.id.tv_actuallynum);
            tv_totalnum=(TextView)itemView.findViewById(R.id.tv_totalnum);
            tv_material_money=(TextView)itemView.findViewById(R.id.tv_material_money);
            rootview=(ViewGroup)itemView.findViewById(R.id.groupview_materials_item);
            if_material_add=(IconFontView)itemView.findViewById(R.id.material_add);
            if_material_remove=(IconFontView)itemView.findViewById(R.id.material_remove);
            et_requested_num=(EditText)itemView.findViewById(R.id.et_requested_num);
        }
    }

    private OnRcyItemClickListener mOnRcyItemClickListner;

    public interface OnRcyItemClickListener{
        void OnItemClick(View view ,int position);
    }
    public void setOnItemClickListener(OnRcyItemClickListener onRcyItemClickListener){
        this.mOnRcyItemClickListner = onRcyItemClickListener;
    }
}
