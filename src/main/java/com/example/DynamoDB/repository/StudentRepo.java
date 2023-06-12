//package com.example.DynamoDB.repository;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.example.DynamoDB.entity.StudentEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class StudentRepo {
//
//    @Autowired
//    private DynamoDBMapper dynamodbMapper;
//    public StudentEntity save(StudentEntity student) {
//        dynamodbMapper.save(student);
//        return student;
//    }
//}
