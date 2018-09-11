package com.hx.http;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by hexiao on 2018/8/7.
 */

public class Client {

    private static OkHttpClient OK_HTTP_CLIENT;
    /**
     * 日志拦截器
     */
    private static Interceptor mLogInterceptor=chain -> {
        Request request=chain.request();
        long startTime=System.currentTimeMillis();
        Response response=chain.proceed(chain.request());
        long endTime=System.currentTimeMillis();
        long duration=endTime-startTime;
        Log.d("http:",request.toString()+"-"+duration);
        MediaType mediaType=response.body().contentType();
        String content=response.body().string();
        Log.d("http:",content);
        return response.newBuilder().body(ResponseBody.create(mediaType,content))
                .build();
    };

    /**
     * 头部拦截器
     */
    private static Interceptor mHeadInterceptor=chain -> {
        Request.Builder builder=chain.request().newBuilder();
        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.108 Safari/537.36 2345Explorer/8.0.0.13547");
        builder.addHeader("Cache-Control", "max-age=0");
        builder.addHeader("Upgrade-Insecure-Requests", "1");
        builder.addHeader("X-Requested-With", "XMLHttpRequest");
        builder.addHeader("Cookie", "uuid=\"w:f2e0e469165542f8a3960f67cb354026\"; __tasessionId=4p6q77g6q1479458262778; csrftoken=7de2dd812d513441f85cf8272f015ce5; tt_webid=36385357187");
        return chain.proceed(builder.build());
    };
    /**
     * 缓存拦截器
     */
   /* private static Interceptor mCacheInterceptor=chain -> {
        CacheControl.Builder builder=new CacheControl.Builder();
        builder.maxAge(0,TimeUnit.SECONDS);
        builder.maxStale(365,TimeUnit.DAYS);
        CacheControl cacheControl=builder.build();
        Request request=chain.request();
        if (NetWorkUtil.isNetWorkAvailable(App.getContext()))

    };*/

    public static OkHttpClient get(){
        if (OK_HTTP_CLIENT==null){
            synchronized (Client.class){
                if (OK_HTTP_CLIENT==null){
                    OK_HTTP_CLIENT=new OkHttpClient.Builder()
                            .addInterceptor(mLogInterceptor)
                            .addInterceptor(mHeadInterceptor)
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .readTimeout(30,TimeUnit.SECONDS)
                            .writeTimeout(30,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return OK_HTTP_CLIENT;
    }

}
