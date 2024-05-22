package com.example.spstu.service;

import com.example.spstu.model.Student;

import java.util.List;
//抽象 service 接口
public interface StuService {
    Student getStudentById(int stu_id);

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student deleteStudentById(int stu_id);

    Student updateStudentById(int stu_id, Student student);
}
