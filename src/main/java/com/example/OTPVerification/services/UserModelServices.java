package com.example.OTPVerification.services;

import com.example.OTPVerification.models.UserModel;
import com.example.OTPVerification.repository.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserModelServices {

    @Autowired
    private UserModelRepository userModelRepository;

    public UserModel addUser(UserModel userModel){
        return userModelRepository.save(userModel);
    }

    public UserModel getUserByemail(String emailId){
            UserModel userModel=userModelRepository.findByEmailId(emailId);

        return userModel;
    }
}
