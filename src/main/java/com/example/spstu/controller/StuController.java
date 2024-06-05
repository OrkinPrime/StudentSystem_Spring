package com.example.spstu.controller;

import com.example.spstu.model.Class_;
import com.example.spstu.model.Student_Class;
import com.example.spstu.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    //班级信息——全部查询
    @GetMapping("api/v2/class")
    public List<Class_> getAllClass() {
        return stuService.getAllClasses();
    }


    //学生信息——条件查询及全部查询
    /*
    指令：/api/v2/students
    效果：查询全部学生信息（连接班级）

    指令： /api/v2/students?name=李
    效果：查询全部学生信息（连接班级），条件为名字中带“李”
    [其他指令及其效果以此类推]
    */
    @GetMapping("/api/v2/students")
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
}
