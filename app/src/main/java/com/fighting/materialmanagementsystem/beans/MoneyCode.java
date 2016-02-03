package com.fighting.materialmanagementsystem.beans;


import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by JP on 2016/1/28.
 */
public class MoneyCode extends BmobObject implements Serializable{
    private String code;
    private BorrowRecord borrowRecord;


}
