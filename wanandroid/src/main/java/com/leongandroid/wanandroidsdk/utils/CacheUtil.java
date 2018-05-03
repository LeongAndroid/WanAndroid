package com.leongandroid.wanandroidsdk.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.leongandroid.wanandroidsdk.login.bean.LoginBean;

/**
 * Created by LeongAndroid on 2018/5/3.
 * 缓存工具类，用于缓存各类数据
 */

public class CacheUtil {
    ACache cache;

    public CacheUtil(Context context) {
        cache = ACache.get(context);
    }

    //--- token ------------------------------------------------------------------------------------

    public void saveLogin(@NonNull LoginBean bean){
        cache.put("login_bean", bean);
    }

    public LoginBean getLoginBean(){
        return (LoginBean) cache.getAsObject("login_bean");
    }

    public void clearLogin(){
        cache.remove("login_bean");
    }
}
