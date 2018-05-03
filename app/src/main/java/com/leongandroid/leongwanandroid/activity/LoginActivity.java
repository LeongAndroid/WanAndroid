package com.leongandroid.leongwanandroid.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leongandroid.leongwanandroid.R;
import com.leongandroid.leongwanandroid.app.LeongWanAndroidApplication;
import com.leongandroid.leongwanandroid.base.BaseActivity;
import com.leongandroid.wanandroidsdk.login.bean.LoginBean;
import com.leongandroid.wanandroidsdk.login.event.LoginEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by LeongAndroid on 2018/5/3.
 */

public class LoginActivity extends BaseActivity {
    private EditText mUserName;
    private EditText mPassWd;
    private Button mLoginButton;
    @Override
    protected int getLayoutId() {
        return R.layout.login_layout;
    }

    @Override
    protected void initViews() {
        mUserName = (EditText)this.findViewById(R.id.user_name_text);
        mPassWd = (EditText)this.findViewById(R.id.passwd_text);
        mLoginButton = (Button)this.findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mUserName.getText().toString();
                String pwd = mPassWd.getText().toString();
                mWanAndroid.login(name, pwd);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogin(LoginEvent event) {
        LoginBean mBean = event.getBean();
        if (mBean == null) {
            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
        }else {
            ((LeongWanAndroidApplication)getApplication()).getDataCache().saveData("Login", mBean);
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
            finish();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
