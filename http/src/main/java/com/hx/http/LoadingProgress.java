package com.hx.http;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by hexiao on 2018/8/8.
 */

public class LoadingProgress extends ProgressDialog {

    public LoadingProgress(Context context) {
        super(context);
    }

    public LoadingProgress(Context context, int theme) {
        super(context, theme);

    }


}
