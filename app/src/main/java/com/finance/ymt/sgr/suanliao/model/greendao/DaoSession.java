package com.finance.ymt.sgr.suanliao.model.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.finance.ymt.sgr.suanliao.model.bean.Customer;
import com.finance.ymt.sgr.suanliao.model.bean.SuanLiao;

import com.finance.ymt.sgr.suanliao.model.greendao.CustomerDao;
import com.finance.ymt.sgr.suanliao.model.greendao.SuanLiaoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig customerDaoConfig;
    private final DaoConfig suanLiaoDaoConfig;

    private final CustomerDao customerDao;
    private final SuanLiaoDao suanLiaoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        customerDaoConfig = daoConfigMap.get(CustomerDao.class).clone();
        customerDaoConfig.initIdentityScope(type);

        suanLiaoDaoConfig = daoConfigMap.get(SuanLiaoDao.class).clone();
        suanLiaoDaoConfig.initIdentityScope(type);

        customerDao = new CustomerDao(customerDaoConfig, this);
        suanLiaoDao = new SuanLiaoDao(suanLiaoDaoConfig, this);

        registerDao(Customer.class, customerDao);
        registerDao(SuanLiao.class, suanLiaoDao);
    }
    
    public void clear() {
        customerDaoConfig.clearIdentityScope();
        suanLiaoDaoConfig.clearIdentityScope();
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public SuanLiaoDao getSuanLiaoDao() {
        return suanLiaoDao;
    }

}