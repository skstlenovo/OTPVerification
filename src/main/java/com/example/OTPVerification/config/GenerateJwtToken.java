package com.example.OTPVerification.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Random;

public class GenerateJwtToken {

    private static final String Secret_Key = "444jjhkks44amdhkfhoiereqnrunakja445a1adfda2Agadg577a4aa5a55a7a78a5a554a54548412218412kjhkhiiio2a";
    private static final long Expiry_Time_InMillis= 5*600000;
    private static final int OTP_Length=6;


    public static String[] generateToken(String emailId){
        Date today=new Date();
        Date otpExpiry=new Date(today.getTime() +Expiry_Time_InMillis);
        String otp=generateOTP();
//        System.out.println("this is otp "+otp);
        String [] otpToken=new String[2];
        otpToken[0]=otp;
        otpToken[1]=Jwts.builder().setSubject(emailId).claim("otp",otp).setIssuedAt(today).setExpiration(otpExpiry).signWith(SignatureAlgorithm.HS256,Secret_Key).compact();
        return otpToken;
    }

    public static boolean validateTokenAndOTP(String otp,String token){
        try{
            Claims claims = Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(token).getBody();
            String tokenOtp=claims.get("otp",String.class);
            return otp.equals(tokenOtp);
        }catch (Exception e){
            return false;
        }
    }

    private static String generateOTP(){
        Random random=new Random();
        StringBuilder otp=new StringBuilder();

        for(int i=0; i<OTP_Length;i++){
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

}

