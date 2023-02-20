package com.example.carbookingsystem.service;

import com.example.carbookingsystem.model.User;

public interface UserService {

    int insertUser(User user);

    User getUserById(String id);
}
