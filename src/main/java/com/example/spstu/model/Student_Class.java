package com.example.spstu.model;

public class Student_Class {
    private int stu_id;
    private String stu_name;
    private String stu_no;
    private String class_name;
    private Integer stu_age;
    private float stu_gpa;

    public Student_Class() {
    }

    public Student_Class(int stu_id, String stu_name, String stu_no, String class_name, Integer stu_age, float stu_gpa) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_no = stu_no;
        this.stu_age = stu_age;
        this.stu_gpa = stu_gpa;
        this.class_name = class_name;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public Integer getStu_age() {
        return stu_age;
    }

    public void setStu_age(Integer stu_age) {
        this.stu_age = stu_age;
    }

    public float getStu_gpa() {
        return stu_gpa;
    }

    public void setStu_gpa(float stu_gpa) {
        this.stu_gpa = stu_gpa;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
