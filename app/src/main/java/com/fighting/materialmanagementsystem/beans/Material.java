package com.fighting.materialmanagementsystem.beans;


import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by JP on 2016/1/20.
 */
public class Material extends BmobObject implements Serializable{
    private String name;
    private Integer allNumber;
    private Integer brokenNumber;
    private Integer restNumber;
    private Integer publicNumber;
    private Boolean isImportant;
    private Organization organization;
    private _User callPerson;
    private String place;
    private Double pledgePrice;///押金
    private Double rentPrice;//租金
    private Double price;//单价
    private String remark;

    public Material(String name, Integer allNumber, Integer brokenNumber, Integer restNumber, Integer publicNumber, Boolean isImportant, Organization organization, _User callPerson, String place, Double pledgePrice, Double rentPrice, Double price, String remark) {
        this.name = name;
        this.allNumber = allNumber;
        this.brokenNumber = brokenNumber;
        this.restNumber = restNumber;
        this.publicNumber = publicNumber;
        this.isImportant = isImportant;
        this.organization = organization;
        this.callPerson = callPerson;
        this.place = place;
        this.pledgePrice = pledgePrice;
        this.rentPrice = rentPrice;
        this.price = price;
        this.remark = remark;
    }


    public String getName() {
        return name;
    }

    public Integer getAllNumber() {
        return allNumber;
    }

    public Integer getBrokenNumber() {
        return brokenNumber;
    }

    public Integer getRestNumber() {
        return restNumber;
    }

    public Integer getPublicNumber() {
        return publicNumber;
    }

    public Boolean getImportant() {
        return isImportant;
    }

    public Organization getOrganization() {
        return organization;
    }

    public _User getCallPerson() {
        return callPerson;
    }

    public String getPlace() {
        return place;
    }

    public Double getPledgePrice() {
        return pledgePrice;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public Double getPrice() {
        return price;
    }

    public String getRemark() {
        return remark;
    }
}
