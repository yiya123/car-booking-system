package com.example.carbookingsystem.mapper;

import com.example.carbookingsystem.model.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CarMapper {

    @Select("select * from car where id= #{id}")
    Car getCarById(String id);

    @Insert("insert into car(id, type, count, price) values(#{id},#{type}, #{count},#{price})")
    int addCar(Car car);

    @Select("select * from car where type= #{type}")
    Car getCarByType(String type);
    @Update("update car set count = #{count} where id=#{id}")
    int updateCarByCount(String id, int count);
}
