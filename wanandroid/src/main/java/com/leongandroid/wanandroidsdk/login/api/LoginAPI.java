package com.leongandroid.wanandroidsdk.login.api;

import android.support.annotation.NonNull;

public interface LoginAPI {

    //--- login ------------------------------------------------------------------------------------
    /**
     * 登录时调用
     *
     *  http://www.wanandroid.com/user/login
     * @param user_name 用户名
     * @param password  密码
     */
    String login(@NonNull String user_name, @NonNull String password);

    /**
     * 用户登出
     */
    void logout();

    /**
     * 是否登录
     * @return 是否登录
     */
    boolean isLogin();


}
