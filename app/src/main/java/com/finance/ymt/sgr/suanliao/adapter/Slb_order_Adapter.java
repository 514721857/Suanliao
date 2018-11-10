package com.finance.ymt.sgr.suanliao.adapter;


import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.finance.ymt.sgr.suanliao.R;
import com.finance.ymt.sgr.suanliao.model.bean.SuanLiao;


/**
 * Created by Administrator on 2017/8/24.
 */


public class Slb_order_Adapter extends BaseQuickAdapter<SuanLiao,BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener,BaseQuickAdapter.OnItemClickListener{
    public Slb_order_Adapter() {
        super(R.layout.slb_order_item_list, null);
    }
    @Override
    protected void convert(BaseViewHolder baseViewHolder, SuanLiao personItem) {

        baseViewHolder.setText(R.id.order_item_title, personItem.getTitle());
        baseViewHolder.setText(R.id.order_item_tip, personItem.getName());


    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}