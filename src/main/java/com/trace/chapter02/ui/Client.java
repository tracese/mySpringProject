package com.trace.chapter02.ui;

import com.trace.chapter02.service.IAccountService;
import com.trace.chapter02.service.impl.AccountServiceImpl;
/*
* 模仿表现出调用业务层
* */
public class Client {
    public static void main(String[] args) {
        IAccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }
}
