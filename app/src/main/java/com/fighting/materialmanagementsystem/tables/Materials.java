package com.fighting.materialmanagementsystem.tables;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class Materials implements Serializable{
    private String objectId;
    private String name;
    private int allNumber;
    private int brokenNumber;
    private int restNumber;
    private int publicNumber;
    private boolean isImportant;
    private Orgizations department;
    private _User owner;
    private String place;
    private int price;
//    private ArrayList<String> brokenRecords;
//    private ArrayList<String> materialsIdentifiers;
//    private ArrayList<String> borrowRecordThingses;
    private String remark;
    private Date createdAt;
    private Date updatedAt;

    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public int getAllNumber() {
        return allNumber;
    }

    public int getBrokenNumber() {
        return brokenNumber;
    }

    public int getRestNumber() {
        return restNumber;
    }

    public int getPublicNumber() {
        return publicNumber;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public Orgizations getDepartment() {
        return department;
    }

    public _User getOwner() {
        return owner;
    }

    public String getPlace() {
        return place;
    }

    public int getPrice() {
        return price;
    }

    public String getRemark() {
        return remark;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
