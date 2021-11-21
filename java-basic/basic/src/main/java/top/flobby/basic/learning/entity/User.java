package top.flobby.basic.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : java-basic
 * @description :
 * @create : 2021-11-21 14:28
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private Integer age;
}
