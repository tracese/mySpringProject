package com.trace.chapter01;

import java.sql.*;

/**
耦合：程序间的依赖关系
* 包括：
*   1、类之间的依赖关系
*   2、方法之间的依赖关系
* 解耦：降低程序之间的依赖关系
* 实际开发中：
*   应该做到编译器不依赖，运行期才依赖
* 解耦的思路：
*   第一步：使用反射创建创建对象，而避免使用new关键字
*   第二步：通过读取配置文件来获取要创建的对象的全限定类名
* */
public class JdbcDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1、注册驱动(如果没有导入依赖的驱动，程序在编译期就会出错，->程序耦合问题)
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 依赖于具体的驱动类 vs 依赖于一个字符串
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
        //3、获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4、执行SQL语句，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5、遍历（封装）结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6、释放资源
        conn.close();
        pstm.close();
        rs.close();
   }
}
