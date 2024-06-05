package com.example.spstu.model;

public class SClass {
    private Long id;
    private String className;
    private String department;

    public SClass() {
    }

    public SClass(Long id, String className, String department) {
        this.id = id;
        this.className = className;
        this.department = department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + className + '\'' +
                ", department='" + department + '\'' +
                '}';

    }
}
