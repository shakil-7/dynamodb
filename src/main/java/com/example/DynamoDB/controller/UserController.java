package com.example.DynamoDB.controller;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.DynamoDB.dto.BalanceRangeDto;
import com.example.DynamoDB.entity.UserEntity;
import com.example.DynamoDB.repository.UserRepo;
import com.example.DynamoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    }

    @PostMapping("/account-with-balance-in-between")
    public List<UserEntity> getAccountWithBalance(@RequestBody BalanceRangeDto dto) {
        return userService.getAccountWithBalance(dto);
    }
}
