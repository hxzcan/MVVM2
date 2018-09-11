package com.hx.http;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hexiao on 2018/8/7.
 */

public class Retrofits {

    private static Retrofit RETROFIT=null;
    private static Retrofit get(String baseUrl){
        if (RETROFIT==null){
            synchronized (Retrofits.class){
                if (RETROFIT==null){
                    RETROFIT=new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .client(Client.get())
                            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return RETROFIT;
    }

    public static <T> T get(Class<T> clazz,String baseUrl){
        return get(baseUrl).create(clazz);
    }

}
