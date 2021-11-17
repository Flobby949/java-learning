package top.flobby.java.basic.reflection.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 实体类
 * @create : 2021-11-15 17:32
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private Integer age;
}
