package com.hx.mvvm.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hx.http.ApiConstant;
import com.hx.http.BaseResult;
import com.hx.http.ProgressSubscriber;
import com.hx.http.Retrofits;
import com.hx.mvvm.R;
import com.hx.mvvm.api.Api;
import com.hx.mvvm.pojo.User;
import com.hx.mvvm.ui.contract.LoginContract;
import com.hx.mvvm.ui.presenter.LoginPresenter;
import com.hx.mvvm.utils.ToastUtil;

import java.lang.ref.WeakReference;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hexiao on 2018/8/7.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.ILoginView{

    private LoginContract.ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter=new LoginPresenter(this);
        loginPresenter.login("developer","111111");
    }

    @Override
    public void login(boolean isSuccess, String msg) {
        ToastUtil.toastLong(this,msg);
    }

    private static class MyHandler extends Handler{

        private WeakReference<Activity> mActivity;

        public MyHandler(Activity activity){
            mActivity=new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mActivity.get()==null){
                return;
            }
            switch (msg.what){

            }
        }

    }



}
