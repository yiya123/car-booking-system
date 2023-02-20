package com.example.carbookingsystem.service.impl;

import com.example.carbookingsystem.mapper.CarMapper;
import com.example.carbookingsystem.model.Car;
import com.example.carbookingsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;


    @Override
    public Car getCarById(String id) {
        return carMapper.getCarById(id);
    }

    @Override
    public int addCar(Car car) {
        return carMapper.addCar(car);
    }

    @Override
    public Car getCarByType(String type) {
        return carMapper.getCarByType(type);
    }
}
