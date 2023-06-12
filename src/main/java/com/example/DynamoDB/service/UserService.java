package com.example.DynamoDB.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.DynamoDB.entity.UserDetails;
import com.example.DynamoDB.entity.UserEntity;
import com.example.DynamoDB.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void createUser(UserEntity user) {
        userRepo.save(user);
    }

    public void createAccount(UserEntity user) {
        UserEntity isPresent = dynamoDBMapper.load(UserEntity.class, "01781651038");
        if(isPresent != null) {
            user.setAccountNo(UUID.randomUUID().toString());
            System.out.println("isPresent = " + isPresent);

            UserDetails userDetails = isPresent.getUserDetails();
            ArrayList<String> accountList = userDetails.getListOfAccount();
            accountList.add(user.getAccountNo());
            userDetails.setListOfAccount(accountList);

            isPresent.setUserDetails(userDetails);

            dynamoDBMapper.save(isPresent);
            dynamoDBMapper.save(user);
        }
    }
}
