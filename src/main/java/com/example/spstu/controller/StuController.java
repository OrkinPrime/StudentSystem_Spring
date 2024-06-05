package com.example.spstu.controller;

import com.example.spstu.model.SClass;
import com.example.spstu.model.Student;
import com.example.spstu.model.Student_Class;
import com.example.spstu.service.StuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
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

    //获取某一个学生的组合信息
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

    //根据ID更新某学生信息(未完成)
    @PatchMapping("api/v1/students/{stuID}")
    public Student_Class updateStudentById(@PathVariable Long stuID, @RequestBody Student_Class student) {
        return student;
    }
    //获取所有学生或根据条件查询学生数据（未完成）

    /*
    //学生信息——条件查询及全部查询

    //    指令：/api/v1/students
    //    效果：查询全部学生信息（连接班级）
    //
    //    指令： /api/v1/students?name=李
    //    效果：查询全部学生信息（连接班级），条件为名字中带“李”
    //    [其他指令及其效果以此类推]

    @GetMapping("/api/v1/students")
    public List<Student_Class> listStudents(
            @RequestParam(value = "no", required = false) String stuNo,
            @RequestParam(value = "name", required = false ) String stuName,
            @RequestParam(value = "class", required = false ) String className,
            @RequestParam(value = "age", required = false) String stuAge,
            @RequestParam(value = "gpa", required = false) String stuGpa ) {

        if (stuNo==null && stuName==null && className==null && stuAge==null && stuGpa==null)
            return stuService.getAllStudents();
        else {
            Map<String, Object> cnds = new HashMap<>();
            if (stuNo != null)
                cnds.put("stuNo", stuNo);
            if (stuName != null)
                cnds.put("stuName", stuName);
            if (className != null)
                cnds.put("className", className);
            if (stuAge != null)
                cnds.put("stuAge", stuAge);
            if (stuGpa != null)
                cnds.put("stuGpa", stuGpa);
            return stuService.selectStudentsByConditions(cnds);
        }
    }
    @DeleteMapping("/api/v1/students/{stuID}")
    public ResponseEntity deleteStudent(@PathVariable("stuID") Long stuID) {
        Student student = stuService.getStudentById(stuID);
        if (student == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        stuService.deleteStudentByID(stuID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/api/v2/students/{stuID}")
    public ResponseEntity updateStudent(@PathVariable("stuID") Long stuID, @RequestBody Map<String, Object> updateFields) {
        Student student = stuService.getStudentById(stuID);
        if (student == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        stuService.updateStudent(stuID,updateFields);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
