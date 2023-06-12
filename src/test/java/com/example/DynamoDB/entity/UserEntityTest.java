//package com.example.DynamoDB.entity;
//
//import com.example.DynamoDB.controller.UserController;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Random;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserEntityTest {
//
//    @Autowired
//    private UserController userController;
//
////    @Test
//    void registerUser() {
//
//        int n = 1;
//        for(int i=0;i<n;i++){
//            UserEntity user = new UserEntity();
//            user.setName(getSaltString());
//            user.setEmail(getSaltString() + "@gmail.com");
//            user.setPassword(getSaltString());
////            user.setMobile(generatePhoneNumber());
//
//            userController.register(user);
//        }
//    }
//
//    void addAccount() {
//
//    }
//
//
//    protected String getSaltString() {
//        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
//        StringBuilder salt = new StringBuilder();
//        Random rnd = new Random();
//        while (salt.length() < 10) { // length of the random string.
//            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
//            salt.append(SALTCHARS.charAt(index));
//        }
//        return salt.toString();
//    }
//
//    public static String generatePhoneNumber() {
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder("9"); // Assuming the phone number starts with '9'
//
//        for (int i = 0; i < 10; i++) {
//            int digit = random.nextInt(10);
//            sb.append(digit);
//        }
//
//        return sb.toString();
//    }
//}