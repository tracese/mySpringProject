package com.trace.chapter02.ui;

import com.trace.chapter02.factory.BeanFactory;
import com.trace.chapter02.service.IAccountService;
/*
* 模仿表现出调用业务层
* */
public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
        IAccountService accountService = (IAccountService) BeanFactory.getBean("AccountService");
        accountService.saveAccount();
    }
}
