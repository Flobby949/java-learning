package top.flobby.java.basic.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 类名注解
 * @create : 2021-11-17 15:55
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableSu {
    String value();
}
