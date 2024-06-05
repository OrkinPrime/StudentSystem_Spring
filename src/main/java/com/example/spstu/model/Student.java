package com.example.spstu.model;

public class Student {
    private Long id;
    private Long classId;
    private String stuName;
    private Long stuNo;
    private Integer age;
    private double gpa;

    public Student() {
    }
    public Student(Long id, Long classId, String stuName, Long stuNo, Integer age, double gpa) {
        this.id = id;
        this.classId = classId;
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.age = age;
        this.gpa = gpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Long getStuNo() {
        return stuNo;
    }

    public void setStuNo(Long stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
