package com.fighting.materialmanagementsystem.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.adapters.DepartmentsRecyclerViewAdapter;
import com.fighting.materialmanagementsystem.adapters.MaterialsListViewAdapter;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class MaterialsListActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rv_departments;
    private RecyclerView rv_materials;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_materials_listview);


        initViews();
    }

    private void initViews(){
        rv_departments = (RecyclerView) findViewById(R.id.departments_recyclerview);
        rv_materials = (RecyclerView) findViewById(R.id.materials_recyclerview);

        rv_departments.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv_materials.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        rv_departments.setAdapter(new DepartmentsRecyclerViewAdapter());
        rv_materials.setAdapter(new MaterialsListViewAdapter());


    }

    @Override
    public void onClick(View v) {

    }
}
