package com.example.OTPVerification.controller;

import com.example.OTPVerification.services.AuthenticationService;
import com.example.OTPVerification.services.UserModelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/otp")
public class SendOtpController {

    @Autowired
    private AuthenticationService authenticationService;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserModelServices userModelServices;

    @PostMapping("/sendOTP")
    public String sendOtp(@RequestParam("emailId") String emailId){
//        System.out.println("Otp send to "+emailId+" email Id");
        String token=authenticationService.generateOtpAndSend(emailId);
        return token;
    }
//    @Value("${api.base-url")
//    private String baseUrl;

    @PostMapping("/verifyOTP")
    public Boolean verifyOtp(@RequestParam String otp, @RequestParam String authToken, @RequestParam String emailId){
        System.out.println(" Verify Otp Called and OTP is "+otp+"\nauthToken "+authToken);

//        if(authenticationService.verifyOtp(otp,authToken)){

//            if(userModelServices.getUserByemail(emailId)!=null){
                System.out.println("user exists");
//                String apiUrl="http://localhost:8081/user_profile";
//                RestTemplate restTemplate=new RestTemplate();
//                String result=restTemplate.getForObject(apiUrl, String.class);
//                return result;
//            }else{
//                System.out.println("User is new");
//                String apiUrl="/registration_page";
//                RestTemplate restTemplate=new RestTemplate();
//                String result=restTemplate.getForObject(apiUrl, String.class);
//                return result;
//            }

//        }
        return authenticationService.verifyOtp(otp,authToken);
    }

}
