package com.finance.ymt.sgr.suanliao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.finance.ymt.sgr.suanliao.R;


/**
 * Created by 沈国荣 on 2018/1/22.
 */

public class ItemWithEditWithEdit extends RelativeLayout {

    private TextView text_title,text_unit;
    private EditText edit_input_number,edit_input_type;
    private String string_text_title,string_unit,string_result;

    public ItemWithEditWithEdit(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_with_edit_edit,this,true);
        text_title= (TextView) findViewById(R.id.text_title);
        text_unit= (TextView) findViewById(R.id.text_unit);

        edit_input_number=(EditText)findViewById(R.id.edit_input_number);
        edit_input_type=(EditText)findViewById(R.id.edit_input_type);

    }

    public ItemWithEditWithEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        //
        ////加载视图的布局
        LayoutInflater.from(context).inflate(R.layout.item_with_edit_edit,this,true);
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.NoItem);
        if (TextUtils.isEmpty(string_text_title)){
            string_text_title=a.getString(R.styleable.NoItem_title);
        }
        if (TextUtils.isEmpty(string_unit)){
            string_unit=a.getString(R.styleable.NoItem_unit);
        }
        if (TextUtils.isEmpty(string_result)){
            string_result=a.getString(R.styleable.NoItem_result);
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

        edit_input_number=(EditText)findViewById(R.id.edit_input_number);
        edit_input_type=(EditText)findViewById(R.id.edit_input_type);
        text_title.setText(string_text_title);
        text_unit.setText(string_unit);


    }
    public void setTextcolor(int color) {
     /*   if (text_china!=null&&text_english!=null){
            text_china.setTextColor(color);
            text_english.setTextColor(color);
        }*/

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
    public EditText getEdit_input_number(){
        if(edit_input_number!=null)
            return edit_input_number;
        return null;
    }

}