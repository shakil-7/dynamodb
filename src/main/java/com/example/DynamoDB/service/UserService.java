package com.example.DynamoDB.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.DynamoDB.dto.BalanceRangeDto;
import com.example.DynamoDB.entity.UserDetails;
import com.example.DynamoDB.entity.UserEntity;
import com.example.DynamoDB.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DynamoDBMapper dynamoDBMapper;
    public void createUser(UserEntity user) {
        user.setUserId("USER#" + user.getUserId());
        user.setAccountNo("USER#NULL");
        userRepo.save(user);
    }
    public void createAccount(UserEntity user) {
//        System.out.println("user.getUserId() = " + "USER#" + user.getUserId());
        UserEntity isPresent = dynamoDBMapper.load(UserEntity.class, "USER#"+user.getUserId(), "USER#NULL");
//        System.out.println("isPresent = " + isPresent);
        if(isPresent != null) {
            user.setAccountNo("ACCOUNT#" + "DPS_" + UUID.randomUUID());
            UserDetails userDetails = isPresent.getUserDetails();
            ArrayList<String> accountList = userDetails.getListOfAccount();
            accountList.add(user.getAccountNo());
            userDetails.setListOfAccount(accountList);
            isPresent.setUserDetails(userDetails);
            dynamoDBMapper.save(isPresent);
            user.setUserId("ACCOUNT#" + user.getUserId());
            dynamoDBMapper.save(user);
        }
    }

    public List<UserEntity> getAccountWithBalance(BalanceRangeDto dto) {
        List<UserEntity> list = new ArrayList<UserEntity>();
        UserEntity isPresent = dynamoDBMapper.load(UserEntity.class, dto.getUserId());
        if(isPresent != null) {
            HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
            eav.put(":currentUserId", new AttributeValue().withS(isPresent.getUserId()));
            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                    .withFilterExpression("userId = :currentUserId")
                    .withExpressionAttributeValues(eav);
            dynamoDBMapper.scan(UserEntity.class, scanExpression).forEach(x -> {

                if(!x.getAccountNo().equals("null")){
                    if(x.getAccountDetails().getBalance() >= dto.getLowerRange() &&
                            x.getAccountDetails().getBalance() <= dto.getUpperRange()
                    ) {
                        System.out.println("x = " + x);
                        list.add(x);
                    }
                }

            });

//            HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
//            eav.put(":currentUserId", new AttributeValue().withS(isPresent.getUserId()));
//            eav.put(":x", new AttributeValue().withS("DPS"));
//
//            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
//                    .withFilterExpression(
//                            "userId = :currentUserId AND begins_with(accountNo, :x)")
//                    .withExpressionAttributeValues(eav);
//
//            dynamoDBMapper.scan(UserEntity.class, scanExpression).forEach(x -> {
//                System.out.println("x = " + x);
//            });
        }
        return list;
    }
}
