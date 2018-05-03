package com.leongandroid.leongwanandroid.app;

import android.app.Application;

import com.leongandroid.wanandroidsdk.WanAndroid;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class LeongWanAndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WanAndroid.init(getApplicationContext());
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
