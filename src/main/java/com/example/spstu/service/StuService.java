package com.example.spstu.service;

import com.example.spstu.model.SClass;
import com.example.spstu.model.Student;

import java.util.List;

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
    /*    List<Student_Class> getAllStudents();
    List<Student_Class> selectStudentsByConditions(Map<String,Object> conditions);
    void deleteStudentByID(Long stuID);
    Student updateStudent(Long stuId, Map<String, Object> updates);*/
}
