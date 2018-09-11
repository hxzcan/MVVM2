package com.hx.mvvm.api;

/**
 * Created by hexiao on 2018/9/4.
 */

public interface HttpCallBack<T> {

    void onSuccess(T data);

    void onFailed(String msg);
}
