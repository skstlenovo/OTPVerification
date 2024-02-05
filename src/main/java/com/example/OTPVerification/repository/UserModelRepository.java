package com.example.OTPVerification.repository;

import com.example.OTPVerification.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepository extends MongoRepository<UserModel,String> {
    @Query("{'emailId':?0}")
    UserModel findByEmailId(String emailId);
}
