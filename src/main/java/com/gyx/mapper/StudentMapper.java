package com.gyx.mapper;

import com.gyx.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



public interface StudentMapper {
    //根据id查询学生信息
    @Select("select * from students where sid=#{sid}")
    Student selectById(@Param("sid") String sid);
}
