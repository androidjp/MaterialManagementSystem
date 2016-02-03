package com.fighting.materialmanagementsystem.beans;



import java.io.Serializable;
import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by JP on 2016/1/20.
 */
public class BorrowRecord extends BmobObject implements Serializable{
    private _User lender;
    private _User borrower;
    private List<MoneyCode> moneyCode;
    private BmobDate actuallyStartAt;
    private BmobDate startAt;
    private BmobDate endAt;
    private BmobDate actuallyEndAt;
    private BmobDate responseAt;
    private Integer isAccept;
    private Material materialName;
    private Integer matarialNumber;
    private String recordCode;
    private Integer inNumber;
    private Integer outNumber;
    private Integer payMoney;
    private String extra;

    public BorrowRecord(_User lender, _User borrower, List<MoneyCode> moneyCode, BmobDate actuallyStartAt, BmobDate startAt, BmobDate endAt, BmobDate actuallyEndAt, BmobDate responseAt, Integer isAccept, Material materialName, Integer matarialNumber, String recordCode, Integer inNumber, Integer outNumber, Integer payMoney, String extra) {
        this.lender = lender;
        this.borrower = borrower;
        this.moneyCode = moneyCode;
        this.actuallyStartAt = actuallyStartAt;
        this.startAt = startAt;
        this.endAt = endAt;
        this.actuallyEndAt = actuallyEndAt;
        this.responseAt = responseAt;
        this.isAccept = isAccept;
        this.materialName = materialName;
        this.matarialNumber = matarialNumber;
        this.recordCode = recordCode;
        this.inNumber = inNumber;
        this.outNumber = outNumber;
        this.payMoney = payMoney;
        this.extra = extra;

    }

    public _User getLender() {
        return lender;
    }

    public _User getBorrower() {
        return borrower;
    }

    public List<MoneyCode> getMoneyCode() {
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

    public Integer getIsAccept() {
        return isAccept;
    }

    public Material getMaterialName() {
        return materialName;
    }

    public Integer getMatarialNumber() {
        return matarialNumber;
    }

    public String getRecordCode() {
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
