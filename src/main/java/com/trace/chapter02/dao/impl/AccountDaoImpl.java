package com.trace.chapter02.dao.impl;

import com.trace.chapter02.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存的账户");
    }
}
