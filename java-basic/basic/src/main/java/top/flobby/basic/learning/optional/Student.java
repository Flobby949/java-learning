package top.flobby.basic.learning.optional;

import java.util.Optional;

/**
 * @author : Flobby
 * @program : java-basic
 * @description :
 * @create : 2021-11-27 19:13
 **/

public class Student {
    private String name = "ZhangSan";

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        getStudentName(null);
        getStudentNameOptional(null);
    }

    public static void getStudentName(School school) {
        Teacher teacher;
        if (school != null) {
            teacher = school.getTeacher();
        }else {
            teacher = new Teacher();
        }
        Student student;
        if (teacher != null) {
            student = teacher.getStudent();
        }else {
            student = new Student();
        }
        String name = "";
        if (student != null) {
            name = student.getName();
        }else {
            name = "zhangSan";
        }
        System.out.println("普通判空：" + name);
    }

    public static void getStudentNameOptional(School school) {
        Optional<School> schoolOptional = Optional.ofNullable(school);
        String name = schoolOptional
                .map(School::getTeacher)
                .map(Teacher::getStudent)
                .map(Student::getName)
                .orElse("zhangSan");
        System.out.println("Optional判空：" + name);

    }
}
