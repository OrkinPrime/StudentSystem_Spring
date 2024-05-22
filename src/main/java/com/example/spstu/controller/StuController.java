package com.example.spstu.controller;

import com.example.spstu.model.Student;
import com.example.spstu.service.StuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StuController {
    private final StuService stuService;

    //注入Service
    public StuController(StuService studentService) {
        this.stuService = studentService;
    }
    //查询全部
    @GetMapping("/api/v1/students")
    public List<Student> getAllStu() {
        return stuService.getAllStudents();
    }
    //增加
    @PostMapping("api/v1/students")
    public ResponseEntity addStudent(@RequestBody Student student) {
        Student stu = stuService.addStudent(student);
        return new ResponseEntity(stu, HttpStatus.CREATED);
    }
    //查询
    @GetMapping("api/v1/students/{studentId}")
    public Student getStudentByID(@PathVariable("studentId") int studentId) {
        Student student = stuService.getStudentById(studentId);
        //抛错无法生效
        if (student == null)
            throw new NotFoundException("The Student ID [" + studentId + "] not found");
        return student;
    }
    //更改
    @PutMapping("api/v1/students/{studentId}")
    public ResponseEntity updateStudentByID(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        Student stu = stuService.updateStudentById(studentId, student);
        return new ResponseEntity(stu, HttpStatus.OK);
    }
    //删除
    @DeleteMapping("api/v1/students/{studentId}")
    public ResponseEntity deleteStudentByID(@PathVariable("studentId") int studentId) {
        Student stu = stuService.deleteStudentById(studentId);
        return new ResponseEntity(stu, HttpStatus.OK);
    }
}
