//package com.example.DynamoDB.controller;
//
//import com.example.DynamoDB.entity.Department;
//import com.example.DynamoDB.entity.StudentEntity;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class StudentControllerTest {
//
//    @Autowired
//    private StudentController studentController;
//
//
//    @Test
//    void addStudents() {
//        int n = 1000;
//        for(int i=0;i<n;i++){
//            StudentEntity student = new StudentEntity();
//            student.setStudentId(String.valueOf(i+1));
//            student.setFirstName("name_"+String.valueOf(i));
//            if(i%2 == 0) student.setLastName("last_"+String.valueOf(i));
//            Department department = new Department();
//            department.setDepartmentCode(String.valueOf(i%3));
//            department.setDepartmentName("dept_"+String.valueOf(i));
//            student.setDepartment(department);
//            StudentEntity response = studentController.addNewStudent(student);
////            System.out.println("response = " + response);
//        }
//    }
//}