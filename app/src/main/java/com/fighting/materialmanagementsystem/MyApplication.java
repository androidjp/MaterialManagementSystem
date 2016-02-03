package com.fighting.materialmanagementsystem;

import android.app.Application;

import com.fighting.materialmanagementsystem.beans.ShoppingCarBean;
import com.fighting.materialmanagementsystem.beans._User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laisixiang on 2016/1/31.
 */
public class MyApplication extends Application{
    public static  _User admin;

    public static List<ShoppingCarBean> ShoppingCar =new ArrayList<ShoppingCarBean>();

}
