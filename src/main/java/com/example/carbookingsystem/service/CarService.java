package com.example.carbookingsystem.service;

import com.example.carbookingsystem.model.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarService {

    Car getCarById(String id);
    int addCar(Car car);

    Car getCarByType(String type);
}
