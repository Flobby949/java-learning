package top.flobby.basic.learning.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author :Flobby
 * @date :2021/11/25
 * @description :
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    String value();
}
