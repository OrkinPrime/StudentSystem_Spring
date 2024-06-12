package com.example.spstu.mapper;

import com.example.spstu.model.SClass;
import com.example.spstu.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    //动态条件排序查询学生信息
    @SelectProvider(type = StudentsProvider.class, method = "selectStudents")
    List<Student> dynamicConditionStudents(
            @Param("stuNo") Integer stuNo,
            @Param("stuName") String stuName,
            @Param("classId") Integer classId,
            @Param("age") Integer age,
            @Param("gpa") Double gpa,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize,
            @Param("orderBy") String orderBy
    );
}
