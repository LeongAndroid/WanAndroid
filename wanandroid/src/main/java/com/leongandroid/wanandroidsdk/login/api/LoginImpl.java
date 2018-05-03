package com.leongandroid.wanandroidsdk.login.api;

import android.content.Context;
import android.support.annotation.NonNull;

import com.leongandroid.wanandroidsdk.base.callback.BaseCallback;
import com.leongandroid.wanandroidsdk.base.impl.BaseImpl;
import com.leongandroid.wanandroidsdk.login.bean.LoginBean;
import com.leongandroid.wanandroidsdk.login.event.LoginEvent;
import com.leongandroid.wanandroidsdk.utils.UUIDGenerator;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class LoginImpl extends BaseImpl<LoginService>{

    public LoginImpl(@NonNull Context context) {
        super(context);
    }

    /**
     * 登录时调用
     *
     * @param user_name 用户名
     * @param password  密码
     * @see LoginEvent
     */
    public String login(@NonNull String user_name, @NonNull String password) {
        String uuid = UUIDGenerator.getUUID();
        mService.login(user_name, password).enqueue(new BaseCallback<LoginBean>(new LoginEvent(uuid)));
        return uuid;
    }

    public void logout() {

    }

    public boolean isLogin() {
        return false;
    }
}
