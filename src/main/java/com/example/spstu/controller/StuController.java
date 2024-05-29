package com.example.spstu.controller;

import com.example.spstu.model.Student;
import com.example.spstu.service.StuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
    public ResponseEntity addStudent(@RequestBody Student stuClass) {
        Student stu = stuService.addStudent(stuClass);
        return new ResponseEntity(stu, HttpStatus.CREATED);
    }
    //查询
/*    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Stu_Class ID Not Found")
    @RequestMapping(value="api/v1/students/{studentId}", method=GET)
    @ResponseBody*/
    @GetMapping("api/v1/students/{studentId}")
    public Student getStudentByID(@PathVariable("studentId") int studentId) {
        Student stuClass = stuService.getStudentById(studentId);
        //抛错无法生效
        if (stuClass == null)
            throw new NotFoundException("The Stu_Class ID [" + studentId + "] not found");
        return stuClass;
    }


    //更改-put
    @PutMapping("api/v1/students/{studentId}")
    public ResponseEntity updateStudentByID(@PathVariable("studentId") int studentId, @RequestBody Student stuClass) {
        Student stu = stuService.updateStudentById(studentId, stuClass);
        return new ResponseEntity(stu, HttpStatus.OK);
    }

/*
    //更改-patch
    //未完成
    @PutMapping("api/v1/students/{studentId}")
    public Stu_Class updateStudentByID(@PathVariable("studentId") int studentId, @RequestBody Map<String, Objects> updateFields) {
        Stu_Class stu = stuService.updateStudentByIdp(studentId, updateFields);
        return new ResponseEntity(stu, HttpStatus.OK);
    }*/
    //删除
    @DeleteMapping("api/v1/students/{studentId}")
    public ResponseEntity deleteStudentByID(@PathVariable("studentId") int studentId) {
        Student stu = stuService.deleteStudentById(studentId);
        return new ResponseEntity(stu, HttpStatus.OK);
    }
}
