package com.example.spstu.controller;

import com.example.spstu.model.SClass;
import com.example.spstu.model.Student;
import com.example.spstu.model.Student_Class;
import com.example.spstu.service.StuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class StuController {
    //注入Service
    private final StuService stuService;

    public StuController(StuService studentService) {
        this.stuService = studentService;
    }

    //获取全部班级的信息
    @GetMapping("api/v1/classes")
    public List<SClass> getAllClass() {
        return stuService.getAllClasses();
    }

    //根据ID获取某一个班级的信息
    @GetMapping("api/v1/classes/{classId}")
    public SClass getClassById(@PathVariable Long classId) {
        return stuService.getClassById(classId);
    }

    //根据ID获取一个学生的信息
    @GetMapping("api/v1/student/{stuID}")
    public Student getStudent(@PathVariable Long stuID) {
        return stuService.getStudentById(stuID);
    }

    //根据ID获取某一个学生的组合信息
    @GetMapping("api/v1/students/{stuID}")
    public Student_Class getStudentById(@PathVariable Long stuID) {
        Student stu = stuService.getStudentById(stuID);
        if (stu == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        SClass sclass = stuService.getClassById(stu.getClassId());
        if (sclass == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Student_Class sc = new Student_Class(stu.getId(), stu.getStuName(), stu.getStuNo(), sclass, stu.getAge(), stu.getGpa());

        return sc;
    }

    //增加一条学生信息
    @PostMapping("/api/v1/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        if (stuService.addStudent(student)) {
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //根据ID删除一个学生的信息
    @DeleteMapping("api/v1/students/{stuID}")
    public ResponseEntity deleteStudentById(@PathVariable Long stuID) {
        stuService.deleteStudent(stuID);
        return new ResponseEntity(HttpStatus.OK);
    }

    //根据ID更新某学生信息
    @PatchMapping("api/v1/students/{stuID}")
    public Student_Class updateStudentById(@PathVariable Long stuID, @RequestBody Map<String, Object> updateFields) {
        if (stuService.updateStudent(stuID, updateFields)) {
            Student stu = stuService.getStudentById(stuID);
            SClass sclass = stuService.getClassById(stu.getClassId());
            Student_Class sc = new Student_Class(stu.getId(), stu.getStuName(), stu.getStuNo(), sclass, stu.getAge(), stu.getGpa());
            return sc;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //动态条件排序查询学生组合信息
    @GetMapping("api/v1/students")
    public List<Student_Class> findAndOrderStudents(@RequestParam(required = false) Integer stuNo,
                                                    @RequestParam(required = false) String stuName,
                                                    @RequestParam(required = false) Integer classId,
                                                    @RequestParam(required = false) Integer age,
                                                    @RequestParam(required = false) Double gpa,
                                                    @RequestParam(defaultValue = "1") Integer startPage,
                                                    @RequestParam(defaultValue = "100") Integer pageSize,
                                                    @RequestParam(defaultValue = "stuNo") String orderBy
    ) {
        List<Student> studentList = stuService.findStudents(stuNo, stuName, classId, age, gpa, startPage, pageSize, orderBy);
        List<Student_Class> ScList = new ArrayList<>();
        for (Student stu : studentList) {
            SClass sclass = stuService.getClassById(stu.getClassId());
            Student_Class sc = new Student_Class(stu.getId(), stu.getStuName(), stu.getStuNo(), sclass, stu.getAge(), stu.getGpa());
            ScList.add(sc);
        }
        return ScList;
    }
}
