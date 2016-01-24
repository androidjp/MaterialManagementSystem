package com.fighting.materialmanagementsystem.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.adapters.DepartmentsRecyclerViewAdapter;
import com.fighting.materialmanagementsystem.adapters.MaterialsRecyclerViewAdapter;
import com.fighting.materialmanagementsystem.utils.SystemBarChanger;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class MaterialsListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rv_departments;
    private RecyclerView rv_materials;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_materials_list);
        SystemBarChanger.initSystemBar(this, R.color.colorPrimary);

        initViews();
    }

    private void initViews(){
        rv_departments = (RecyclerView) findViewById(R.id.departments_recyclerview);
        rv_materials = (RecyclerView) findViewById(R.id.materials_recyclerview);

        rv_departments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_materials.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        DepartmentsRecyclerViewAdapter adapter_D = new DepartmentsRecyclerViewAdapter();
        MaterialsRecyclerViewAdapter adapter_M = new MaterialsRecyclerViewAdapter();
        rv_departments.setAdapter(adapter_D);
        rv_materials.setAdapter(adapter_M);




    }

    @Override
    public void onClick(View v) {

    }

}
