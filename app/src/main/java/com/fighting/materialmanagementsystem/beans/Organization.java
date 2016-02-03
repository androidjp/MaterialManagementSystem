package com.fighting.materialmanagementsystem.beans;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by JP on 2016/1/28.
 */
public class Organization extends BmobObject implements Serializable {

    private String department;

    public Organization(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
