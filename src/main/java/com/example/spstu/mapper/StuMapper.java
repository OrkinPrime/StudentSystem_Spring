package com.example.spstu.mapper;

import com.example.spstu.model.Class_;
import com.example.spstu.model.Student_Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {

    @Select("select * from class")
    List<Class_> getAllClass();

    @Select("SELECT s.STU_ID, s.STU_NAME, s.STU_NO, c.CLASS_NAME, s.STU_AGE, s.STU_GPA " +
            "FROM student s " +
            "LEFT JOIN class c ON s.CLASS_ID = c.CLASS_ID ")
    List<Student_Class> getAllStudent();

    @Select("<script>" +
            "SELECT s.STU_ID, s.STU_NAME, s.STU_NO, c.CLASS_NAME, s.STU_AGE, s.STU_GPA " +
            "FROM student s " +
            "LEFT JOIN class c ON s.CLASS_ID = c.CLASS_ID " +
            "<where>" +
            " 1=1 "+
            "<if test='stuName != null'>AND s.STU_NAME LIKE CONCAT('%', #{stuName}, '%')</if>" +
            "<if test='stuNo != null'> AND s.STU_NO LIKE CONCAT('%', #{stuNo}, '%')</if>" +
            "<if test='className != null'> AND c.CLASS_NAME LIKE CONCAT('%', #{className}, '%')</if>" +
            "<if test='stuAge != null'> AND s.STU_AGE = #{stuAge}</if>" +
            "<if test='stuGpa != null'> AND s.STU_GPA = #{stuGpa} </if>"+
            "</where>"+
            "</script>"
    )
    List<Student_Class> selectStudentsByConditions(Map<String,Object> conditions);

}
