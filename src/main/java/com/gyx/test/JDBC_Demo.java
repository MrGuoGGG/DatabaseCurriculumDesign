package com.gyx.test;

import com.gyx.pojo.Book;
import com.gyx.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Demo {
    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("org.postgresql.Driver");

        //获取连接
        String url="jdbc:postgresql://123.249.71.167:26000/demo";
        String username="joe";
        String password="Bigdata@123";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("数据库连接成功!");

        //定义sql
        String sql="select * from books";

        //获取sql执行对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = preparedStatement.executeQuery();

        //创建集合
        List<Book> list=new ArrayList<>();

        //显示结果
        while (resultSet.next()){
            Book book = new Book();
            String bid=resultSet.getString("bid");
            String bname=resultSet.getString("bname");
            String bauthor = resultSet.getString("bauthor");
            String blanguage = resultSet.getString("blanguage");
            book.setBid(bid);
            book.setBname(bname);
            book.setBauthor(bauthor);
            book.setBlanguage(blanguage);
            list.add(book);
        }
        System.out.println(list);

        //释放资源
        connection.close();

    }
}
