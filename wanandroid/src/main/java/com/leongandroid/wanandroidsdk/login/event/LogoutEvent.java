package com.leongandroid.wanandroidsdk.login.event;

import android.support.annotation.Nullable;

import com.leongandroid.wanandroidsdk.base.event.BaseEvent;
import com.leongandroid.wanandroidsdk.login.bean.UserInfoBean;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class LogoutEvent extends BaseEvent<String>{
    public LogoutEvent(@Nullable String uuid) {
        super(uuid);
    }

    public LogoutEvent(@Nullable String uuid, @Nullable String string) {
        super(uuid, string);
    }
}
