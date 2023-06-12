//package com.example.DynamoDB.controller;
//
//import com.example.DynamoDB.entity.StudentEntity;
//import com.example.DynamoDB.repository.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class StudentController {
//    @Autowired
//    private StudentRepo studentRepo;
//
//    @PostMapping("/add-student")
//    public StudentEntity addNewStudent(@RequestBody StudentEntity student){
////        System.out.println("student = " + student);
//        return studentRepo.save(student);
//    }
//}
