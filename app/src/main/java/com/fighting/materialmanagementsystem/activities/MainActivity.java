package com.fighting.materialmanagementsystem.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.fighting.materialmanagementsystem.R;
import com.fighting.materialmanagementsystem.adapters.MainFragmentAdapter;
import com.fighting.materialmanagementsystem.fragments.PhonesFragment;
import com.fighting.materialmanagementsystem.fragments.RecordFragment;
import com.fighting.materialmanagementsystem.fragments.StoreFragment;
import com.fighting.materialmanagementsystem.utils.SystemBarChanger;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener,ViewPager.OnPageChangeListener{

    ViewPager viewPager;
    LinearLayout store_tab,phones_tab,record_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bmob.initialize(this, "Your Application ID");

        setContentView(R.layout.activity_main);

        SystemBarChanger.initSystemBar(this, R.color.colorPrimary);
        initViews();
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initViews() {

        store_tab= (LinearLayout)findViewById(R.id.store_layout);
        phones_tab= (LinearLayout)findViewById(R.id.phones_layout);
        record_tab= (LinearLayout)findViewById(R.id.record_layout);

        //初始化Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);

        //初始化右下角悬浮按钮
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //Toggle：纽扣；连接ToolBar和Drawer；就是左上角那个按钮
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();//与Activity同步状态

        //侧面的菜单
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new RecordFragment());
        fragmentList.add(new StoreFragment());
        fragmentList.add(new PhonesFragment());
        MainFragmentAdapter mainAdapter=new MainFragmentAdapter(getSupportFragmentManager(),fragmentList);

        viewPager = (ViewPager)findViewById(R.id.viewpager_main);
        viewPager.setAdapter(mainAdapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);

        phones_tab.setOnClickListener(this);
        record_tab.setOnClickListener(this);
        store_tab.setOnClickListener(this);
        record_tab.setSelected(true);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.record_layout:
                viewPager.setCurrentItem(0);
                break;
            case R.id.store_layout:
                viewPager.setCurrentItem(1);
                break;
            case R.id.phones_layout:
                viewPager.setCurrentItem(2);
                break;
            case R.id.iconfont_addrecord:
                startActivity(new Intent(MainActivity.this, MaterialsListActivity.class));

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                phones_tab.setSelected(false);
                store_tab.setSelected(false);
                record_tab.setSelected(true);
                break;
            case 1:
                phones_tab.setSelected(false);
                store_tab.setSelected(true);
                record_tab.setSelected(false);
                break;
            case 2:
                phones_tab.setSelected(true);
                store_tab.setSelected(false);
                record_tab.setSelected(false);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
