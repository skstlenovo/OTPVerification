package com.example.OTPVerification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {

    @RequestMapping("/login")
    public String login_page(){
        return "login_page";
    }

    @RequestMapping("/registration_page")
    public String registration_page(){
        return "registration_page";
    }

    @RequestMapping("/user_profile")
    public String user_profile(){
        return "user_profile";
    }

}
