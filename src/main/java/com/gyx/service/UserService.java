package com.gyx.service;

import com.gyx.mapper.SUserMapper;
import com.gyx.pojo.S_User;
import com.gyx.pojo.User;
import com.gyx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /*
        查询所有用户
     */
    public List<User> selectAll() {
        //调用SUserMapper.selectAll()

        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取SUserMapper
        SUserMapper mapper = sqlSession.getMapper(SUserMapper.class);
        //调用方法
        List<User> users = mapper.selectAll();
        //释放资源
        sqlSession.close();
        //返回结果
        return users;
    }

    /*
        登陆方法
        根据用户名和密码查询对应数据
     */
    public S_User login(String susername, String spassword) {
        //调用SUserMapper.select

        //1.获取AqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取SUserMapper
        SUserMapper mapper = sqlSession.getMapper(SUserMapper.class);

        //3.调用方法
        S_User sUser = mapper.select(susername, spassword);

        //4.释放资源
        sqlSession.close();

        return sUser;
    }

    /*
        注册方法
     */
    public boolean register(S_User s_user) {
        //调用SUserMapper.selectByUserIdAndName

        //1.获取AqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取SUserMapper
        SUserMapper mapper = sqlSession.getMapper(SUserMapper.class);

        //3.调用方法,查询用户id和用户名是否存在
        S_User s_user1 = mapper.selectByUserIdAndName(s_user.getSid(), s_user.getSname());
        if (s_user1 == null) {
            //用户名不存在
            mapper.add(s_user);
            sqlSession.commit();
        }

        //4.释放资源
        sqlSession.close();

        return s_user1==null;

    }
}
