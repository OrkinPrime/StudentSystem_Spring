package com.example.spstu.model;

public class Student_Class {
    private Long id;
    private Long stuNo;
    private String stuName;
    private SClass stuClass;
    private Integer age;
    private double gpa;

    public Student_Class() {
    }

    public Student_Class(Long id, String stuName, Long stuNo, SClass stuClass, Integer age, double gpa) {
        this.id = id;
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.stuClass = stuClass;
        this.age = age;
        this.gpa = gpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public SClass getStuClass() {
        return stuClass;
    }

    public void setStuClass(SClass stuClass) {
        this.stuClass = stuClass;
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
