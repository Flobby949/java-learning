package top.flobby.java.basic.reflection.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.flobby.java.basic.reflection.annotation.FieldSu;
import top.flobby.java.basic.reflection.annotation.TableSu;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 使用自定义注解的类
 * @create : 2021-11-17 15:57
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableSu("t_student")
public class Student {
    @FieldSu(columnName = "user_id", type = "int", length = 10)
    private int id;
    @FieldSu(columnName = "user_name", type = "varchar2", length = 10)
    private String name;
    @FieldSu(columnName = "user_age", type = "int", length = 10)
    private int age;
}