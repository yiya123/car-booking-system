package com.example.carbookingsystem.controller;

import com.example.carbookingsystem.mapper.CarMapper;
import com.example.carbookingsystem.model.Car;
import com.example.carbookingsystem.model.User;
import com.example.carbookingsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/add")
    public int addCar(String type, int count, double price){
        Car car = new Car();
        String carId = UUID.randomUUID().toString().replace("-","");
        car.setId(carId);
        car.setType(type);
        car.setCount(count);
        car.setPrice(price);
        return carService.addCar(car);
    }

    @RequestMapping(value = "/searchUserById")
    public Car getCarById(String id){
        Car car = carService.getCarById(id);
        return car;
    }
}
