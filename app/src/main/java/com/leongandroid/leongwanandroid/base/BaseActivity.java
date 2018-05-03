package com.leongandroid.leongwanandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leongandroid.wanandroidsdk.WanAndroid;


public abstract class BaseActivity extends AppCompatActivity {
    protected WanAndroid mWanAndroid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mWanAndroid = WanAndroid.getInstance();
        initDatas();
        initViews();
    }


    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化数据，调用位置在 initViews 之前
     */
    protected void initDatas() {
    }

    /**
     * 初始化 View， 调用位置在 initDatas 之后
     */
    protected abstract void initViews();

}
