package com.example.carbookingsystem;


import com.example.carbookingsystem.model.Car;
import com.example.carbookingsystem.model.Order;

import com.example.carbookingsystem.service.CarService;
import com.example.carbookingsystem.service.OrderService;

import com.example.carbookingsystem.service.impl.CarServiceImpl;
import com.example.carbookingsystem.service.impl.OrderServiceImpl;
import jdk.dynalink.beans.StaticClass;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.mock;


@SpringBootTest
@RunWith(SpringRunner.class)
class CarBookingSystemApplicationTests {


    @Test
    void testAddOrder() throws ParseException {
        String type ="BMW 650";

        CarService carService = mock(CarServiceImpl.class);

        Mockito.when(carService.getCarByType(type)).thenReturn(new Car("3ef4e54203f0433db6d3511b27c80452", "BMW 650",2,400.0));

        Order order = new Order();

        String carId = carService.getCarByType(type).getId();
        double price = carService.getCarByType(type).getPrice();


        Assert.assertTrue("3ef4e54203f0433db6d3511b27c80452".equals(carId));
        Assert.assertTrue("BMW 650".equals(type));
        Assert.assertTrue(carService.getCarByType(type).getCount() == 2);
        Assert.assertTrue(price == 400.0);

        String userId = "421022199212113925";
        String id = UUID.randomUUID().toString().replace("-","");
        order.setId(id);
        order.setUserId(userId);
        order.setCarId(carId);

        String beginTime = "2023-02-20";
        String endTime = "2023-02-24";
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

        OrderService orderService = mock(OrderServiceImpl.class);
        Mockito.when(orderService.addOrder(order)).thenReturn(1);
        int count = orderService.addOrder(order);

        Assert.assertTrue(count==1);
        Assert.assertTrue("421022199212113925".equals(order.getUserId()));
        Assert.assertTrue("3ef4e54203f0433db6d3511b27c80452".equals(order.getCarId()));
        Assert.assertTrue("2023-02-20".equals(order.getStartTime()));
        Assert.assertTrue("2023-02-24".equals(order.getEndTime()));
        Assert.assertTrue(order.getIncome() ==1600.0);
        Assert.assertTrue(count==1);

    }

}
