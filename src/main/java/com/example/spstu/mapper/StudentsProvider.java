package com.example.spstu.mapper;

import org.apache.ibatis.jdbc.SQL;

//动态语句生成
public class StudentsProvider {
    public String selectStudents(
            Integer stuNo,
            String stuName,
            Integer classId,
            Integer age,
            Double gpa,
            Integer startPage,
            Integer pageSize,
            String orderBy
    ) {
        return new SQL() {{
            SELECT("id, stuNo, stuName, classId, age, gpa");
            FROM("student");

            if (stuNo != null) {
                WHERE("stuNo = #{stuNo}");
            }
            if (stuName != null && !stuName.isEmpty()) {
                WHERE("stuName LIKE concat('%', #{stuName}, '%')");
            }
            if (classId != null) {
                WHERE("classId = #{classId}");
            }
            if (age != null) {
                WHERE("age = #{age}");
            }
            if (gpa != null) {
                WHERE("gpa > #{gpa}");
            }

            // 分页
            if (startPage != null && pageSize != null) {
                OFFSET((startPage - 1) * pageSize);
                LIMIT(pageSize);
            }

            // 排序
            if (orderBy != null && !orderBy.isEmpty()) {
                String[] orderByArray = orderBy.split(",");
                for (String orderByField : orderByArray) {
                    orderByField = orderByField.trim();
                    switch (orderByField) {
                        case "stuNo desc":
                            ORDER_BY("stuNo DESC");
                            break;
                        case "stuName":
                            ORDER_BY("stuName");
                            break;
                        case "stuName desc":
                            ORDER_BY("stuName DESC");
                            break;
                        case "age":
                            ORDER_BY("age");
                            break;
                        case "age desc":
                            ORDER_BY("age DESC");
                            break;
                        case "gpa":
                            ORDER_BY("gpa");
                            break;
                        case "gpa desc":
                            ORDER_BY("gpa DESC");
                            break;
                        default:
                            ORDER_BY("stuNo");
                            break;
                    }
                }
            }
        }}.toString();
    }
}
