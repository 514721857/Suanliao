package com.finance.ymt.sgr.suanliao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.finance.ymt.sgr.suanliao.R;


/**
 * Created by 沈国荣 on 2018/1/22.
 */

public class EnglishText extends RelativeLayout {

    private TextView text_china,text_english;
    private String china_text,english_text;

    public EnglishText(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.english_text,this,true);
        text_china= (TextView) findViewById(R.id.text_china);
        text_english= (TextView) findViewById(R.id.text_english);
    }

    public EnglishText(Context context, AttributeSet attrs) {
        super(context, attrs);
        //
        ////加载视图的布局
        LayoutInflater.from(context).inflate(R.layout.english_text,this,true);
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.EnglishText);
        if (TextUtils.isEmpty(china_text)){
            china_text=a.getString(R.styleable.EnglishText_ctext);
        }
        if (TextUtils.isEmpty(english_text)){
            english_text=a.getString(R.styleable.EnglishText_etext);
        }
        a.recycle();
    }

    /**
     * 此方法会在所有的控件都从xml文件中加载完成后调用
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //获取子控件
        text_china= (TextView) findViewById(R.id.text_china);
        text_english= (TextView) findViewById(R.id.text_english);

        text_china.setText(china_text);
        text_english.setText(english_text);


    }
    public void setTextcolor(int color) {
        if (text_china!=null&&text_english!=null){
            text_china.setTextColor(color);
            text_english.setTextColor(color);
        }

    }

    public void setChinaName(String text) {
        if (text_china!=null){
            text_china.setText(text);
        }
        china_text = text;
    }
    public void setEnglishName(String text) {
        if (text_english!=null){
            text_english.setText(text);
        }
        english_text = text;
    }

}