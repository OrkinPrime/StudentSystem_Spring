package com.example.spstu.service;

import com.example.spstu.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//抽象 service 实现
@Service
public class StuServiceImp implements StuService {
    //后台模拟数据库
    private List<Student> studentList;
    //模拟数据库
    public StuServiceImp() {
        studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "张三", "111", "1"));
        studentList.add(new Student(2, "李四", "222", "2"));
        studentList.add(new Student(3, "王五", "333", "3"));
    }

    @Override
    public Student getStudentById(int stu_id) {
        Student stu = new Student();
        for (Student s : studentList) {
            if (s.getStu_id() == stu_id) {
                stu = s;
            }
        }
        return stu;
    }

    @Override
    public Student addStudent(Student student) {
        Student stu = new Student();
        stu.setStu_id(student.getStu_id());
        stu.setStu_name(student.getStu_name());
        stu.setStu_no(student.getStu_no());
        stu.setClass_id(student.getClass_id());
        studentList.add(stu);
        return stu;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public Student deleteStudentById(int stu_id) {
        Student stu = new Student();
        for (Student s : studentList) {
            if (s.getStu_id() == stu_id) {
                stu = s;
            }
        }
        studentList.remove(stu);
        return stu;
    }

    @Override
    public Student updateStudentById(int stu_id, Student student) {
        Student stu = new Student();
        for (Student s : studentList) {
            if (s.getStu_id() == stu_id) {
                stu = s;
            }
        }
        stu.setStu_id(student.getStu_id());
        stu.setStu_name(student.getStu_name());
        stu.setStu_no(student.getStu_no());
        stu.setClass_id(student.getClass_id());
        return stu;
    }
}
