package top.flobby.basic.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 序列化用户实体
 * @create : 2021-11-22 11:40
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSerializable implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private transient String password;
}
