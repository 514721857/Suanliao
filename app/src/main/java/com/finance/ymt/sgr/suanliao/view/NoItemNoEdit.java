package com.finance.ymt.sgr.suanliao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.finance.ymt.sgr.suanliao.R;


/**
 * Created by 沈国荣 on 2018/1/22.
 */

public class NoItemNoEdit extends RelativeLayout {

    private TextView text_title,text_unit,edit_input_number,text_result;
    private String string_text_title,string_unit;

    public NoItemNoEdit(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_no_edit,this,true);
        text_title= (TextView) findViewById(R.id.text_title);
        text_unit= (TextView) findViewById(R.id.text_unit);
        text_result= (TextView) findViewById(R.id.text_result);

        edit_input_number=(TextView)findViewById(R.id.edit_input_number);
    }

    public NoItemNoEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        //
        ////加载视图的布局
        LayoutInflater.from(context).inflate(R.layout.item_no_edit,this,true);
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.NoItem);
        if (TextUtils.isEmpty(string_text_title)){
            string_text_title=a.getString(R.styleable.NoItem_title);
        }
        if (TextUtils.isEmpty(string_unit)){
            string_unit=a.getString(R.styleable.NoItem_unit);
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
        text_title= (TextView) findViewById(R.id.text_title);
        text_unit= (TextView) findViewById(R.id.text_unit);
        edit_input_number=(TextView)findViewById(R.id.edit_input_number);
        text_result= (TextView) findViewById(R.id.text_result);
        text_title.setText(string_text_title);
        text_unit.setText(string_unit);


    }




    public void setTextcolor(int color) {
     /*   if (text_china!=null&&text_english!=null){
            text_china.setTextColor(color);
            text_english.setTextColor(color);
        }*/

    }

    public void setResult(String text) {
        if (edit_input_number!=null){
            edit_input_number.setText(text);
        }

    }


    public void setResultGone() {
        if (text_result!=null){
            text_result.setVisibility(View.GONE);
        }

    }

    public void setTitle(String text) {
        if (text_title!=null){
            text_title.setText(text);
        }
        string_text_title = text;
    }
    public void setUnit(String text) {
        if (text_unit!=null){
            text_unit.setText(text);
        }
        string_unit = text;
    }

}