package com.finance.ymt.sgr.suanliao.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Data：2018/11/7/007-17:38
 * By  沈国荣
 * Description:
 */
@Entity
public class Customer {
    @Id(autoincrement = true)
    Long id;
    String name;
    String phone;
    String address;
    String tip;//备注
    @Generated(hash = 1084438284)
    public Customer(Long id, String name, String phone, String address,
            String tip) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.tip = tip;
    }
    @Generated(hash = 60841032)
    public Customer() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTip() {
        return this.tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }


}
