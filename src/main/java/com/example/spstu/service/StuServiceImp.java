package com.example.spstu.service;

import com.example.spstu.model.SClass;
import com.example.spstu.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.spstu.mapper.*;

//抽象 service 实现
@Service
public class StuServiceImp implements StuService {
    //注入mapper
    private final StuMapper stuMapper;

    //构造函数中注入mapper
    @Autowired
    public StuServiceImp(StuMapper stuMapper) {
        this.stuMapper = stuMapper;
    }

    //获取所有班级数据
    @Override
    public List<SClass> getAllClasses() {
        return stuMapper.getAllClass();
    }

    //根据ID获取某一个班级的信息
    @Override
    public SClass getClassById(Long id) {
        return stuMapper.getSClassByID(id);
    }

    //根据ID获取某一个学生的信息
    @Override
    public Student getStudentById(Long id) {
        Student stu = stuMapper.getStudentByID(id);
        return stu;
    }

    //增加一条学生信息
    @Override
    public boolean addStudent(Student stu) {
        return stuMapper.addStudent(stu);
    }

    //根据ID删除一个学生的信息
    @Override
    public void deleteStudent(Long id) {
        stuMapper.deleteStudentById(id);
    }

    //根据ID更新某学生信息
    @Override
    public boolean updateStudent(Long stuID, Map<String, Object> updateFields) {
        Student stuObj = new Student(stuID, (Long) updateFields.get("classId"), (String) updateFields.get("stuName"), (Long) updateFields.get("stuNo"), (Integer) updateFields.get("age"), (Double) updateFields.get("gpa"));
        return stuMapper.updateStudent(stuObj);
    }

    //动态条件排序查询学生信息
    @Override
    public List<Student> findStudents(Integer stuNo, String stuName, Integer classId, Integer age, Double gpa,
                                      Integer startPage, Integer pageSize, String orderBy) {
        return stuMapper.dynamicConditionStudents(stuNo, stuName, classId, age, gpa, startPage, pageSize, orderBy);
    }
}
