package com.leongandroid.wanandroidsdk.login.event;

import android.support.annotation.Nullable;

import com.leongandroid.wanandroidsdk.base.event.BaseEvent;
import com.leongandroid.wanandroidsdk.login.bean.LoginBean;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class LoginEvent extends BaseEvent<LoginBean> {
    private boolean isLogin = false;

    public LoginEvent(@Nullable String uuid) {
        super(uuid);
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
