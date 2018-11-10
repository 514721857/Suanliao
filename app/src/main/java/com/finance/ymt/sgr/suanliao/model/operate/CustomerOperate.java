package com.finance.ymt.sgr.suanliao.model.operate;

import android.content.Context;


import com.finance.ymt.sgr.suanliao.model.bean.Customer;
import com.finance.ymt.sgr.suanliao.model.dbHelp.DbManager;
import com.finance.ymt.sgr.suanliao.model.greendao.CustomerDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Data：2018/1/23/023-16:01
 * By  沈国荣
 * Description: 操作类 示例
 * 调用示例：otherDbOperate.insertData(this,test);
 */
public class CustomerOperate {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param user
     */
    public static void insertData(Context context, Customer user) {
      long i=  DbManager.getDaoSession(context).getCustomerDao().insert(user);
    }



    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param student
     */
    public static void saveData(Context context, Customer student) {
        CustomerDao tempUser= DbManager.getDaoSession(context).getCustomerDao();
        tempUser.save(student);
/*        QueryBuilder<User> builder = tempUser.queryBuilder();
        Query query = builder.where(UserDao.Properties.Customer_id.eq(student.getCustomer_id()))
                .build();
         Log.d("getLogin数据库",student.getAccess_token());
        if(query.list().size()>0){//如果存在就更新
            Log.d("更新前" ," ");//判断更新前是否成功

            tempUser.insertOrReplace(student);


            Log.d("getLogin更新成功",query.list().size()+"");
        }else{//如果不存在就插入
            tempUser.save(student);
        }*/

    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param user 删除具体内容
     */
    public static void deleteData(Context context, Customer user) {
        DbManager.getDaoSession(context).getCustomerDao().delete(user);
    }


    /**
     * 更新数据库
     *
     * @param context
     * @param student
     */
    public static void updateData(Context context, Customer student) {
        DbManager.getDaoSession(context).getCustomerDao().update(student);
    }

    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<Customer> queryAll(Context context) {
        QueryBuilder<Customer> builder = DbManager.getDaoSession(context).getCustomerDao().queryBuilder();

        System.out.println("查询");
        return builder.build().list();
    }
    /**
     * 查询，customer_id
     *
     * @return  bean
     */
    public static Customer queryByCustomer_id(Context context,Long customer_id) {
       /* QueryBuilder<User> builder = DbManager.getDaoSession(context).getUserDao().queryBuilder();
        return builder.where(UserDao.Properties.Customer_id.eq(customer_id)).build().unique();*/
        return DbManager.getDaoSession(context).getCustomerDao().load(customer_id);
    }





}