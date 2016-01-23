package com.fighting.materialmanagementsystem.tables;

import java.util.Date;

/**
 * Created by laisixiang on 2016/1/20.
 */
public class _User {
    private String objectId;
    private String username;
    private String password;
    private boolean mobilePhoneNumberVerifed;
    private String mobilePhoneNumberNumber;
    private boolean emailVerified;
    private String email;
    private Date createdAt;
    private Date updateAt;
    private Orgizations orgization;
    private String shortMobilePhoneNumber;
    private int userLevel;
    private Date userLevelDate;

    public String getObjectId() {
        return objectId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isMobilePhoneNumberVerifed() {
        return mobilePhoneNumberVerifed;
    }

    public String getMobilePhoneNumberNumber() {
        return mobilePhoneNumberNumber;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public Orgizations getOrgization() {
        return orgization;
    }

    public String getShortMobilePhoneNumber() {
        return shortMobilePhoneNumber;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public Date getUserLevelDate() {
        return userLevelDate;
    }
}
