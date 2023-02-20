package com.example.carbookingsystem.mapper;

import com.example.carbookingsystem.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    @Insert("insert into `order`(id, userId, carId, startTime, endTime, income) values(#{id},#{userId}, #{carId},#{startTime},#{endTime}, #{income})")
    int addOrder(Order order);
}
