package com.example.carbookingsystem.controller;

import com.example.carbookingsystem.service.UserService;
import com.example.carbookingsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public int addUser(String cardID, String username, String password, String phone){
        User user= new User();
        user.setId(cardID);
        user.setName(username);
        user.setPassword(password);
        user.setPhone(phone);

        int result = userService.insertUser(user);
        return result;
    }

    @GetMapping(value = "/searchUserById")
    public User getUserById(String id){
        User user = userService.getUserById(id);
        return user;
    }
}
