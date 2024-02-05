package com.example.OTPVerification.controller;

import com.example.OTPVerification.models.UserModel;
import com.example.OTPVerification.services.UserModelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UserModelServices userModelServices;

    @PostMapping("/addUser")
    public UserModel addUser(@RequestBody UserModel userModel){
        return userModelServices.addUser(userModel);
    }

}
