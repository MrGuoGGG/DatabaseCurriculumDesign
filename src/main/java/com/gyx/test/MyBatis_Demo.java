package com.gyx.test;

import com.gyx.mapper.StudentMapper;
import com.gyx.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatis_Demo {
    public static void main(String[] args) throws Exception{

        //1.加载mybatis核心配置文件，获取SqlSessionFactor
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.获取SqlSession对象，执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        Student student=studentMapper.selectById("101");
        System.out.println(student);

        //4.释放资源
        sqlSession.close();
    }
}
