package com.example.spstu.service;

import com.example.spstu.model.Class_;
import com.example.spstu.model.Student_Class;

import java.util.List;
import java.util.Map;

//抽象 service 接口
public interface StuService {
    List<Class_> getAllClasses();
    List<Student_Class> getAllStudents();
    List<Student_Class> selectStudentsByConditions(Map<String,Object> conditions);
}
