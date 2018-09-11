package com.hx.mvvm.api;


import com.hx.http.BaseResult;
import com.hx.mvvm.pojo.User;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hexiao on 2018/8/7.
 * 接口
 */

public interface Api {

    /**
     * 用户登陆
     * @param account
     * @param password
     * @return
     */
    @POST("user/login.do")
    Observable<BaseResult<User>> login(@Query("account") String account, @Query("password") String password);

}
