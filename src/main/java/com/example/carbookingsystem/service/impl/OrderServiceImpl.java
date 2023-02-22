package com.example.carbookingsystem.service.impl;

import com.example.carbookingsystem.mapper.OrderMapper;
import com.example.carbookingsystem.model.Order;
import com.example.carbookingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public synchronized int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

}
