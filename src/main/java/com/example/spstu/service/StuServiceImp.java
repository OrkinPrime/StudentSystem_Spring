package com.example.spstu.service;

import com.example.spstu.model.Class_;
import com.example.spstu.model.Student_Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.example.spstu.mapper.*;

//抽象 service 实现
@Service
public class StuServiceImp implements StuService {
    //注入mapper
    private final StuMapper StuMapper;
    //构造函数中注入mapper
    @Autowired
    public StuServiceImp(StuMapper stuMapper) {
        this.StuMapper = stuMapper;
    }

    @Override
    public List<Class_> getAllClasses() {
        return StuMapper.getAllClass();
    }

    @Override
    public List<Student_Class> getAllStudents() {
        return StuMapper.getAllStudent();
    }

    @Override
    public List<Student_Class> selectStudentsByConditions(Map<String, Object> conditions) {
        return StuMapper.selectStudentsByConditions(conditions);
    }

}
