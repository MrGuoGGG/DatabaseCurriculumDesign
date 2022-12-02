package com.gyx.mapper;

import com.gyx.pojo.S_User;
import com.gyx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SUserMapper {

    //根据用户名和密码查询用户是否存在---登录使用
    @Select("select * from s_user where sname=#{sname} and spassword=#{spassword}")
    S_User select(@Param("sname") String sname, @Param("spassword") String spassword);

    //根据用户id和用户名查询用户是否存在---注册使用
    @Select("select * from s_user where sid=#{sid} and sname=#{sname}")
    S_User selectByUserIdAndName(@Param("sid") String sid, @Param("sname") String sname);

    //添加用户---注册使用
    @Insert("insert into s_user values (#{sid},#{sname},#{spassword})")
    void add(S_User s_user);

    //查询所有用户
    @Select("select * from s_user")
    @ResultMap("S_UserResultMap")
    List<User> selectAll();

}
