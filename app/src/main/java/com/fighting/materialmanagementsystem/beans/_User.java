package com.fighting.materialmanagementsystem.beans;


import java.io.Serializable;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by JP on 2016/1/20.
 */
public class _User extends BmobUser implements Serializable {

    private Organization organization;
    private String shortMobilePhoneNumber;
    private Integer userLevel;
    private BmobDate userLevelDate;

    public _User(){

    }

    public _User(String username, String password, Boolean mobilePhoneNumberVerifed, String mobilePhoneNumberNumber, Boolean emailVerified, String email, Organization organization, String shortMobilePhoneNumber, Integer userLevel, BmobDate userLevelDate) {

        super.setUsername(username);
        super.setPassword(password);
        super.setMobilePhoneNumberVerified(mobilePhoneNumberVerifed);
        super.setMobilePhoneNumber(mobilePhoneNumberNumber);
        super.setEmailVerified(emailVerified);
        super.setEmail(email);

        this.organization = organization;
        this.shortMobilePhoneNumber = shortMobilePhoneNumber;
        this.userLevel = userLevel;
        this.userLevelDate = userLevelDate;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getShortMobilePhoneNumber() {
        return shortMobilePhoneNumber;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public BmobDate getUserLevelDate() {
        return userLevelDate;
    }
}
