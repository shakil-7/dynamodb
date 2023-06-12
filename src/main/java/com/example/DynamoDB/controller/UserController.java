package com.example.DynamoDB.controller;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.DynamoDB.entity.UserEntity;
import com.example.DynamoDB.repository.UserRepo;
import com.example.DynamoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @PostMapping("/add-user")
    public void register(@RequestBody UserEntity user) {
        userService.createUser(user);
    }

    @PostMapping("/create-new-account")
    public void create(@RequestBody UserEntity user) {

        userService.createAccount(user);

//        user.setAccountNo(
//            UUID.randomUUID().toString()
//        );
//        // check if the user is there
//        dynamoDBMapper.save(user);
    }
}
