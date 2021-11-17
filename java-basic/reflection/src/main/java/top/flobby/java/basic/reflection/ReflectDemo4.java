package top.flobby.java.basic.reflection;

import top.flobby.java.basic.reflection.annotation.FieldSu;
import top.flobby.java.basic.reflection.annotation.TableSu;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 反射获取注解星系
 * @create : 2021-11-17 15:59
 **/

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("top.flobby.java.basic.reflection.entity.Student");
        // 通过反射获取注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解：" + annotation);
        }

        // 获取注解Value的值
        TableSu tableSu = clazz.getAnnotation(TableSu.class);
        String value = tableSu.value();
        System.out.println("注解的值：" + value);

        //获得指定属性的注解
        Field field = clazz.getDeclaredField("name");
        FieldSu annotation = field.getAnnotation(FieldSu.class);
        System.out.println("name：" + annotation.columnName());
        System.out.println("type：" + annotation.type());
        System.out.println("length：" + annotation.length());
    }
}
