package com.example.spstu.model;

public class Class_ {
    private Integer class_id;
    private String class_name;
    private String class_department;

    public Class_() {
    }

    public Class_(int class_id, String class_name, String class_department) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.class_department = class_department;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setClass_department(String class_department) {
        this.class_department = class_department;
    }

    public int getClass_id() {
        return class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getClass_department() {
        return class_department;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + class_id +
                ", name='" + class_name + '\'' +
                ", department='" + class_department + '\'' +
                '}';

    }
}
