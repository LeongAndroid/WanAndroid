package com.leongandroid.wanandroidsdk;

import android.content.Context;
import android.support.annotation.NonNull;

import com.leongandroid.wanandroidsdk.login.api.LoginAPI;
import com.leongandroid.wanandroidsdk.login.api.LoginImpl;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class WanAndroid implements LoginAPI{

    private static LoginImpl mLoginImpl;
    private volatile static WanAndroid mWanAndroid;
    private WanAndroid() {
    }

    public static WanAndroid getInstance() {
        if(null == mWanAndroid) {
            synchronized (WanAndroid.class) {
                if (null == mWanAndroid) {
                    mWanAndroid = new WanAndroid();
                }
            }
        }
        return mWanAndroid;
    }

    /**
     * 初始化，开放接口，初始化在应用的application中
     * @param context
     * @return
     */
    public static WanAndroid init(Context context) {
        mLoginImpl = new LoginImpl(context);
        return getInstance();
    }


    @Override
    public String login(@NonNull String user_name, @NonNull String password) {
        return mLoginImpl.login(user_name, password);
    }

    @Override
    public void logout() {
        mLoginImpl.logout();
    }

    @Override
    public boolean isLogin() {
        return mLoginImpl.isLogin();
    }
}
