package com.example.carbookingsystem;

import com.example.carbookingsystem.controller.OrderController;
import com.example.carbookingsystem.model.User;
import com.example.carbookingsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class CarBookingSystemApplicationTests {

    @Autowired
    private OrderController orderController;

    @Test
    void contextLoads() {
    }



//    @Test
//    public void testAddOrder(){
//        orderController.addOrder()
//    }

}
