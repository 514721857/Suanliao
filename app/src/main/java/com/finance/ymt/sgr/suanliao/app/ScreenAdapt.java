package com.finance.ymt.sgr.suanliao.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Data：2018/6/21/021-14:02
 * By  沈国荣
 * Description:今日头条适配方案
 */
public class ScreenAdapt {
    private static float sNoncompatDensity;
    private static float sNoncompatScaleDensity;
    public static void setCustomDensity(Activity activity , final Application application){
        final DisplayMetrics appDisplayMertics=application.getResources().getDisplayMetrics();
        if(sNoncompatDensity==0){
            sNoncompatDensity=appDisplayMertics.density;
            sNoncompatScaleDensity=appDisplayMertics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if(newConfig!=null&&newConfig.fontScale>0){
                        sNoncompatScaleDensity=application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }


        getMinWith(activity);

        //平板和手机适配，6.9属于平板 最小宽度 手机420dp，平板800dp
//        System.out.println("屏幕尺寸"+getScreenInch(activity));
//        appDisplayMertics.heightPixels

        final  float targetDensity=  getSmallestScreenWidth(activity)>=600?(float)(Math.round(appDisplayMertics.heightPixels/800.00f*100))/100:(float)(Math.round(appDisplayMertics.heightPixels/420.00f*100))/100;
//        final  float targetDensity=  getMinWith(activity)>=600?(float)(Math.round(appDisplayMertics.heightPixels/800.00f*100))/100:(float)(Math.round(appDisplayMertics.heightPixels/420.00f*100))/100;
        //要保存两位小数 才比较精确
        final  float targetScaleDensity=targetDensity*(sNoncompatScaleDensity/sNoncompatDensity);
        final int targetDensityDpi=(int)(160*targetDensity);

        appDisplayMertics.density=targetDensity;
        appDisplayMertics.scaledDensity=targetScaleDensity;
        appDisplayMertics.densityDpi=targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics=activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density=targetDensity;
        activityDisplayMetrics.scaledDensity=targetScaleDensity;
        activityDisplayMetrics.densityDpi=targetDensityDpi;

    }


    private static int getSmallestScreenWidth(Activity activity){
        Configuration config = activity.getResources().getConfiguration();

        return config.smallestScreenWidthDp;

    }



    private static int  getMinWith(Activity activity) {
        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        int screenWidth = (int) (width / density);  // 屏幕宽度(dp)
        int screenHeight = (int) (height / density);// 屏幕高度(dp)
        return  screenHeight>screenWidth?screenWidth:screenHeight;
    }


    private static double mInch = 0;
    /**
     * 获取屏幕尺寸
     * @param context
     * @return
     */
    public static double getScreenInch(Activity context) {
        if (mInch != 0.0d) {
            return mInch;
        }

        try {
            int realWidth = 0, realHeight = 0;
            Display display = context.getWindowManager().getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                Point size = new Point();
                display.getRealSize(size);
                realWidth = size.x;
                realHeight = size.y;
            } else if (android.os.Build.VERSION.SDK_INT < 17
                    && android.os.Build.VERSION.SDK_INT >= 14) {
                Method mGetRawH = Display.class.getMethod("getRawHeight");
                Method mGetRawW = Display.class.getMethod("getRawWidth");
                realWidth = (Integer) mGetRawW.invoke(display);
                realHeight = (Integer) mGetRawH.invoke(display);
            } else {
                realWidth = metrics.widthPixels;
                realHeight = metrics.heightPixels;
            }

            mInch =formatDouble(Math.sqrt((realWidth/metrics.xdpi) * (realWidth /metrics.xdpi) + (realHeight/metrics.ydpi) * (realHeight / metrics.ydpi)),1);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return mInch;
    }
    /**
     * Double类型保留指定位数的小数，返回double类型（四舍五入）
     * newScale 为指定的位数
     */
    private static double formatDouble(double d,int newScale) {
        BigDecimal bd = new BigDecimal(d);
        return bd.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


}
