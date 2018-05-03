package com.leongandroid.wanandroidsdk.login.api;


import com.leongandroid.wanandroidsdk.login.bean.LoginBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public interface LoginService {
    @POST("user/login")
    @FormUrlEncoded
    Call<LoginBean> login(@Field("username") String username, @Field("password") String password);

}
