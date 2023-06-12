package com.example.DynamoDB.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.DynamoDB.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void save(UserEntity user) {
        dynamoDBMapper.save(user);
    }


}
