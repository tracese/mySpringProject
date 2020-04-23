package com.trace.chapter02.service.impl;

import com.trace.chapter02.dao.IAccountDao;
import com.trace.chapter02.factory.BeanFactory;
import com.trace.chapter02.service.IAccountService;
/*
* 账户的业务层实现类
* */
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImpl();

    @Override
    public void saveAccount() {
        IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("AccountDao");
        accountDao.saveAccount();
    }
}
