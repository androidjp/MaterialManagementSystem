package com.fighting.materialmanagementsystem.activities;

import android.app.Activity;
import android.os.Bundle;

import com.fighting.materialmanagementsystem.beans.Material;

/**
 * Created by laisixiang on 2016/2/1.
 */
public class MaterialDetailsActivity extends Activity{
    private Material material;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent()!=null){
            material=(Material)getIntent().getExtras().get("material");
        }
    }
}
