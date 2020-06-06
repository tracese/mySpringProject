package com.trace;

import com.trace.chapter02.dao.IAccountDao;
import com.trace.chapter02.service.IAccountService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);
//        System.out.println( "Hello World!" );
    }


}
