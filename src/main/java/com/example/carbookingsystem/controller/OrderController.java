package com.example.carbookingsystem.controller;


import com.example.carbookingsystem.model.Car;
import com.example.carbookingsystem.model.Order;
import com.example.carbookingsystem.model.User;
import com.example.carbookingsystem.service.CarService;
import com.example.carbookingsystem.service.OrderService;
import com.example.carbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CarService carService;


    @GetMapping("/rent")
    public int addOrder(String userId, String type, String beginTime, String endTime) throws ParseException {
        Car car = carService.getCarByType(type);
        String carId = car.getId();
        double price = car.getPrice();
        Order order = new Order();

        String id = UUID.randomUUID().toString().replace("-","");
        order.setId(id);
        order.setUserId(userId);
        order.setCarId(carId);
        order.setStartTime(beginTime);
        order.setEndTime(endTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse(beginTime);
        Date end = sdf.parse(endTime);
        long startDate = start.getTime();
        long endDate = end.getTime();
        long betweenDays = (endDate-startDate)/(1000*3600*24);
        int days = Integer.parseInt(String.valueOf(betweenDays));
        double income = price*days;
        order.setIncome(income);

        int count = orderService.addOrder(order);
        return count;
    }
}
