package com.finance.ymt.sgr.suanliao;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.finance.ymt.sgr.suanliao.adapter.Name_Adapter;
import com.finance.ymt.sgr.suanliao.adapter.Pop_Adapter;
import com.finance.ymt.sgr.suanliao.adapter.Slb_my_Adapter;
import com.finance.ymt.sgr.suanliao.adapter.Slb_order_Adapter;
import com.finance.ymt.sgr.suanliao.app.BaseActivity;
import com.finance.ymt.sgr.suanliao.model.TimeUtil;
import com.finance.ymt.sgr.suanliao.model.bean.Customer;
import com.finance.ymt.sgr.suanliao.model.bean.SuanLiao;
import com.finance.ymt.sgr.suanliao.model.operate.CustomerOperate;
import com.finance.ymt.sgr.suanliao.model.operate.SuanLiaoOperate;
import com.finance.ymt.sgr.suanliao.view.EnglishText;
import com.finance.ymt.sgr.suanliao.view.ItemWithEdit;
import com.finance.ymt.sgr.suanliao.view.ItemWithEditWithEdit;
import com.finance.ymt.sgr.suanliao.view.ItemWithText;
import com.finance.ymt.sgr.suanliao.view.NoItem;
import com.finance.ymt.sgr.suanliao.view.NoItemNoEdit;
import com.finance.ymt.sgr.suanliao.view.TextTipDialog;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener,BaseQuickAdapter.OnItemLongClickListener{
    @BindView(R.id.top_view_title)
    TextView top_view_title;


    @BindView(R.id.slb_sl)
    EnglishText slb_sl;

    @BindView(R.id.slb_order)
    EnglishText slb_order;

    @BindView(R.id.slb_my)
    EnglishText slb_my;

    @BindView(R.id.slb_slb_content)
    View slb_slb_content;

    @BindView(R.id.slb_order_content)
    View slb_order_content;

    @BindView(R.id.slb_my_content)
    View slb_my_content;

    @BindView(R.id.my_order_add)
    Button my_order_add;




    String[] calculating={"罗马杆组","配布组","帘头组","钩式组","配件组","罗马帘组","百叶帘组","工程帘组"};
    List<String> popList=new ArrayList<>();
    List<String> popList_Select=new ArrayList<>();
    LinearLayout lin_all=null;
    TextView add;
    NoItem curtain_with,curtain_hight,all_num;
    ItemWithText curtain_beilu,all_bu_discount,all_pj_discount;
    ItemWithEdit curtain_bu_unit,curtain_sha_unit;
    NoItemNoEdit all_money;
    private PopupWindow mPopWindow;//窗口
    private Pop_Adapter mPopAdapter_list;
    private Name_Adapter mName_Adapter;
    private Slb_my_Adapter mSlb_my_Adapter;
    private Slb_order_Adapter mSlb_order_Adapter;


    //开始列输入数值
    private double curtain_width_edit,curtain_hight_edit,curtain_beilu_edit,
            curtain_bu_edit,curtain_sha_edit;

    //罗马杆输入数值
    private double lmg_quan_edit,lmg_gang_edit,lmg_bu_edit;
    //配布输入数值
    private double pb_num_edit,pb_unit_edit;


    //帘头输入数值
    private double lt_width_edit,lt_unit_edit,lt_guidao_edit,lt_guidaounit_edit
            ,lt_hua_edit,lt_huaunit_edit,lt_mooshu_edit,lt_moshuunit_edit,lt_jiagong_edit,lt_jiagongunit_edit;
    //钩式输入数值
    private double gs_unit_edit,gs_gang_edit,gs_bu_edit;

    //配件输入数值
    private double pj_gqnum_edit,pj_gqunit_edit,pj_hua_edit,
            pj_bengdai_edit,pj_qianggou_edit,pj_buliao_edit,pj_sha_edit;

    //罗马帘输入数值
    private double lml_width_edit,lml_height_edit,lml_unit_edit;

    //百叶帘输入数值
    private double by_width_edit,by_height_edit,by_unit_edit;

    //工程输入数值
    private double gc_width_edit,gc_height_edit,gc_unit_edit;

    //最后输入数值
    private double all_num_edit,all_bu_discount_edit,all_pj_discount_edit,
            all_pj_discount_result,all_bu_discount_result;


    //罗马杆组件
    private ItemWithEdit lmg_quan,lmg_gang,lmg_bu;
    View zu_lmg;

    //罗马帘组件
    View zu_lml;
    NoItem lml_width;
    ItemWithText lml_height;
    ItemWithEdit lml_unit;

    //工程组件
    View zu_gc;
    NoItem gc_width;
    ItemWithText gc_height;
    ItemWithEdit gc_unit;

    //帘头组件
    View zu_lt;
    ItemWithEditWithEdit lt_buliao,lt_guidao,lt_hua,lt_moshu,lt_jiagongunit;
    ItemWithText lt_unit,lt_guidaounit,lt_huaunit,lt_moshuunit,lt_jiagong;

    //配布组件
    View zu_pu;
    ItemWithEditWithEdit pb_num;
    ItemWithText pb_unit;
    //钩式组件
    View zu_gs;
    ItemWithEdit gs_bu,gs_unit,gs_gui;

    //配件组件
    View zu_pj;
    ItemWithEditWithEdit pj_guaqiu,pj_bengdai,pj_qianggou;
    ItemWithText pj_guaqiu_unit,pj_sha;
    ItemWithEdit pj_huaunit,pj_bu;

    //百叶帘组件
    View zu_by;
    NoItem by_width;
    ItemWithText by_hight;
    ItemWithEdit by_unit;


    EditText time_select;

    @BindView(R.id.slb_name)
    TextView slb_name;

    @BindView(R.id.slb_title)
    EditText slb_title;


    @BindView(R.id.slb_list_order)
    RecyclerView slb_list_order;

    @BindView(R.id.slb_list_my)
    RecyclerView slb_list_my;

    @BindView(R.id.customer_name)
    EditText customer_name;

    @BindView(R.id.customer_phone)
    EditText customer_phone;

    @BindView(R.id.customer_address)
    EditText customer_address;

    @BindView(R.id.customer_tip)
    EditText customer_tip;

    boolean isSave=false;

    @BindView(R.id.rel_my_one)
    RelativeLayout rel_my_one;





    //显示一条算料的数据
    private void setShowSuanLiao(SuanLiao suanLiao){


        if(isT(suanLiao.getLmg_bu_edit())||isT(suanLiao.getLmg_gang_edit()) ||isT(suanLiao.getLmg_quan_edit())){
            addLmg();
            popList.remove(calculating[0]);
            if(isT(suanLiao.getLmg_bu_edit())){
                lmg_bu_edit=suanLiao.getLmg_bu_edit();
                lmg_bu.getEdit_input_number().setText(lmg_bu_edit+"");
            }

            if(isT(suanLiao.getLmg_quan_edit())){
                lmg_quan_edit=suanLiao.getLmg_quan_edit();
                lmg_quan.getEdit_input_number().setText(lmg_quan_edit+"");
            }

            if(isT(suanLiao.getLmg_gang_edit())){
                lmg_gang_edit=suanLiao.getLmg_gang_edit();
                lmg_gang.getEdit_input_number().setText(lmg_gang_edit+"");
            }
        }

        if(isT(suanLiao.getLml_height_edit())||isT(suanLiao.getLml_unit_edit())||isT(suanLiao.getLml_width_edit())){

            addLml();
            popList.remove(calculating[5]);
            if(isT(suanLiao.getLml_height_edit())){
                lml_height_edit=suanLiao.getLml_height_edit();
                lml_height.getEdit_input_number().setText(lml_height_edit+"");
            }
            if(isT(suanLiao.getLml_width_edit())){
                lml_width_edit=suanLiao.getLml_width_edit();
                lml_width.getEdit_input_number().setText(lml_width_edit+"");
            }
            if(isT(suanLiao.getLml_width_edit())){
                lml_unit_edit=suanLiao.getLml_width_edit();
                lml_unit.getEdit_input_number().setText(lml_unit_edit+"");
            }

        }



        if(isT(suanLiao.getGc_height_edit())||isT(suanLiao.getGc_width_edit())||isT(suanLiao.getGc_unit_edit())){
            addGc();
            popList.remove(calculating[7]);
            if(isT(suanLiao.getGc_height_edit())){
                gc_height_edit=suanLiao.getGc_height_edit();
                gc_height.getEdit_input_number().setText(gc_height_edit+"");
            }
            if(isT(suanLiao.getGc_width_edit())){
                gc_width_edit =suanLiao.getGc_width_edit();
                gc_width.getEdit_input_number().setText(gc_width_edit+"");
            }
            if(isT(suanLiao.getGc_unit_edit())){
                gc_unit_edit=suanLiao.getGc_unit_edit();
                gc_unit.getEdit_input_number().setText(gc_unit_edit+"");
            }
        }


        if(isT(suanLiao.getLt_guidao_edit())||isT(suanLiao.getLt_guidaounit_edit())||isT(suanLiao.getLt_hua_edit())||isT(suanLiao.getLt_huaunit_edit())||
                isT(suanLiao.getLt_jiagong_edit())||isT(suanLiao.getLt_jiagongunit_edit())||isT(suanLiao.getLt_mooshu_edit())||isT(suanLiao.getLt_moshuunit_edit())||isT(suanLiao.getLt_unit_edit())
                ||isT(suanLiao.getLt_width_edit())){
            addLt();
            popList.remove(calculating[2]);
            if(isT(suanLiao.getLt_guidao_edit())){
                lt_guidao_edit=suanLiao.getLt_guidao_edit();
                lt_guidao.getEdit_input_number().setText(lt_guidao_edit+"");

            }
            if(isT(suanLiao.getLt_guidaounit_edit())){
                lt_guidaounit_edit=suanLiao.getLt_guidaounit_edit();
                lt_guidaounit.getEdit_input_number().setText(lt_guidaounit_edit+"");
            }
            if(isT(suanLiao.getLt_hua_edit())){
                lt_hua_edit=suanLiao.getLt_hua_edit();
                lt_hua.getEdit_input_number().setText(lt_hua_edit+"");
            }
            if(isT(suanLiao.getLt_huaunit_edit())){
                lt_huaunit_edit=suanLiao.getLt_huaunit_edit();
                lt_huaunit.getEdit_input_number().setText(lt_huaunit_edit+"");
            }
            if(isT(suanLiao.getLt_jiagong_edit())){
                lt_jiagong_edit=suanLiao.getLt_jiagong_edit();
                lt_jiagong.getEdit_input_number().setText(lt_jiagong_edit+"");
            }
            if(isT(suanLiao.getLt_jiagongunit_edit())){
                lt_jiagongunit_edit=suanLiao.getLt_jiagongunit_edit();
                lt_jiagongunit.getEdit_input_number().setText(lt_jiagongunit_edit+"");

            }
            if(isT(suanLiao.getLt_mooshu_edit())){
                lt_mooshu_edit=suanLiao.getLt_mooshu_edit();
                lt_moshu.getEdit_input_number().setText(lt_mooshu_edit+"");

            }
            if(isT(suanLiao.getLt_moshuunit_edit())){
                lt_moshuunit_edit=suanLiao.getLt_moshuunit_edit();
                lt_moshuunit.getEdit_input_number().setText(lt_moshuunit_edit+"");
            }
            if(isT(suanLiao.getLt_unit_edit())){
                lt_unit_edit=suanLiao.getLt_unit_edit();
                lt_unit.getEdit_input_number().setText(lt_unit_edit+"");
            }
            if(isT(suanLiao.getLt_width_edit())){
                lt_width_edit=suanLiao.getLt_width_edit();
                lt_buliao.getEdit_input_number().setText(lt_width_edit+"");
            }
        }
        if(isT(suanLiao.getPb_num_edit())||isT(suanLiao.getPb_unit_edit())){
            addPb();
            popList.remove(calculating[1]);
            if(isT(suanLiao.getPb_num_edit())){
                pb_num_edit=suanLiao.getPb_num_edit();
                pb_num.getEdit_input_number().setText(pb_num_edit+"");
            }
            if(isT(suanLiao.getPb_unit_edit())){
                pb_unit_edit=suanLiao.getPb_unit_edit();
                pb_unit.getEdit_input_number().setText(pb_unit_edit+"");

            }
        }
        if(isT(suanLiao.getGs_bu_edit())||isT(suanLiao.getGs_gang_edit()) ||isT(suanLiao.getGs_unit_edit())){
            addGs();
            popList.remove(calculating[3]);
            if(isT(suanLiao.getGs_bu_edit())){
                gs_bu_edit=suanLiao.getGs_bu_edit();
                gs_bu.getEdit_input_number().setText(gs_bu_edit+"");

            }
            if(isT(suanLiao.getGs_gang_edit())){
                gs_gang_edit=suanLiao.getGs_gang_edit();
                gs_gui.getEdit_input_number().setText(gs_gang_edit+"");
            }
            if(isT(suanLiao.getGs_unit_edit())){
                gs_unit_edit=suanLiao.getGs_unit_edit();
                gs_unit.getEdit_input_number().setText(gs_unit_edit+"");
            }
        }
        if(isT(suanLiao.getPj_bengdai_edit())||isT(suanLiao.getPj_buliao_edit())  || isT(suanLiao.getPj_gqnum_edit()) ||isT(suanLiao.getPj_gqunit_edit())
                ||isT(suanLiao.getPj_hua_edit())||isT(suanLiao.getPj_qianggou_edit()) ||isT(suanLiao.getPj_sha_edit())){

            addPj();
            popList.remove(calculating[4]);
            if(isT(suanLiao.getPj_bengdai_edit())){
                pj_bengdai_edit=suanLiao.getPj_bengdai_edit();
                pj_bengdai.getEdit_input_number().setText(pj_bengdai_edit+"");
            }
            if(isT(suanLiao.getPj_buliao_edit())){
                pj_buliao_edit=suanLiao.getPj_buliao_edit();
                pj_bu.getEdit_input_number().setText(pj_buliao_edit+"");
            }

            if(isT(suanLiao.getPj_gqnum_edit())){
                pj_gqnum_edit=suanLiao.getPj_gqnum_edit();
                pj_guaqiu.getEdit_input_number().setText(pj_gqnum_edit+"");

            }
            if(isT(suanLiao.getPj_gqunit_edit()) ){
                pj_gqunit_edit=suanLiao.getPj_gqunit_edit();
                pj_guaqiu_unit.getEdit_input_number().setText(pj_gqunit_edit+"");
            }
            if(isT(suanLiao.getPj_hua_edit())){
                pj_hua_edit=suanLiao.getPj_hua_edit();
                pj_huaunit.getEdit_input_number().setText(pj_hua_edit+"");
            }
            if(isT(suanLiao.getPj_qianggou_edit()) ){
                pj_qianggou_edit=suanLiao.getPj_qianggou_edit();
                pj_qianggou.getEdit_input_number().setText(pj_qianggou_edit+"");
            }
            if(isT(suanLiao.getPj_sha_edit())){
                pj_sha_edit=suanLiao.getPj_sha_edit();
                pj_sha.getEdit_input_number().setText(pj_sha_edit+"");

            }
        }

        if(isT(suanLiao.getBy_height_edit())||isT(suanLiao.getBy_width_edit())||isT(suanLiao.getBy_unit_edit())){
            addByl();
            popList.remove(calculating[6]);
            if(isT(suanLiao.getBy_height_edit())){
                by_height_edit=suanLiao.getBy_height_edit();
                by_hight.getEdit_input_number().setText(by_height_edit+"");
            }
            if(isT(suanLiao.getBy_width_edit())){
                by_width_edit=suanLiao.getBy_width_edit();
                by_width.getEdit_input_number().setText(by_width_edit+"");
            }
            if(isT(suanLiao.getBy_unit_edit())){
                by_unit_edit=suanLiao.getBy_unit_edit();
                by_unit.getEdit_input_number().setText(by_unit_edit+"");

            }
        }
        if(isT(suanLiao.getCurtain_width_edit())){
            curtain_width_edit=suanLiao.getCurtain_width_edit();
            curtain_with.getEdit_input_number().setText(curtain_width_edit+"");
        }

        if(isT(suanLiao.getCurtain_hight_edit())){
            curtain_hight_edit=suanLiao.getCurtain_hight_edit();
            curtain_hight.getEdit_input_number().setText(curtain_hight_edit+"");
        }
        if(isT(suanLiao.getCurtain_beilu_edit())){
            curtain_beilu_edit=suanLiao.getCurtain_beilu_edit();
            curtain_beilu.getEdit_input_number().setText(curtain_beilu_edit+"");
        }
        if(isT(suanLiao.getCurtain_bu_edit())){
            curtain_bu_edit=suanLiao.getCurtain_bu_edit();
            curtain_bu_unit.getEdit_input_number().setText(curtain_bu_edit+"");
        }
        if(isT(suanLiao.getCurtain_sha_edit())){
            curtain_sha_edit=suanLiao.getCurtain_sha_edit();
            curtain_sha_unit.getEdit_input_number().setText(curtain_sha_edit+"");
        }
        if(isT(suanLiao.getAll_num_edit())){
            all_num_edit=suanLiao.getAll_num_edit();
            all_num.getEdit_input_number().setText(all_num_edit+"");
        }
        if(isT(suanLiao.getAll_bu_discount_edit())){
            all_bu_discount_edit=suanLiao.getAll_bu_discount_edit();
            all_bu_discount.getEdit_input_number().setText(all_bu_discount_edit+"");

        }
        if(isT(suanLiao.getAll_pj_discount_edit())){
            all_pj_discount_edit=suanLiao.getAll_pj_discount_edit();
            all_pj_discount.getEdit_input_number().setText(all_pj_discount_edit+"");
        }
        ChangeCalculating();
    }

    //保存一条算料数据
    private void SaveSuanLiao(){
        SuanLiao suanLiao=new SuanLiao();
        if(zu_lmg!=null){
            suanLiao.setLmg_quan_edit(lmg_quan_edit);
            suanLiao.setLmg_gang_edit(lmg_gang_edit);
            suanLiao.setLmg_bu_edit(lmg_bu_edit);
        }

        if(zu_lml!=null){
            suanLiao.setLml_height_edit(lml_height_edit);
            suanLiao.setLml_unit_edit(lml_unit_edit);
            suanLiao.setLml_width_edit(lml_width_edit);
        }
        if(zu_gc!=null){
            suanLiao.setGc_width_edit(gc_width_edit);
            suanLiao.setGc_height_edit(gc_height_edit);
            suanLiao.setGc_unit_edit(gc_unit_edit);
        }
        if(zu_lt!=null){
            suanLiao.setLt_width_edit(lt_width_edit);
            suanLiao.setLt_unit_edit(lt_unit_edit);
            suanLiao.setLt_guidao_edit(lt_guidao_edit);
            suanLiao.setLt_guidaounit_edit(lt_guidaounit_edit);
            suanLiao.setLt_hua_edit(lt_hua_edit);
            suanLiao.setLt_huaunit_edit(lt_huaunit_edit);
            suanLiao.setLt_mooshu_edit(lt_mooshu_edit);
            suanLiao.setLt_moshuunit_edit(lt_moshuunit_edit);
            suanLiao.setLt_jiagong_edit(lt_jiagong_edit);
            suanLiao.setLt_jiagongunit_edit(lt_jiagongunit_edit);
        }
        if(zu_pu!=null){
            suanLiao.setPb_num_edit(pb_num_edit);
            suanLiao.setPb_unit_edit(pb_unit_edit);
        }
        if(zu_gs!=null){
            suanLiao.setGs_bu_edit(gs_bu_edit);
            suanLiao.setGs_gang_edit(gs_gang_edit);
            suanLiao.setGs_unit_edit(gs_unit_edit);
        }
        if(zu_pj!=null){
            suanLiao.setPj_bengdai_edit(pj_bengdai_edit);
            suanLiao.setPj_buliao_edit(pj_buliao_edit);
            suanLiao.setPj_gqnum_edit(pj_gqnum_edit);
            suanLiao.setPj_gqunit_edit(pj_gqunit_edit);
            suanLiao.setPj_hua_edit(pj_hua_edit);
            suanLiao.setPj_qianggou_edit(pj_qianggou_edit);
            suanLiao.setPj_sha_edit(pj_sha_edit);
        }

        if(zu_by!=null){
            suanLiao.setBy_height_edit(by_height_edit);
            suanLiao.setBy_unit_edit(by_unit_edit);
            suanLiao.setBy_width_edit(by_width_edit);

        }


        suanLiao.setCurtain_width_edit(curtain_width_edit);
        suanLiao.setCurtain_sha_edit(curtain_sha_edit);
        suanLiao.setCurtain_hight_edit(curtain_hight_edit);
        suanLiao.setCurtain_bu_edit(curtain_bu_edit);
        suanLiao.setCurtain_beilu_edit(curtain_beilu_edit);
        suanLiao.setAll_num_edit(all_num_edit);
        suanLiao.setAll_bu_discount_edit(all_bu_discount_edit);
        suanLiao.setAll_pj_discount_edit(all_pj_discount_edit);
        suanLiao.setTitle(slb_title.getText().toString());
        suanLiao.setName(slb_name.getText().toString().equals("选择客户")?"未选择客户":slb_name.getText().toString());
        suanLiao.setData(time_select.getText().toString());

        Toast.makeText(MainActivity.this,"保存成功，请在订单中心查看",Toast.LENGTH_LONG).show();
        SuanLiaoOperate.insertData(this,suanLiao);
        isSave=false;

        //更新数据
        mSlb_order_Adapter.setNewData(SuanLiaoOperate.queryAll(this));


    }

    //清除所有数据
    private void setClearNum() {

        if(zu_lmg!=null){
            lmg_quan.getEdit_input_number().setText("");
            lmg_gang.getEdit_input_number().setText("");
            lmg_bu.getEdit_input_number().setText("");
            lmg_quan_edit=lmg_gang_edit=lmg_bu_edit=0.0;
        }

        if(zu_lml!=null){
            lml_width.getEdit_input_number().setText("");
            lml_height.getEdit_input_number().setText("");
            lml_unit.getEdit_input_number().setText("");
            lml_width_edit=lml_height_edit=lml_unit_edit=0.0;
        }

        if(zu_gc!=null){
            gc_width.getEdit_input_number().setText("");
            gc_height.getEdit_input_number().setText("");
            gc_unit.getEdit_input_number().setText("");
            gc_width_edit=gc_height_edit=gc_unit_edit=0.0;
        }

        if(zu_lt!=null){
            lt_buliao.getEdit_input_number().setText("");
            lt_width_edit=0.0;
            lt_guidao.getEdit_input_number().setText("");
            lt_hua.getEdit_input_number().setText("");
            lt_moshu.getEdit_input_number().setText("");
            lt_jiagongunit.getEdit_input_number().setText("");
            lt_unit.getEdit_input_number().setText("");
            lt_guidaounit.getEdit_input_number().setText("");
            lt_huaunit.getEdit_input_number().setText("");
            lt_moshuunit.getEdit_input_number().setText("");
            lt_jiagong.getEdit_input_number().setText("");
            lt_unit_edit=lt_guidao_edit=lt_guidaounit_edit =lt_hua_edit=lt_huaunit_edit=lt_mooshu_edit
                    =lt_moshuunit_edit=lt_jiagong_edit=lt_jiagongunit_edit=0.0;
        }
        if(zu_pu!=null){
            pb_num.getEdit_input_number().setText("");
            pb_num_edit=0.0;
            pb_unit.getEdit_input_number().setText("");
            pb_unit_edit=0.0;
        }

        if(zu_gs!=null){
            gs_unit.getEdit_input_number().setText("");
            gs_unit_edit=0.0;

            gs_bu.getEdit_input_number().setText("");
            gs_bu_edit=0.0;

            gs_gui.getEdit_input_number().setText("");
            gs_gang_edit=0.0;

        }

        if(zu_pj!=null){
            pj_bu.getEdit_input_number().setText("");
            pj_buliao_edit=0.0;
            pj_huaunit.getEdit_input_number().setText("");
            pj_hua_edit=0.0;
            pj_sha.getEdit_input_number().setText("");
            pj_sha_edit=0.0;
            pj_guaqiu_unit.getEdit_input_number().setText("");
            pj_gqunit_edit=0.0;
            pj_guaqiu.getEdit_input_number().setText("");
            pj_gqnum_edit=0.0;
            pj_bengdai.getEdit_input_number().setText("");
            pj_bengdai_edit=0.0;
            pj_qianggou.getEdit_input_number().setText("");
            pj_qianggou_edit=0.0;
        }

        if(zu_by!=null){
            by_width.getEdit_input_number().setText("");
            by_width_edit=0.0;
            by_hight.getEdit_input_number().setText("");
            by_height_edit=0.0;
            by_unit.getEdit_input_number().setText("");
            by_unit_edit=0.0;
        }


        curtain_with.getEdit_input_number().setText("");
        curtain_width_edit=0.0;

        curtain_hight.getEdit_input_number().setText("");
        curtain_hight_edit=0.0;

        all_num.getEdit_input_number().setText("");
        all_num_edit=0.0;

        curtain_beilu.getEdit_input_number().setText("");
        curtain_beilu_edit=0.0;

        curtain_bu_unit.getEdit_input_number().setText("");
        curtain_bu_edit=0.0;

        curtain_sha_unit.getEdit_input_number().setText("");
        curtain_sha_edit=0.0;

        all_bu_discount.getEdit_input_number().setText("");
        all_bu_discount_edit=0.0;

        all_pj_discount.getEdit_input_number().setText("");
        all_pj_discount_edit=0.0;

        all_pj_discount_result=all_bu_discount_result=0.0;
//        all_money.setResult("0.0");
        ChangeCalculating();

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_slb;
    }


    //判断是否为空  返回true 表示有值
    private boolean isT(Double ist){
        if(ist!=null&&ist!=0.0)
            return  true;

        return false;
    }



    @Override
    protected void initView() {
        super.initView();

        top_view_title.setText(getString(R.string.slb_name));
        initSlView();
        initOrderView();
        initMyView();
        setChoice(1);
    }
    private void initOrderView(){
        LinearLayoutManager manager_order = new LinearLayoutManager(this);
        manager_order.setOrientation(LinearLayoutManager.VERTICAL);
        slb_list_order.setLayoutManager(manager_order);
        mSlb_order_Adapter=new Slb_order_Adapter();

        slb_list_order.setAdapter(mSlb_order_Adapter);
        mSlb_order_Adapter.setNewData(SuanLiaoOperate.queryAll(this));
        mSlb_order_Adapter.setOnItemClickListener(this);
        mSlb_order_Adapter.setOnItemLongClickListener(this);

    }

    private void initMyView(){
        LinearLayoutManager manager_my = new LinearLayoutManager(this);
        manager_my.setOrientation(LinearLayoutManager.VERTICAL);
        slb_list_my.setLayoutManager(manager_my);
        mSlb_my_Adapter=new Slb_my_Adapter(this);

        slb_list_my.setAdapter(mSlb_my_Adapter);
        mSlb_my_Adapter.setNewData(CustomerOperate.queryAll(this));
        mSlb_my_Adapter.setOnItemClickListener(this);
        mSlb_my_Adapter.setOnItemLongClickListener(this);

    }

    //初始化算料控件
    private void initSlView() {

        time_select=(EditText)findViewById(R.id.time_select);
        time_select.setInputType(InputType.TYPE_NULL);


        time_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                TimeUtil.showDatePickerDialog(MainActivity.this,3,time_select,calendar);
            }
        });

        lin_all=(LinearLayout)findViewById(R.id.lin_all);
        add=(TextView)findViewById(R.id.add);

        //添加组
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(popList);
            }
        });

        curtain_with=(NoItem)findViewById(R.id.curtain_with);
        curtain_hight=(NoItem)findViewById(R.id.curtain_hight);
        all_num=(NoItem)findViewById(R.id.all_num);
        curtain_beilu=(ItemWithText)findViewById(R.id.curtain_beilu);
        curtain_bu_unit=(ItemWithEdit)findViewById(R.id.curtain_bu_unit);
        curtain_sha_unit=(ItemWithEdit)findViewById(R.id.curtain_sha_unit);
        all_bu_discount=(ItemWithText)findViewById(R.id.all_bu_discount);
        all_pj_discount=(ItemWithText)findViewById(R.id.all_pj_discount);
        all_money=(NoItemNoEdit)findViewById(R.id.all_money);
        all_money.setResultGone();

        if(all_pj_discount.getEdit_input_number()!=null){
            all_pj_discount.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        all_pj_discount_edit=0.0;
                    }else{
                        all_pj_discount_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(all_bu_discount.getEdit_input_number()!=null){
            all_bu_discount.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        all_bu_discount_edit=0.0;
                    }else{
                        all_bu_discount_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }


        if(curtain_sha_unit.getEdit_input_number()!=null){
            curtain_sha_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        curtain_sha_edit=0.0;
                    }else{
                        curtain_sha_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(curtain_bu_unit.getEdit_input_number()!=null){
            curtain_bu_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        curtain_bu_edit=0.0;
                    }else{
                        curtain_bu_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(curtain_beilu.getEdit_input_number()!=null){
            curtain_beilu.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        curtain_beilu_edit=0.0;
                    }else{
                        curtain_beilu_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }


        if(all_num.getEdit_input_number()!=null){
            all_num.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        all_num_edit=0.0;
                    }else{
                        all_num_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }


        if(curtain_hight.getEdit_input_number()!=null){
            curtain_hight.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        curtain_hight_edit=0.0;
                    }else{
                        curtain_hight_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(curtain_with.getEdit_input_number()!=null){
            curtain_with.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                 ,,,
                    if(i2==0){
                        curtain_width_edit=0.0;
                    }else{
                        curtain_width_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

    @Override
    protected void initData() {
        super.initData();
        for(int i=0;i<calculating.length;i++){
            popList.add(calculating[i]);
        }
    }

    @OnClick({R.id.slb_sl,R.id.slb_order,R.id.slb_my,R.id.top_view_back,R.id.my_order_add,R.id.slb_clear,R.id.slb_save,R.id.slb_name,R.id.my_order_add_one})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.my_order_add_one://保存一条客户

                Customer customer=new Customer();
                customer.setAddress(customer_address.getText().toString());
                customer.setName(customer_name.getText().toString());
                customer.setPhone(customer_phone.getText().toString());
                customer.setTip(customer_tip.getText().toString());
                CustomerOperate.insertData(this,customer);

                mSlb_my_Adapter.setNewData(CustomerOperate.queryAll(this));
                rel_my_one.setVisibility(View.GONE);
                customer_address.setText("");
                customer_name.setText("");
                customer_tip.setText("");
                customer_phone.setText("");
                break;
            case R.id.slb_name://选择客户

                showNamePopupWindow();
                break;

            case R.id.slb_clear://清除
                setClearNum();
                break;

            case R.id.slb_save://保存
                if(!isSave){
                    isSave=true;
                    SaveSuanLiao();
                }
                break;
            case R.id.slb_sl:
                setChoice(1);
                break;
            case R.id.slb_my:
                setChoice(3);
                break;
            case R.id.slb_order:
                setChoice(2);
                break;
            case R.id.my_order_add:
                rel_my_one.setVisibility(View.VISIBLE);
                break;

            case R.id.top_view_back:
                finish();
                break;

        }
    }



    private void setChoice(int position) {
        setClear();
        if(position==1){
            slb_sl.setBackgroundResource(R.mipmap.english_select_bg);
            slb_sl.setTextcolor(ContextCompat.getColor(this,R.color.colorWhite));
            slb_slb_content.setVisibility(View.VISIBLE);

        }else if(position==2){
            slb_order.setBackgroundResource(R.mipmap.english_select_bg);
            slb_order.setTextcolor(ContextCompat.getColor(this,R.color.colorWhite));
            slb_order_content.setVisibility(View.VISIBLE);
        }else if(position==3){
            slb_my.setBackgroundResource(R.mipmap.english_select_bg);
            slb_my.setTextcolor(ContextCompat.getColor(this,R.color.colorWhite));
            slb_my_content.setVisibility(View.VISIBLE);
        }
    }
    //清楚状态
    private void setClear(){
        slb_sl.setBackgroundResource(R.mipmap.english_unselect_bg);
        slb_sl.setTextcolor(ContextCompat.getColor(this,R.color.colorblack));

        slb_order.setBackgroundResource(R.mipmap.english_unselect_bg);
        slb_order.setTextcolor(ContextCompat.getColor(this,R.color.colorblack));

        slb_my.setBackgroundResource(R.mipmap.english_unselect_bg);
        slb_my.setTextcolor(ContextCompat.getColor(this,R.color.colorblack));

        slb_slb_content.setVisibility(View.GONE);
        slb_order_content.setVisibility(View.GONE);
        slb_my_content.setVisibility(View.GONE);

    }


    //弹出选择客户
    private void showNamePopupWindow() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_list_name, null);
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopWindow  .setOutsideTouchable(true);
        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.slb_name_recyclerview);
        TextView add_new =(TextView)contentView.findViewById(R.id.add_new_name) ;
        add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPopWindow!=null){
                    mPopWindow.dismiss();
                }
                setChoice(3);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        mName_Adapter=new Name_Adapter();
        mName_Adapter.setNewData(CustomerOperate.queryAll(this));
        recyclerView.setAdapter(mName_Adapter);
        mName_Adapter.setOnItemClickListener(this);
        mName_Adapter.notifyDataSetChanged();
        mPopWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.CENTER, 0, 0);

    }

    //弹出添加组
    private void showPopupWindow(List<String> data) {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_list, null);
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopWindow  .setOutsideTouchable(true);
        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.soft_pop_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        mPopAdapter_list=new Pop_Adapter();
        mPopAdapter_list.setNewData(data);
        recyclerView.setAdapter(mPopAdapter_list);
        mPopAdapter_list.setOnItemClickListener(this);
        mPopAdapter_list.notifyDataSetChanged();
        mPopWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.CENTER, 0, 0);

    }
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        if(mPopAdapter_list==adapter){
            if(mPopWindow!=null)
                mPopWindow.dismiss();

            String temp_update=   (String) adapter.getData().get(position);
            if(temp_update==null)
                return;


            if(temp_update.equals(calculating[0])){
                addLmg();
                popList.remove(calculating[0]);
            }else if(temp_update.equals(calculating[1])){
                addPb();
                popList.remove(calculating[1]);
            }else if(temp_update.equals(calculating[2])){
                addLt();
                popList.remove(calculating[2]);
            }else if(temp_update.equals(calculating[3])){
                addGs();
                popList.remove(calculating[3]);
            }else if(temp_update.equals(calculating[4])){
                addPj();
                popList.remove(calculating[4]);
            }else if(temp_update.equals(calculating[5])){
                addLml();
                popList.remove(calculating[5]);
            }else if(temp_update.equals(calculating[6])){
                addByl();
                popList.remove(calculating[6]);
            }else if(temp_update.equals(calculating[7])){
                addGc();
                popList.remove(calculating[7]);
            }
        }else if(mSlb_order_Adapter==adapter){
            SuanLiao temp_update=   (SuanLiao) adapter.getData().get(position);
            if(temp_update==null)
                return;
            setChoice(1);
            setClearNum();
            setShowSuanLiao(temp_update);

        }else if(mName_Adapter==adapter){
            if(mPopWindow!=null)
                mPopWindow.dismiss();

            Customer temp_update=   (Customer) adapter.getData().get(position);
            if(temp_update==null)
                return;

            slb_name.setText(temp_update.getName());
        }

    }

    //每次变换需要计算的方法
    private void ChangeCalculating(){
        //        总额：
        Double totalPrice=0.0;

        //开始
        curtain_beilu.setResult(curtain_width_edit*curtain_beilu_edit+"");
        curtain_bu_unit.setResult(curtain_width_edit*curtain_beilu_edit*curtain_bu_edit+"");
        curtain_sha_unit.setResult(curtain_width_edit*curtain_beilu_edit*curtain_sha_edit+"");

        //默认
        totalPrice += curtain_width_edit*curtain_beilu_edit*curtain_bu_edit+curtain_width_edit*curtain_beilu_edit*curtain_sha_edit;

        //组
        if(zu_lmg!=null){
            lmg_quan.setResult(curtain_width_edit*curtain_beilu_edit*6*lmg_quan_edit+"");
            lmg_gang.setResult(curtain_width_edit*lmg_gang_edit+"");
            lmg_bu.setResult(curtain_width_edit*curtain_beilu_edit*lmg_bu_edit+"");
            //罗马杆
            totalPrice += curtain_width_edit*curtain_beilu_edit*6*lmg_quan_edit+curtain_width_edit*lmg_gang_edit+curtain_width_edit*curtain_beilu_edit*lmg_bu_edit;
        }
        if(zu_lml!=null){
            lml_height.setResult(lml_height_edit*lml_width_edit+"");
            lml_unit.setResult(lml_height_edit*lml_width_edit*lml_unit_edit+"");
            //罗马帘
            totalPrice += lml_height_edit*lml_width_edit*lml_unit_edit;
        }
        if(zu_gc!=null){
            gc_height.setResult(gc_height_edit*gc_width_edit+"");
            lml_unit.setResult(gc_height_edit*gc_width_edit*gc_unit_edit+"");
            totalPrice += gc_height_edit*gc_width_edit*gc_unit_edit;
        }
        if(zu_gs!=null){
            gs_unit.setResult(curtain_width_edit*curtain_beilu_edit*6*gs_unit_edit+"");
            gs_gui.setResult(curtain_width_edit*gs_gang_edit+"");
            gs_bu.setResult(curtain_width_edit*curtain_beilu_edit*gs_bu_edit+"");
            totalPrice += curtain_width_edit*curtain_beilu_edit*6*gs_unit_edit+curtain_width_edit*gs_gang_edit+curtain_width_edit*curtain_beilu_edit*gs_bu_edit;
        }
        if(zu_by!=null){
            by_hight.setResult(by_height_edit*by_width_edit+"");
            by_unit.setResult(by_height_edit*by_width_edit*by_unit_edit+"");
            totalPrice += by_height_edit*by_width_edit*by_unit_edit;
        }
        if(zu_pu!=null){
            pb_unit.setResult(pb_num_edit*pb_unit_edit+"");
            totalPrice += pb_num_edit*pb_unit_edit;
        }
        if(zu_pj!=null){
            pj_guaqiu_unit.setResult(2*pj_gqnum_edit*pj_gqunit_edit+"");
            pj_huaunit.setResult(pj_hua_edit*curtain_width_edit*curtain_beilu_edit+"");
            pj_bu.setResult(curtain_width_edit*curtain_beilu_edit*pj_buliao_edit+"");
            pj_sha.setResult(curtain_width_edit*curtain_beilu_edit*pj_sha_edit+"");
            totalPrice += 2*pj_gqnum_edit*pj_gqunit_edit+pj_hua_edit*curtain_width_edit*curtain_beilu_edit+
                    pj_bengdai_edit+pj_qianggou_edit+curtain_width_edit*curtain_beilu_edit*pj_buliao_edit+curtain_width_edit*curtain_beilu_edit*pj_sha_edit;

        }
        if(zu_lt!=null){

            lt_unit.setResult(lt_width_edit*lt_unit_edit+"");
            lt_guidaounit.setResult(lt_guidao_edit*lt_guidaounit_edit+"");
            lt_huaunit.setResult(lt_hua_edit*lt_huaunit_edit+"");
            lt_moshuunit.setResult(lt_mooshu_edit*lt_moshuunit_edit+"");
            lt_jiagong.setResult(curtain_width_edit*lt_jiagong_edit+"");

            totalPrice += lt_width_edit*lt_unit_edit+lt_guidao_edit*lt_guidaounit_edit+lt_hua_edit*lt_huaunit_edit
                    +lt_mooshu_edit*lt_moshuunit_edit+curtain_width_edit*lt_jiagong_edit+lt_jiagongunit_edit;
        }
        //最后
//        布料折扣：
        if(all_bu_discount_edit>0 && all_bu_discount_edit<100) {
            double bu_totalPrice = curtain_width_edit*curtain_beilu_edit*curtain_bu_edit+curtain_width_edit*curtain_beilu_edit*curtain_sha_edit;
            if (all_num_edit>0) {
                bu_totalPrice *= all_num_edit;
            }
            all_bu_discount_result=bu_totalPrice * (1-all_bu_discount_edit/100);

        } else {
            all_bu_discount_result=0.0;

        }
        all_bu_discount.setResult(all_bu_discount_result+"");

        if(all_pj_discount_edit>0 && all_pj_discount_edit<100) {
            double pj_totalPrice = curtain_width_edit*curtain_beilu_edit*6*lmg_quan_edit+curtain_width_edit*lmg_gang_edit*curtain_width_edit*curtain_beilu_edit*lmg_bu_edit;
            if (all_num_edit>0) {
                pj_totalPrice *= all_num_edit;
            }
            all_pj_discount_result=pj_totalPrice * (1-all_pj_discount_edit/100)
            ;
        } else {
            all_pj_discount_result=0.0;


        }
        all_pj_discount.setResult(all_pj_discount_result+"");
        // 折扣
        totalPrice = totalPrice - all_bu_discount_result - all_pj_discount_result;

        all_money.setResult(totalPrice+"");

    }

    //罗马杆组
    private void addLmg(){
        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        zu_lmg= layoutInflater.inflate(R.layout.zu_lmg,null);
        lmg_bu=(ItemWithEdit)zu_lmg.findViewById(R.id.lmg_bu);
        lmg_gang=(ItemWithEdit)zu_lmg.findViewById(R.id.lmg_gang);
        lmg_quan=(ItemWithEdit)zu_lmg.findViewById(R.id.lmg_quan);
        TextView del=(TextView)zu_lmg.findViewById(R.id.del);
        if(lmg_quan.getEdit_input_number()!=null){
            lmg_quan.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lmg_quan_edit=0.0;
                    }else{
                        lmg_quan_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(lmg_gang.getEdit_input_number()!=null){
            lmg_gang.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lmg_gang_edit=0.0;
                    }else{
                        lmg_gang_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }


        if(lmg_bu.getEdit_input_number()!=null){
            lmg_bu.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lmg_bu_edit=0.0;
                    }else{
                        lmg_bu_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lin_all.removeView(zu_lmg);
                popList.add(calculating[0]);
                zu_lmg=null;
                ChangeCalculating();

            }
        });
        lin_all.addView(zu_lmg);


    }
    //罗马帘组
    private void addLml(){

        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        zu_lml= layoutInflater.inflate(R.layout.zu_lml,null);
        lml_width=(NoItem)zu_lml.findViewById(R.id.lml_width);
        lml_height=(ItemWithText)zu_lml.findViewById(R.id.lml_height);
        lml_unit=(ItemWithEdit)zu_lml.findViewById(R.id.lml_unit);
        TextView del=(TextView)zu_lml.findViewById(R.id.del);

        if(lml_width.getEdit_input_number()!=null){
            lml_width.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lml_width_edit=0.0;
                    }else{
                        lml_width_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(lml_height.getEdit_input_number()!=null){
            lml_height.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lml_height_edit=0.0;
                    }else{
                        lml_height_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(lml_unit.getEdit_input_number()!=null){
            lml_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lml_unit_edit=0.0;
                    }else{
                        lml_unit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }



        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin_all.removeView(zu_lml);
                popList.add(calculating[5]);
                zu_lml=null;
                ChangeCalculating();
            }
        });
        lin_all.addView(zu_lml);
    }
    //工程组
    private void addGc(){

        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        zu_gc= layoutInflater.inflate(R.layout.zu_gc,null);
        TextView del=(TextView)zu_gc.findViewById(R.id.del);
        gc_width=(NoItem)zu_gc.findViewById(R.id.gc_width);
        gc_height=(ItemWithText)zu_gc.findViewById(R.id.gc_height);
        gc_unit=(ItemWithEdit)zu_gc.findViewById(R.id.gc_unit);

        if(gc_width.getEdit_input_number()!=null){
            gc_width.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        gc_width_edit=0.0;
                    }else{
                        gc_width_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(gc_height.getEdit_input_number()!=null){
            gc_height.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        gc_height_edit=0.0;
                    }else{
                        gc_height_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(gc_unit.getEdit_input_number()!=null){
            gc_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        gc_unit_edit=0.0;
                    }else{
                        gc_unit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin_all.removeView(zu_gc);
                popList.add(calculating[7]);
                zu_gc=null;
                ChangeCalculating();
            }
        });
        lin_all.addView(zu_gc);
    }
    //帘头组
    private void addLt(){

        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        zu_lt= layoutInflater.inflate(R.layout.zu_lt,null);
        TextView del=(TextView)zu_lt.findViewById(R.id.del);

        lt_buliao=(ItemWithEditWithEdit)zu_lt.findViewById(R.id.lt_buliao);
        lt_guidao=(ItemWithEditWithEdit)zu_lt.findViewById(R.id.lt_guidao);
        lt_moshu=(ItemWithEditWithEdit)zu_lt.findViewById(R.id.lt_moshu);
        lt_hua=(ItemWithEditWithEdit)zu_lt.findViewById(R.id.lt_hua);
        lt_jiagongunit=(ItemWithEditWithEdit)zu_lt.findViewById(R.id.lt_jiagongunit);

        lt_unit=(ItemWithText)zu_lt.findViewById(R.id.lt_unit);
        lt_guidaounit=(ItemWithText)zu_lt.findViewById(R.id.lt_guidaounit);
        lt_huaunit=(ItemWithText)zu_lt.findViewById(R.id.lt_huaunit);
        lt_moshuunit=(ItemWithText)zu_lt.findViewById(R.id.lt_moshuunit);
        lt_jiagong=(ItemWithText)zu_lt.findViewById(R.id.lt_jiagong);
        if(lt_buliao.getEdit_input_number()!=null){
            lt_buliao.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_width_edit=0.0;
                    }else{
                        lt_width_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_unit.getEdit_input_number()!=null){
            lt_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_unit_edit=0.0;
                    }else{
                        lt_unit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_guidao.getEdit_input_number()!=null){
            lt_guidao.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_guidao_edit=0.0;
                    }else{
                        lt_guidao_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_guidaounit.getEdit_input_number()!=null){
            lt_guidaounit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_guidaounit_edit=0.0;
                    }else{
                        lt_guidaounit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_hua.getEdit_input_number()!=null){
            lt_hua.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_hua_edit=0.0;
                    }else{
                        lt_hua_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_huaunit.getEdit_input_number()!=null){
            lt_huaunit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_huaunit_edit=0.0;
                    }else{
                        lt_huaunit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_moshu.getEdit_input_number()!=null){
            lt_moshu.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_mooshu_edit=0.0;
                    }else{
                        lt_mooshu_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_moshuunit.getEdit_input_number()!=null){
            lt_moshuunit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_moshuunit_edit=0.0;
                    }else{
                        lt_moshuunit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_jiagong.getEdit_input_number()!=null){
            lt_jiagong.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_jiagong_edit=0.0;
                    }else{
                        lt_jiagong_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(lt_jiagongunit.getEdit_input_number()!=null){
            lt_jiagongunit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        lt_jiagongunit_edit=0.0;
                    }else{
                        lt_jiagongunit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin_all.removeView(zu_lt);
                popList.add(calculating[2]);
                zu_lt=null;
                ChangeCalculating();
            }
        });
        lin_all.addView(zu_lt);
    }
    //配布组
    private void addPb(){
        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        zu_pu= layoutInflater.inflate(R.layout.zu_pb,null);
        TextView del=(TextView)zu_pu.findViewById(R.id.del);
        pb_num=(ItemWithEditWithEdit)zu_pu.findViewById(R.id.pb_num);
        pb_unit=(ItemWithText)zu_pu.findViewById(R.id.pb_unit);

        if(pb_num.getEdit_input_number()!=null){
            pb_num.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pb_num_edit=0.0;
                    }else{
                        pb_num_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(pb_unit.getEdit_input_number()!=null){
            pb_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pb_unit_edit=0.0;
                    }else{
                        pb_unit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin_all.removeView(zu_pu);
                popList.add(calculating[1]);
                zu_pu=null;
                ChangeCalculating();
            }
        });
        lin_all.addView(zu_pu);
    }
    //钩式组
    private void addGs(){

        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        zu_gs= layoutInflater.inflate(R.layout.zu_gs,null);
        TextView del=(TextView)zu_gs.findViewById(R.id.del);
        gs_bu=(ItemWithEdit)zu_gs.findViewById(R.id.gs_bu);
        gs_unit=(ItemWithEdit)zu_gs.findViewById(R.id.gs_unit);
        gs_gui=(ItemWithEdit)zu_gs.findViewById(R.id.gs_gui);

        if(gs_unit.getEdit_input_number()!=null){
            gs_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        gs_unit_edit=0.0;
                    }else{
                        gs_unit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(gs_gui.getEdit_input_number()!=null){
            gs_gui.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        gs_gang_edit=0.0;
                    }else{
                        gs_gang_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(gs_bu.getEdit_input_number()!=null){
            gs_bu.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        gs_bu_edit=0.0;
                    }else{
                        gs_bu_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin_all.removeView(zu_gs);
                popList.add(calculating[3]);
                zu_gs=null;
                ChangeCalculating();
            }
        });
        lin_all.addView(zu_gs);
    }
    //配件组
    private void addPj(){
        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        zu_pj= layoutInflater.inflate(R.layout.zu_pj,null);
        TextView del=(TextView)zu_pj.findViewById(R.id.del);
        pj_guaqiu=(ItemWithEditWithEdit)zu_pj.findViewById(R.id.pj_guaqiu);
        pj_qianggou=(ItemWithEditWithEdit)zu_pj.findViewById(R.id.pj_qianggou);
        pj_bengdai=(ItemWithEditWithEdit)zu_pj.findViewById(R.id.pj_bengdai);

        pj_guaqiu_unit=(ItemWithText)zu_pj.findViewById(R.id.pj_guaqiu_unit);
        pj_sha=(ItemWithText)zu_pj.findViewById(R.id.pj_sha);

        pj_huaunit=(ItemWithEdit)zu_pj.findViewById(R.id.pj_huaunit);
        pj_bu=(ItemWithEdit)zu_pj.findViewById(R.id.pj_bu);
        if(pj_guaqiu.getEdit_input_number()!=null){
            pj_guaqiu.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pj_gqnum_edit=0.0;
                    }else{
                        pj_gqnum_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(pj_guaqiu_unit.getEdit_input_number()!=null){
            pj_guaqiu_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pj_gqunit_edit=0.0;
                    }else{
                        pj_gqunit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(pj_huaunit.getEdit_input_number()!=null){
            pj_huaunit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pj_hua_edit=0.0;
                    }else{
                        pj_hua_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(pj_bengdai.getEdit_input_number()!=null){
            pj_bengdai.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pj_bengdai_edit=0.0;
                    }else{
                        pj_bengdai_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(pj_qianggou.getEdit_input_number()!=null){
            pj_qianggou.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pj_qianggou_edit=0.0;
                    }else{
                        pj_qianggou_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(pj_bu.getEdit_input_number()!=null){
            pj_bu.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pj_buliao_edit=0.0;
                    }else{
                        pj_buliao_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(pj_sha.getEdit_input_number()!=null){
            pj_sha.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        pj_sha_edit=0.0;
                    }else{
                        pj_sha_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin_all.removeView(zu_pj);
                popList.add(calculating[4]);
                zu_pj=null;
                ChangeCalculating();
            }
        });
        lin_all.addView(zu_pj);
    }
    //百叶帘组
    private void addByl(){

        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        zu_by= layoutInflater.inflate(R.layout.zu_byl,null);
        TextView del=(TextView)zu_by.findViewById(R.id.del);
        by_width=(NoItem)zu_by.findViewById(R.id.by_width);
        by_hight=(ItemWithText)zu_by.findViewById(R.id.by_hight);
        by_unit=(ItemWithEdit)zu_by.findViewById(R.id.by_unit);
        if(by_width.getEdit_input_number()!=null){
            by_width.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        by_width_edit=0.0;
                    }else{
                        by_width_edit=Double.parseDouble(charSequence.toString().trim());

                    }
//                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        if(by_hight.getEdit_input_number()!=null){
            by_hight.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        by_height_edit=0.0;
                    }else{
                        by_height_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        if(by_unit.getEdit_input_number()!=null){
            by_unit.getEdit_input_number().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(i2==0){
                        by_unit_edit=0.0;
                    }else{
                        by_unit_edit=Double.parseDouble(charSequence.toString().trim());

                    }
                    ChangeCalculating();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin_all.removeView(zu_by);
                popList.add(calculating[6]);
                zu_by=null;
                ChangeCalculating();
            }
        });
        lin_all.addView(zu_by);
    }

    @Override
    public boolean onItemLongClick(final BaseQuickAdapter adapter, View view, final int position) {

        final TextTipDialog myDialog = new TextTipDialog(this, "确定删除？");

        myDialog.show();
        myDialog.positive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                if(mSlb_my_Adapter==adapter){

                    CustomerOperate.deleteData(MainActivity.this,(Customer) adapter.getData().get(position));
                    mSlb_my_Adapter.remove(position);
                }else if(mSlb_order_Adapter==adapter){
                    SuanLiaoOperate.deleteData(MainActivity.this,(SuanLiao)adapter.getData().get(position));
                    mSlb_order_Adapter.remove(position);
                }


            }
        });
        myDialog.negative.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                myDialog.dismiss();
            }

        });



        return false;
    }
}
