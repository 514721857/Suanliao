package com.finance.ymt.sgr.suanliao.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Data：2018/11/7/007-17:40
 * By  沈国荣
 * Description:
 */

@Entity
public class SuanLiao {

    @Id(autoincrement = true)
    Long id;
    
    String title;

    String name;

    String data;

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
    private double all_num_edit,all_bu_discount_edit,all_pj_discount_edit;

@Generated(hash = 102267723)
public SuanLiao(Long id, String title, String name, String data, double curtain_width_edit,
        double curtain_hight_edit, double curtain_beilu_edit, double curtain_bu_edit, double curtain_sha_edit,
        double lmg_quan_edit, double lmg_gang_edit, double lmg_bu_edit, double pb_num_edit,
        double pb_unit_edit, double lt_width_edit, double lt_unit_edit, double lt_guidao_edit,
        double lt_guidaounit_edit, double lt_hua_edit, double lt_huaunit_edit, double lt_mooshu_edit,
        double lt_moshuunit_edit, double lt_jiagong_edit, double lt_jiagongunit_edit, double gs_unit_edit,
        double gs_gang_edit, double gs_bu_edit, double pj_gqnum_edit, double pj_gqunit_edit,
        double pj_hua_edit, double pj_bengdai_edit, double pj_qianggou_edit, double pj_buliao_edit,
        double pj_sha_edit, double lml_width_edit, double lml_height_edit, double lml_unit_edit,
        double by_width_edit, double by_height_edit, double by_unit_edit, double gc_width_edit,
        double gc_height_edit, double gc_unit_edit, double all_num_edit, double all_bu_discount_edit,
        double all_pj_discount_edit) {
    this.id = id;
    this.title = title;
    this.name = name;
    this.data = data;
    this.curtain_width_edit = curtain_width_edit;
    this.curtain_hight_edit = curtain_hight_edit;
    this.curtain_beilu_edit = curtain_beilu_edit;
    this.curtain_bu_edit = curtain_bu_edit;
    this.curtain_sha_edit = curtain_sha_edit;
    this.lmg_quan_edit = lmg_quan_edit;
    this.lmg_gang_edit = lmg_gang_edit;
    this.lmg_bu_edit = lmg_bu_edit;
    this.pb_num_edit = pb_num_edit;
    this.pb_unit_edit = pb_unit_edit;
    this.lt_width_edit = lt_width_edit;
    this.lt_unit_edit = lt_unit_edit;
    this.lt_guidao_edit = lt_guidao_edit;
    this.lt_guidaounit_edit = lt_guidaounit_edit;
    this.lt_hua_edit = lt_hua_edit;
    this.lt_huaunit_edit = lt_huaunit_edit;
    this.lt_mooshu_edit = lt_mooshu_edit;
    this.lt_moshuunit_edit = lt_moshuunit_edit;
    this.lt_jiagong_edit = lt_jiagong_edit;
    this.lt_jiagongunit_edit = lt_jiagongunit_edit;
    this.gs_unit_edit = gs_unit_edit;
    this.gs_gang_edit = gs_gang_edit;
    this.gs_bu_edit = gs_bu_edit;
    this.pj_gqnum_edit = pj_gqnum_edit;
    this.pj_gqunit_edit = pj_gqunit_edit;
    this.pj_hua_edit = pj_hua_edit;
    this.pj_bengdai_edit = pj_bengdai_edit;
    this.pj_qianggou_edit = pj_qianggou_edit;
    this.pj_buliao_edit = pj_buliao_edit;
    this.pj_sha_edit = pj_sha_edit;
    this.lml_width_edit = lml_width_edit;
    this.lml_height_edit = lml_height_edit;
    this.lml_unit_edit = lml_unit_edit;
    this.by_width_edit = by_width_edit;
    this.by_height_edit = by_height_edit;
    this.by_unit_edit = by_unit_edit;
    this.gc_width_edit = gc_width_edit;
    this.gc_height_edit = gc_height_edit;
    this.gc_unit_edit = gc_unit_edit;
    this.all_num_edit = all_num_edit;
    this.all_bu_discount_edit = all_bu_discount_edit;
    this.all_pj_discount_edit = all_pj_discount_edit;
}

@Generated(hash = 350979434)
public SuanLiao() {
}

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public String getTitle() {
    return this.title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public String getData() {
    return this.data;
}

public void setData(String data) {
    this.data = data;
}

public double getCurtain_width_edit() {
    return this.curtain_width_edit;
}

public void setCurtain_width_edit(double curtain_width_edit) {
    this.curtain_width_edit = curtain_width_edit;
}

public double getCurtain_hight_edit() {
    return this.curtain_hight_edit;
}

public void setCurtain_hight_edit(double curtain_hight_edit) {
    this.curtain_hight_edit = curtain_hight_edit;
}

public double getCurtain_beilu_edit() {
    return this.curtain_beilu_edit;
}

public void setCurtain_beilu_edit(double curtain_beilu_edit) {
    this.curtain_beilu_edit = curtain_beilu_edit;
}

public double getCurtain_bu_edit() {
    return this.curtain_bu_edit;
}

public void setCurtain_bu_edit(double curtain_bu_edit) {
    this.curtain_bu_edit = curtain_bu_edit;
}

public double getCurtain_sha_edit() {
    return this.curtain_sha_edit;
}

public void setCurtain_sha_edit(double curtain_sha_edit) {
    this.curtain_sha_edit = curtain_sha_edit;
}

public double getLmg_quan_edit() {
    return this.lmg_quan_edit;
}

public void setLmg_quan_edit(double lmg_quan_edit) {
    this.lmg_quan_edit = lmg_quan_edit;
}

public double getLmg_gang_edit() {
    return this.lmg_gang_edit;
}

public void setLmg_gang_edit(double lmg_gang_edit) {
    this.lmg_gang_edit = lmg_gang_edit;
}

public double getLmg_bu_edit() {
    return this.lmg_bu_edit;
}

public void setLmg_bu_edit(double lmg_bu_edit) {
    this.lmg_bu_edit = lmg_bu_edit;
}

public double getPb_num_edit() {
    return this.pb_num_edit;
}

public void setPb_num_edit(double pb_num_edit) {
    this.pb_num_edit = pb_num_edit;
}

public double getPb_unit_edit() {
    return this.pb_unit_edit;
}

public void setPb_unit_edit(double pb_unit_edit) {
    this.pb_unit_edit = pb_unit_edit;
}

public double getLt_width_edit() {
    return this.lt_width_edit;
}

public void setLt_width_edit(double lt_width_edit) {
    this.lt_width_edit = lt_width_edit;
}

public double getLt_unit_edit() {
    return this.lt_unit_edit;
}

public void setLt_unit_edit(double lt_unit_edit) {
    this.lt_unit_edit = lt_unit_edit;
}

public double getLt_guidao_edit() {
    return this.lt_guidao_edit;
}

public void setLt_guidao_edit(double lt_guidao_edit) {
    this.lt_guidao_edit = lt_guidao_edit;
}

public double getLt_guidaounit_edit() {
    return this.lt_guidaounit_edit;
}

public void setLt_guidaounit_edit(double lt_guidaounit_edit) {
    this.lt_guidaounit_edit = lt_guidaounit_edit;
}

public double getLt_hua_edit() {
    return this.lt_hua_edit;
}

public void setLt_hua_edit(double lt_hua_edit) {
    this.lt_hua_edit = lt_hua_edit;
}

public double getLt_huaunit_edit() {
    return this.lt_huaunit_edit;
}

public void setLt_huaunit_edit(double lt_huaunit_edit) {
    this.lt_huaunit_edit = lt_huaunit_edit;
}

public double getLt_mooshu_edit() {
    return this.lt_mooshu_edit;
}

public void setLt_mooshu_edit(double lt_mooshu_edit) {
    this.lt_mooshu_edit = lt_mooshu_edit;
}

public double getLt_moshuunit_edit() {
    return this.lt_moshuunit_edit;
}

public void setLt_moshuunit_edit(double lt_moshuunit_edit) {
    this.lt_moshuunit_edit = lt_moshuunit_edit;
}

public double getLt_jiagong_edit() {
    return this.lt_jiagong_edit;
}

public void setLt_jiagong_edit(double lt_jiagong_edit) {
    this.lt_jiagong_edit = lt_jiagong_edit;
}

public double getLt_jiagongunit_edit() {
    return this.lt_jiagongunit_edit;
}

public void setLt_jiagongunit_edit(double lt_jiagongunit_edit) {
    this.lt_jiagongunit_edit = lt_jiagongunit_edit;
}

public double getGs_unit_edit() {
    return this.gs_unit_edit;
}

public void setGs_unit_edit(double gs_unit_edit) {
    this.gs_unit_edit = gs_unit_edit;
}

public double getGs_gang_edit() {
    return this.gs_gang_edit;
}

public void setGs_gang_edit(double gs_gang_edit) {
    this.gs_gang_edit = gs_gang_edit;
}

public double getGs_bu_edit() {
    return this.gs_bu_edit;
}

public void setGs_bu_edit(double gs_bu_edit) {
    this.gs_bu_edit = gs_bu_edit;
}

public double getPj_gqnum_edit() {
    return this.pj_gqnum_edit;
}

public void setPj_gqnum_edit(double pj_gqnum_edit) {
    this.pj_gqnum_edit = pj_gqnum_edit;
}

public double getPj_gqunit_edit() {
    return this.pj_gqunit_edit;
}

public void setPj_gqunit_edit(double pj_gqunit_edit) {
    this.pj_gqunit_edit = pj_gqunit_edit;
}

public double getPj_hua_edit() {
    return this.pj_hua_edit;
}

public void setPj_hua_edit(double pj_hua_edit) {
    this.pj_hua_edit = pj_hua_edit;
}

public double getPj_bengdai_edit() {
    return this.pj_bengdai_edit;
}

public void setPj_bengdai_edit(double pj_bengdai_edit) {
    this.pj_bengdai_edit = pj_bengdai_edit;
}

public double getPj_qianggou_edit() {
    return this.pj_qianggou_edit;
}

public void setPj_qianggou_edit(double pj_qianggou_edit) {
    this.pj_qianggou_edit = pj_qianggou_edit;
}

public double getPj_buliao_edit() {
    return this.pj_buliao_edit;
}

public void setPj_buliao_edit(double pj_buliao_edit) {
    this.pj_buliao_edit = pj_buliao_edit;
}

public double getPj_sha_edit() {
    return this.pj_sha_edit;
}

public void setPj_sha_edit(double pj_sha_edit) {
    this.pj_sha_edit = pj_sha_edit;
}

public double getLml_width_edit() {
    return this.lml_width_edit;
}

public void setLml_width_edit(double lml_width_edit) {
    this.lml_width_edit = lml_width_edit;
}

public double getLml_height_edit() {
    return this.lml_height_edit;
}

public void setLml_height_edit(double lml_height_edit) {
    this.lml_height_edit = lml_height_edit;
}

public double getLml_unit_edit() {
    return this.lml_unit_edit;
}

public void setLml_unit_edit(double lml_unit_edit) {
    this.lml_unit_edit = lml_unit_edit;
}

public double getBy_width_edit() {
    return this.by_width_edit;
}

public void setBy_width_edit(double by_width_edit) {
    this.by_width_edit = by_width_edit;
}

public double getBy_height_edit() {
    return this.by_height_edit;
}

public void setBy_height_edit(double by_height_edit) {
    this.by_height_edit = by_height_edit;
}

public double getBy_unit_edit() {
    return this.by_unit_edit;
}

public void setBy_unit_edit(double by_unit_edit) {
    this.by_unit_edit = by_unit_edit;
}

public double getGc_width_edit() {
    return this.gc_width_edit;
}

public void setGc_width_edit(double gc_width_edit) {
    this.gc_width_edit = gc_width_edit;
}

public double getGc_height_edit() {
    return this.gc_height_edit;
}

public void setGc_height_edit(double gc_height_edit) {
    this.gc_height_edit = gc_height_edit;
}

public double getGc_unit_edit() {
    return this.gc_unit_edit;
}

public void setGc_unit_edit(double gc_unit_edit) {
    this.gc_unit_edit = gc_unit_edit;
}

public double getAll_num_edit() {
    return this.all_num_edit;
}

public void setAll_num_edit(double all_num_edit) {
    this.all_num_edit = all_num_edit;
}

public double getAll_bu_discount_edit() {
    return this.all_bu_discount_edit;
}

public void setAll_bu_discount_edit(double all_bu_discount_edit) {
    this.all_bu_discount_edit = all_bu_discount_edit;
}

public double getAll_pj_discount_edit() {
    return this.all_pj_discount_edit;
}

public void setAll_pj_discount_edit(double all_pj_discount_edit) {
    this.all_pj_discount_edit = all_pj_discount_edit;
}


}
