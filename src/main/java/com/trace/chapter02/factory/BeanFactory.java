package com.trace.chapter02.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
* 一个创建Bean对象的工厂
* Bean：在计算机英语中，有可重用组件的含义
* JavaBean:用Java语言编写的可重用组件
* JavaBean > 实体类 即实体类只是JavaBean的一个例子，像service也可以作为JavaBean
* 现在这个工厂就是用来创建service和dao对象的
* 使用工厂降低程序的耦合：
*   1、需要一个配置文件来配置我们的service和dao
*       配置的内容：唯一标志=全限定类名（key=value）
*   2、通过读取配置文件中配置的内容，反射创建对象
*   配置文件可以是xml，也可以是properties
* */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties properties;
    //使用静态代码块为Properties赋值
    static {
        //实例化Properties对象
        properties = new Properties();
        //获取properties文件的流对象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties文件失败!");
        }
    }

    public static Object getBean(String beanName){
        Object bean = null;
        String beanPath = properties.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
