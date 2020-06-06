package com.trace.chapter02.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
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
*问题描述：
*   创建的对象不是单例对象，对象被创建多次，执行效率没有单例对象高
*解决措施：
*   在工厂初始化时即创建对象，并保存在容器中，单例对象存在线程安全问题，尽量不要在类中定义成员变量，定义在方法中
* */
public class BeanFactory {
    /**
     * 定义一个Properties对象
     */
    private static Properties properties;
    /**
     * 定义一个Map，用于存放我们要创建的对象，我们把它称之为容器
     */
    private static Map<String,Object> beans;
    //使用静态代码块为Properties赋值
    static {
        try{
            //实例化Properties对象
            properties = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);

            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中的所有key
            Enumeration keys = properties.keys();
            //遍历枚举
            while(keys.hasMoreElements()) {
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }
    /*
    * 根据name创建对象
    * */
/*    public static Object getBean(String beanName){
        Object bean = null;
        String beanPath = properties.getProperty(beanName);
        try {
//            每次调用默认构造函数创建新的对象
            bean = Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }*/


    public static Object getBean(String beanName){
        return  beans.get(beanName);
    }
}
