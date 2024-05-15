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

    @GetMapping("/api/v1/students")
    public List<Student> getAllStu() {
        return stuService.getAllStudents();
    }

    @GetMapping("api/v1/students/{studentId}")
    public Student getStudentByID(@PathVariable("studentId") int studentId) throws NotFoundException {
        Student student = stuService.getStudentById(studentId);
        if (student == null)
            throw new NotFoundException("The Student ID [" + studentId + "] not found");
        return student;
    }

    @PostMapping("api/v1/students")
    public ResponseEntity addStudent(@RequestBody Student student) {
        Student stu = stuService.addStudent(student);
        return new ResponseEntity(stu, HttpStatus.OK);
    }

    @PutMapping("api/v1/students/{studentId}/update")
    public ResponseEntity updateStudentByID(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        Student stu = stuService.updateStudentById(studentId, student);
        return new ResponseEntity(stu, HttpStatus.OK);
    }

    @PutMapping("api/v1/students/{studentId}/delete")
    public ResponseEntity deleteStudentByID(@PathVariable("studentId") int studentId) {
        Student stu = stuService.deleteStudentById(studentId);
        return new ResponseEntity(stu, HttpStatus.OK);
    }
}
