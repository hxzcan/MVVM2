package com.hx.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by hexiao on 2018/8/7.
 */

public class NetWorkUtil {
    public static boolean isNetWorkAvailable(Context context){
      /*  ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isAvailable();
        }else {
            return false;
        }*/
      return false;
    }

}
