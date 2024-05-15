package com.example.spstu.service;

import com.example.spstu.model.Student;

import java.util.List;

public interface StuService {
    Student getStudentById(int stu_id);

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student deleteStudentById(int stu_id);

    Student updateStudentById(int stu_id, Student student);
}
