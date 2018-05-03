package com.leongandroid.wanandroidsdk.base.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.leongandroid.wanandroidsdk.base.cookie.CookiesManager;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class BaseImpl<Service> {
    public static final String BASE_URL = "http://www.wanandroid.com/";
    private static Retrofit mRetrofit;
    protected Service mService;

    public BaseImpl(@NonNull Context context) {
        initRetrofit(context);
        this.mService = mRetrofit.create(getServiceClass());;
    }
    private void initRetrofit(Context context) {
        if (null != mRetrofit) {
            return;
        }
        // 设置 Log 拦截器，可以用于以后处理一些异常情况
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)                // 设置拦截器
                .retryOnConnectionFailure(true)             // 是否重试
                .connectTimeout(5, TimeUnit.SECONDS)        // 连接超时事件
                .readTimeout(5, TimeUnit.SECONDS)           // 读取超时时间
                .cookieJar(new CookiesManager(context))                     //设置cookie，持久化
                .build();

        // 配置 Retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)                         // 设置 base url
                .client(client)                                     // 设置 client
                .addConverterFactory(GsonConverterFactory.create()) // 设置 Json 转换工具
                .build();
    }

    private Class<Service> getServiceClass() {
        return (Class<Service>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
