
package com.hx.mvvm.ui.presenter;
import com.hx.mvvm.api.HttpCallBack;
import com.hx.mvvm.pojo.User;
import com.hx.mvvm.ui.contract.LoginContract;
import com.hx.mvvm.ui.model.LoginModel;

/**
 * Created by hexiao on 2018/9/4.
 */

public class LoginPresenter implements LoginContract.ILoginPresenter {

    private LoginContract.ILoginModel loginModel;
    private LoginContract.ILoginView loginView;

    public LoginPresenter( LoginContract.ILoginView loginView){
        loginModel=new LoginModel();
        this.loginView=loginView;
    }

    @Override
    public void login(String name,String password) {

        loginModel.login(name, password, new HttpCallBack<User>() {
            @Override
            public void onSuccess(User data) {
               if (data!=null){
                   loginView.login(true,"成功");
               }else {
                   loginView.login(false,"");
               }
            }

            @Override
            public void onFailed(String msg) {
                loginView.login(false,msg);
            }
        });

    }

}
