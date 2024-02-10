**OTP Authentication Using Jwt** 

> Created a login page using HTML, CSS and JavaScript.
For the Backend, used Spring Boot 3.1 with jwt dependency.
Implemented two APIs: one for sending OTP and the other for verifying OTP.
Utilized JWT to generate tokens along with 6-digit OTPs and for OTP verification


![image](https://github.com/skstlenovo/OTPVerification/assets/116804212/cf5bfa14-7f0d-4c52-840f-95a520e0286c)


POST Method for Login

![image](https://github.com/skstlenovo/OTPVerification/assets/116804212/934733a0-ecf3-40d3-a791-554b2453f852)

After hitting the sendOTP API, it calls the authentication service, which creates a Jwt token with the reference to the email id and a 6-digit OTP.
The 6-digit OTP is then sent to the provided email id, and the token is sent back as a response.
Now, we have the token as a response.

![image](https://github.com/skstlenovo/OTPVerification/assets/116804212/2f81cbad-e596-4246-beb7-849b8b40b744)

We have a 6-digit OTP input popup where we need to enter the received OTP and click on the "verify" button.
![image](https://github.com/skstlenovo/OTPVerification/assets/116804212/e09e294b-ceca-4b45-a8ee-0f01aa54a900)

When click on verifiy then it hits verifyOTP api to authenticate the otp
![image](https://github.com/skstlenovo/OTPVerification/assets/116804212/0cb9ecbd-99f5-4f74-a69f-2e38086bb18c)




