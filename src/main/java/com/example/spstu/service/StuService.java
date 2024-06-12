package com.example.spstu.service;

import com.example.spstu.model.SClass;
import com.example.spstu.model.Student;

import java.util.List;
import java.util.Map;

//抽象 service 接口
public interface StuService {
    //获取全部班级信息
    List<SClass> getAllClasses();

    //根据ID获取某一个班级的信息
    SClass getClassById(Long id);

    //根据ID获取某一个学生的信息
    Student getStudentById(Long id);

    //增加一条学生信息
    boolean addStudent(Student stu);

    //根据ID删除一个学生的信息
    void deleteStudent(Long id);

    //根据ID更新某学生信息
    boolean updateStudent(Long stuID, Map<String, Object> updateFields);

    //动态条件排序查询学生信息
    List<Student> findStudents(Integer stuNo, String stuName, Integer classId, Integer age, Double gpa,
                               Integer startPage, Integer pageSize, String orderBy);
}
