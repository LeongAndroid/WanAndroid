package com.leongandroid.wanandroidsdk.login.bean;


import java.io.Serializable;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class UserInfoBean implements Serializable {
    private String name;
    private String icon;

    public UserInfoBean(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
