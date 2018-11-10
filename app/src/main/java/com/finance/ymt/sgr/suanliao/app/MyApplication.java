package com.finance.ymt.sgr.suanliao.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;


/**
 * Created by toperc on 2018/5/20.
 */

public class MyApplication extends Application {
    private static Context sContext;
    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        sContext = getApplicationContext();

    }
    /**
     * 获取上下文对象
     * @return
     */
    public static Context getContext(){
        return sContext;
    }
    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }

    public static MyApplication getApplication() {
        return instance;
    }

}
