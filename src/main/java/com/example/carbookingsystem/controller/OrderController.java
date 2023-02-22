package com.example.carbookingsystem.controller;


import com.example.carbookingsystem.model.Car;
import com.example.carbookingsystem.model.Order;

import com.example.carbookingsystem.service.CarService;
import com.example.carbookingsystem.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;


@RestController
@RequestMapping("/order")
public class OrderController {

    private Logger logger = Logger.getLogger(String.valueOf(OrderController.class));

    @Autowired
    private OrderService orderService;

    @Autowired
    private CarService carService;


    @GetMapping("/rent")
    public int addOrder(String userId, String type, String beginTime, String endTime) throws ParseException {
        Car car = carService.getCarByType(type);
        String carId = car.getId();
        double price = car.getPrice();
        int carCount = car.getCount();

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
        if(count > 1){
            carCount = carCount -1;
            if(carCount > -1){
                carService.updateCarByCount(carId, carCount);
            }else {
                logger.info("the car number is not enough!");
            }

        }
        return count;
    }
}
