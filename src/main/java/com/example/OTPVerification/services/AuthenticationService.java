package com.example.OTPVerification.services;

import com.example.OTPVerification.config.GenerateJwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    @Autowired
    private JavaMailSender javaMailSender;


    public String generateOtpAndSend(String emailId){

        String[] token= GenerateJwtToken.generateToken(emailId);

//        System.out.println(token[1]);
        String mailBody= "Hi \nYour OTP for login is "+token[0]+" .\nThis will be expired in 5 min.\n\n\nThank You!\nCreated by Sanjay Kumar";

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("skstlenovo@gmail.com");
        mailMessage.setTo(emailId);
        mailMessage.setSubject("OTP for Varification");
        mailMessage.setText(mailBody);
        javaMailSender.send(mailMessage);

        return token[1];
    }

    public boolean verifyOtp(String otp,String authToken){
        boolean verify=GenerateJwtToken.validateTokenAndOTP(otp,authToken);
        return verify;
    }
}
