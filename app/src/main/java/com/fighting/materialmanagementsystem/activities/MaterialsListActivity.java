package com.fighting.materialmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fighting.materialmanagementsystem.MyApplication;
import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.adapters.DepartmentsRecyclerViewAdapter;
import com.fighting.materialmanagementsystem.adapters.MaterialsRecyclerViewAdapter;
import com.fighting.materialmanagementsystem.beans.Material;
import com.fighting.materialmanagementsystem.beans.Organization;
import com.fighting.materialmanagementsystem.utils.NetworkChecker;
import com.fighting.materialmanagementsystem.utils.SystemBarChanger;

import java.util.List;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class MaterialsListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rv_departments;
    private RecyclerView rv_materials;
    private DepartmentsRecyclerViewAdapter adapter_D;
    private MaterialsRecyclerViewAdapter adapter_M;
    private List<Material> materials;
    private Organization org_material_index;
    private List<Organization> organizations;
    private double shoppingcar_money=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials_list);

        getMaterials();

        initToolBar();
        initShoppingCarBar();
        initDepartmentRecycler();
        initMaterialsRecycler();
    }

    private void getMaterials(){
        if(NetworkChecker.isNetworkConnected(MaterialsListActivity.this)){
            //TODO 访问网络，并添加数据 eg:borrowRecords=XXXX;

            if(this.materials!=null && this.materials.size()>0){

            }else {
                Toast.makeText(MaterialsListActivity.this, "你还没有物资~", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(MaterialsListActivity.this,"没有网络信号~",Toast.LENGTH_SHORT).show();
        }
    }

    private void initToolBar() {
        SystemBarChanger.initSystemBar(this, R.color.colorPrimary);//更改SystemBar颜色
        findViewById(R.id.if_back).setOnClickListener(this);
        findViewById(R.id.if_search).setOnClickListener(this);
    }

    private void initDepartmentRecycler(){
        if(null!=materials){
            for(Material material:materials){
                for(int i=1;i<=organizations.size();i++){
                    if(!material.getOrganization().getObjectId().equals(organizations.get(i).getObjectId())){
                        organizations.add(material.getOrganization());
                    }
                }
            }
            org_material_index=organizations.get(1);
        }

        rv_departments = (RecyclerView) findViewById(R.id.departments_recyclerview);
        rv_departments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter_D = new DepartmentsRecyclerViewAdapter(organizations);
        adapter_D.setOnItemClickListener(new DepartmentsRecyclerViewAdapter.OnRcyItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, List<Organization> data) {
                org_material_index = data.get(position);
                adapter_M.notifyDataSetChanged();
            }
        });
        rv_departments.setAdapter(adapter_D);

    }

    private void initMaterialsRecycler(){
        rv_materials = (RecyclerView) findViewById(R.id.materials_recyclerview);
        rv_materials.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter_M = new MaterialsRecyclerViewAdapter(materials,org_material_index,adapter_D);
        adapter_M.setOnItemClickListener(new MaterialsRecyclerViewAdapter.OnRcyItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Intent intent = new Intent(MaterialsListActivity.this, MaterialDetailsActivity.class);
                intent.putExtra("material", materials.get(position));
                startActivity(intent);
            }
        });
        rv_materials.setAdapter(adapter_M);
    }

    private void initShoppingCarBar(){
        TextView tv_shopcar_commit = (TextView)findViewById(R.id.tv_shopcar_commit);
        tv_shopcar_commit.setOnClickListener(this);

        LinearLayout layout_shoppingcar_button = (LinearLayout)findViewById(R.id.layout_shoppingcar_button);
        layout_shoppingcar_button.setOnClickListener(this);

        TextView tv_shoppingcar_money = (TextView)findViewById(R.id.tv_shoppingcar_money);
        for(int i=1;i<= MyApplication.ShoppingCar.size();i++){
            if(org_material_index.equals(MyApplication.ShoppingCar.get(i).getMaterial().getOrganization())){
                shoppingcar_money += MyApplication.ShoppingCar.get(i).getCourtInCar()*MyApplication.ShoppingCar.get(i).getMaterial().getRentPrice();
            }
        }
        tv_shoppingcar_money.setText(shoppingcar_money+"");
        shoppingcar_money=0;
    }

    private void initCommitDialog(){
        String message="";
        if(null!=org_material_index && null!=MyApplication.ShoppingCar){
            message="向"+org_material_index.getDepartment()+"借：\n";
            for(int i=1;i<= MyApplication.ShoppingCar.size();i++){
                if (org_material_index.getObjectId().equals(MyApplication.ShoppingCar.get(i).getMaterial().getObjectId())){
                    message =message+MyApplication.ShoppingCar.get(i).getMaterial().getName()+"    "+MyApplication.ShoppingCar.get(i).getCourtInCar()+MyApplication.ShoppingCar.get(i).getMaterial()+"\n";
                }
            }
        }else {
            message="没有物资";
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(MaterialsListActivity.this);
        dialog.setTitle("请确认清单");
        dialog.setMessage(message);
        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //// TODO: 2016/2/1 上传到数据库
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.if_back:
                finish();
                break;
            case R.id.if_search:
                //TODO
                break;
            case R.id.tv_shopcar_commit:
                initCommitDialog();
                break;
            case R.id.layout_shoppingcar_button:
                //TODO
                break;
        }
    }

}
