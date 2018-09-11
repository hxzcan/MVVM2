package com.hx.mvvm.ui.model;

import com.hx.http.ApiConstant;
import com.hx.http.BaseResult;
import com.hx.http.ProgressSubscriber;
import com.hx.http.Retrofits;
import com.hx.mvvm.api.Api;
import com.hx.mvvm.api.HttpCallBack;
import com.hx.mvvm.pojo.User;
import com.hx.mvvm.ui.contract.LoginContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hexiao on 2018/9/4.
 */

public class LoginModel implements LoginContract.ILoginModel {


    @Override
    public void login(String userName, String password, HttpCallBack<User> callBack) {
        Retrofits.get(Api.class, ApiConstant.BASE_URL)
                .login(userName, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressSubscriber<BaseResult<User>>() {
                    @Override
                    public void _onNext(BaseResult<User> userBaseResult) {
                        callBack.onSuccess(userBaseResult.getData());
                    }

                    @Override
                    public void _onError(String error) {
                        callBack.onFailed(error);
                    }

                    @Override
                    public void _onComplete() {

                    }
                });
    }
}
