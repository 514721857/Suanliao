package com.finance.ymt.sgr.suanliao.adapter;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.finance.ymt.sgr.suanliao.R;
import com.finance.ymt.sgr.suanliao.model.bean.Customer;
import com.finance.ymt.sgr.suanliao.model.operate.CustomerOperate;


/**
 * Created by Administrator on 2017/8/24.
 */


public class Slb_my_Adapter extends BaseItemDraggableAdapter<Customer,BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener,BaseQuickAdapter.OnItemClickListener{
    Context context;
    public Slb_my_Adapter(Context s) {
        super(R.layout.customer_item_list, null);
        context=s;
    }
    @Override
    protected void convert(BaseViewHolder baseViewHolder, final Customer personItem) {

        baseViewHolder.setText(R.id.customer_item_name, personItem.getName());
        baseViewHolder.setText(R.id.customer_item_phone, personItem.getPhone());
        baseViewHolder.setText(R.id.customer_item_address, personItem.getAddress());
        baseViewHolder.setText(R.id.customer_item_tip, personItem.getTip());

        EditText  customer_item_name=baseViewHolder.getView(R.id.customer_item_name);
        EditText  customer_item_phone=baseViewHolder.getView(R.id.customer_item_phone);
        EditText  customer_item_address=baseViewHolder.getView(R.id.customer_item_address);
        EditText  customer_item_tip=baseViewHolder.getView(R.id.customer_item_tip);
        customer_item_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personItem.setName(s.toString());
                CustomerOperate.updateData(context,personItem);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        customer_item_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personItem.setPhone(s.toString());
                CustomerOperate.updateData(context,personItem);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        customer_item_address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personItem.setAddress(s.toString());
                CustomerOperate.updateData(context,personItem);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        customer_item_tip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personItem.setTip(s.toString());
                CustomerOperate.updateData(context,personItem);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}