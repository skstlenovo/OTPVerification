package com.example.OTPVerification.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collation="users")
public class UserModel {

    private String name;
    private String emailId;
}
