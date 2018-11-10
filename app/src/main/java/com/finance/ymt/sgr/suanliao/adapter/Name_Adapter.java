package com.finance.ymt.sgr.suanliao.adapter;


import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.finance.ymt.sgr.suanliao.R;
import com.finance.ymt.sgr.suanliao.model.bean.Customer;


/**
 * Created by Administrator on 2017/8/24.
 */


public class Name_Adapter extends BaseQuickAdapter<Customer,BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener,BaseQuickAdapter.OnItemClickListener{
    public Name_Adapter() {
        super(R.layout.pop_item_list, null);
    }
    @Override
    protected void convert(BaseViewHolder baseViewHolder, Customer personItem) {

        baseViewHolder.setText(R.id.shijin_item_text_content, personItem.getName());


    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}