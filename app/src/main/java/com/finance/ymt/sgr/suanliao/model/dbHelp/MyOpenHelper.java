package com.finance.ymt.sgr.suanliao.model.dbHelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.finance.ymt.sgr.suanliao.model.greendao.DaoMaster;

import org.greenrobot.greendao.database.Database;


public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 数据库升级
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
    /*    操作数据库的更新 有几个表升级都可以传入到下面,然后在app的build.gradle
        里修改数据库版本号，即可做到保存
        数据的更新数据库*/
//        MigrationHelper.getInstance().migrate(db,UserDao.class);
    }

}