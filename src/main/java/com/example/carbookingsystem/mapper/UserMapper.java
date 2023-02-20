package com.example.carbookingsystem.mapper;

import com.example.carbookingsystem.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(id, name, password, sex, phone) values(#{id},#{name}, #{password},#{sex},#{phone})")
    int insert(User user);

    @Select("select * from user where id = #{id}")
    User getUserById(String id);
}
