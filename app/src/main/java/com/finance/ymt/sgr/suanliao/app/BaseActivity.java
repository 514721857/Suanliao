package com.finance.ymt.sgr.suanliao.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;



import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity基类
 * Created by geyifeng on 2017/5/9.AppCompatActivity
 */

public abstract class BaseActivity  extends Activity {


    private Unbinder unbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ScreenAdapt.setCustomDensity(this, MyApplication.getApplication());
        setContentView(setLayoutId());
        unbinder = ButterKnife.bind(this);


        //绑定控件
    /*
     //初始化沉浸式
        if (isImmersionBarEnabled())
            initImmersionBar();*/

        initView();

        //初始化数据
        initData();
        //view与数据绑定


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
      /*  if (mImmersionBar != null)
            mImmersionBar.destroy();  //在BaseActivity里销毁
    }*/
    }
    protected abstract int setLayoutId();





    protected void initData() {
    }

    protected void initView() {
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    private  String getRunningActivityName(){
        return getComponentName().getClassName();
    }

}
