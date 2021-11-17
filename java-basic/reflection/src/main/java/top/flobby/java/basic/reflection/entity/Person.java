package top.flobby.java.basic.reflection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 实体类
 * @create : 2021-11-17 16:11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;

    public static void getPerson() {
        System.out.println("I am a person.");
    }
}
