package com.hx.mvvm.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hexiao on 2018/9/4.
 */

public class ToastUtil {

    private static Toast toast;

    public static void toastShort(Context context,String msg){
        if (toast==null){
            toast=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }
    public static void toastShort(Context context,Integer resId){
        if (toast==null){
            toast=Toast.makeText(context,resId,Toast.LENGTH_SHORT);
        }else {
            toast.setText(resId);
        }
        toast.show();
    }

    public static void toastLong(Context context,String msg){
        if (toast==null){
            toast=Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }

    public static void toastLong(Context context,Integer resId){
        if (toast==null){
            toast=Toast.makeText(context,resId,Toast.LENGTH_LONG);
        }else {
            toast.setText(resId);
        }
        toast.show();
    }
}
