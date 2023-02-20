package com.example.carbookingsystem.service.impl;

import com.example.carbookingsystem.mapper.UserMapper;
import com.example.carbookingsystem.service.UserService;
import com.example.carbookingsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
