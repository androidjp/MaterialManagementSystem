package com.fighting.materialmanagementsystem.tables;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class BorrowRecords extends BmobObject implements Serializable{
//    private String objectId;
    private _User lender;
    private _User borrower;
    private MoneyCodes moneyCode;
//    private Date createdAt;
    private BmobDate actuallyStartAt;
    private BmobDate startAt;
    private BmobDate endAt;
    private BmobDate actuallyEndAt;
    private BmobDate responseAt;
    private boolean isAccept;
//    private Date updatedAt;
    private Materials materialName;
    private Integer matarialNumber;
    private Integer recordCode;
    private Integer inNumber;
    private Integer outNumber;
    private Integer payMoney;
    private String extra;

    public _User getLender() {
        return lender;
    }

    public _User getBorrower() {
        return borrower;
    }

    public MoneyCodes getMoneyCode() {
        return moneyCode;
    }

    public BmobDate getActuallyStartAt() {
        return actuallyStartAt;
    }

    public BmobDate getStartAt() {
        return startAt;
    }

    public BmobDate getEndAt() {
        return endAt;
    }

    public BmobDate getActuallyEndAt() {
        return actuallyEndAt;
    }

    public BmobDate getResponseAt() {
        return responseAt;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public Materials getMaterialName() {
        return materialName;
    }

    public Integer getMatarialNumber() {
        return matarialNumber;
    }

    public Integer getRecordCode() {
        return recordCode;
    }

    public Integer getInNumber() {
        return inNumber;
    }

    public Integer getOutNumber() {
        return outNumber;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public String getExtra() {
        return extra;
    }
}
