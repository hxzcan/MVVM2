package com.hx.mvvm.ui.contract;

import com.hx.mvvm.api.HttpCallBack;
import com.hx.mvvm.pojo.User;

/**
 * Created by hexiao on 2018/9/4.
 */

public class LoginContract {

    public interface ILoginView{
        void login(boolean isSuccess,String msg);
    }

    public interface ILoginPresenter{
        void login(String name,String password);
    }

    public interface ILoginModel{
       void login(String userName, String password, HttpCallBack<User> callBack);
    }

}
