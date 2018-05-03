package com.leongandroid.leongwanandroid.app;

import android.app.Application;

import com.leongandroid.leongwanandroid.cache.DataCache;
import com.leongandroid.wanandroidsdk.WanAndroid;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class LeongWanAndroidApplication extends Application {

    private DataCache mDataCache;
    @Override
    public void onCreate() {
        super.onCreate();
        mDataCache = new DataCache(getApplicationContext());
        WanAndroid.init(getApplicationContext());
    }

    public DataCache getDataCache() {
        return mDataCache;
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
