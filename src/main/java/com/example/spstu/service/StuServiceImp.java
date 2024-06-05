package com.example.spstu.service;

import com.example.spstu.model.SClass;
import com.example.spstu.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    /*    @Override
    public List<Student_Class> getAllStudents() {
        return stuMapper.getAllStudent();
    }

    @Override
    public List<Student_Class> selectStudentsByConditions(Map<String, Object> conditions) {
        return stuMapper.selectStudentsByConditions(conditions);
    }

    @Override
    public void deleteStudentByID(Long stuID) {
        stuMapper.deleteStudentById(stuID);
    }

    @Override
    public Student updateStudent(Long stuId, Map<String, Object> updates) {
        Student student = stuMapper.getStudentByID(stuId);
        for (Map.Entry<String, Object> entry  : updates.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {
                case "stuNo":
                    if (value.getClass() == String.class)
                        student.setStu_no(Integer.parseInt((String)value));
                    else
                        student.setStu_no((Integer) value);
                    break;
                case "stuName":
                    student.setStuName((String)value);
                    break;
                case "classId":
                    student.setStuName((String)value);
                    break;
                case "stuAge":
                    if (value.getClass() == String.class)
                        student.setAge(Integer.parseInt((String)value));
                    else
                        student.setAge((Integer) value);
                    break;
                case "stuGpa":
                    if (value.getClass() == String.class)
                        student.setGpa(Double.parseDouble((String) value));
                    else
                        student.setGpa((Double) value);
                    break;
            }
        }
        return null;
    }
*/
}
