package com.leongandroid.wanandroidsdk.base.callback;

import android.support.annotation.NonNull;
import android.util.Log;

import com.leongandroid.wanandroidsdk.base.event.BaseEvent;
import com.leongandroid.wanandroidsdk.login.bean.LoginBean;
import com.leongandroid.wanandroidsdk.login.event.LoginEvent;
import com.leongandroid.wanandroidsdk.utils.CacheUtil;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class LoginCallback extends BaseCallback<LoginBean> {
    private CacheUtil mCacheUtil;
    public <Event extends BaseEvent<LoginBean>> LoginCallback(@NonNull CacheUtil cacheUtil, @NonNull Event event) {
        super(event);
        mCacheUtil = cacheUtil;
    }

    @Override
    public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
        if (response.isSuccessful()) {
            LoginBean bean = response.body();
            if (bean.getErrorCode() >= 0) {
                /// login success
                mCacheUtil.saveLogin(bean);
                EventBus.getDefault().post(event.setEvent(response.code(), bean));
                return;
            }
        }
        EventBus.getDefault().post(event.setEvent(response.code(), null));
    }
}
