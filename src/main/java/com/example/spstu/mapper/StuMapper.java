package com.example.spstu.mapper;

import com.example.spstu.model.SClass;
import com.example.spstu.model.Student;
import com.example.spstu.model.Student_Class;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {

    //根据ID获取某一个学生的信息
    @Select("select * from student where student.ID=#{stuID}")
    Student getStudentByID(Long stuID);

    //根据ID获取某一个班级的信息
    @Select("select * from sclass where sclass.ID=#{classID}")
    SClass getSClassByID(Long classID);

    //获取所有班级数据
    @Select("select * from sclass")
    List<SClass> getAllClass();

    //增加一条学生信息
    @Insert("INSERT INTO student(stuName, stuNo, classId, age, gpa) VALUES (#{stuName}, #{stuNo}, #{classId}, #{age}, #{gpa})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean addStudent(Student stu);

    //根据ID删除一个学生的信息
    @Delete("delete from student where student.ID=#{stuID}")
    void deleteStudentById(Long stuID);

    //根据ID更新某学生信息
    @Update(
            {
                    "<script>",
                    "UPDATE student ",
                    " <set> ",
                    " <if test='stuName != null'>STUNAME=#{stuName},</if>",
                    " <if test='stuNo!= null'>STUNO = #{stuNo},</if>",
                    " <if test='classId!= null'>CLASSID = #{classId},</if>",
                    " <if test='age!= null'>AGE = #{age},</if>",
                    " <if test='gpa!= null'>GPA = #{gpa},</if>",
                    " </set> ",
                    " WHERE student.ID=#{id} ",
                    "</script>"
            }
    )
    boolean updateStudent(Student student);

    /*
    @Select("SELECT s.ID, s.STUNAME, s.STUNO, c.CLASSNAME, s.AGE, s.GPA " +
            "FROM student s " +
            "LEFT JOIN sclass c ON s.CLASSID = c.ID ")
    List<Student_Class> getAllStudent();

    @Select("<script>" +
            "SELECT s.ID, s.STUNAME, s.STUNO, c.CLASSNAME, s.AGE, s.GPA " +
            "FROM student s " +
            "LEFT JOIN sclass c ON s.CLASSID = c.ID " +
            "<where>" +
            " 1=1 "+
            "<if test='stuName != null'>AND s.STUNAME LIKE CONCAT('%', #{stuName}, '%')</if>" +
            "<if test='stuNo != null'> AND s.STUNO = #{stuNo} </if>" +
            "<if test='className != null'> AND c.CLASSNAME LIKE CONCAT('%', #{className}, '%')</if>" +
            "<if test='stuAge != null'> AND s.AGE = #{stuAge}</if>" +
            "<if test='stuGpa != null'> AND s.GPA = #{stuGpa} </if>"+
            "</where>"+
            "</script>"
    )
    List<Student_Class> selectStudentsByConditions(Map<String,Object> conditions);



    @Update("UPDATE student "+
            "SET " +
            "STUNAME = #{stuName} "+
            "STUNO = #{stuNo}" +
            "CLASSID = #{classId}" +
            "AGE = #{stuAge}" +
            "GPA = #{stuGpa}"
    )
    boolean updateStudent(Student student);*/
}
