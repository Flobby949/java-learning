package top.flobby.java.basic.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 属性注解
 * @create : 2021-11-17 15:57
 **/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldSu {
    String columnName();
    String type();
    int length();
}
