package com.example.DynamoDB.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class UserDetails {

    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private String email;
    @DynamoDBAttribute
    private String password;
    @DynamoDBAttribute
    private String mobileNumber;

    @DynamoDBAttribute
    private ArrayList<String> listOfAccount = new ArrayList<>();
}
