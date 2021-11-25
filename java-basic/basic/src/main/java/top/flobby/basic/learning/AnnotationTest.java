package top.flobby.basic.learning;

import top.flobby.basic.learning.annotation.Check;
import top.flobby.basic.learning.annotation.Perform;
import top.flobby.basic.learning.annotation.TestAnnotation;
import top.flobby.basic.learning.entity.Hero;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 注解测试
 * @create : 2021-11-25 14:29
 **/
@TestAnnotation(id = 111, msg = "Hello")
public class AnnotationTest {
    @Check("hi")
    int a;

    @Perform
    public void testMethod() {
    }

    @SuppressWarnings("deprecation")
    public void test1() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }

    public static void main(String[] args) {
        boolean hasAnnotation = AnnotationTest.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation testAnnotation = AnnotationTest.class.getAnnotation(TestAnnotation.class);
            // 获取类注解
            System.out.println("id: " + testAnnotation.id());
            System.out.println("msg: " + testAnnotation.msg());
        }
        try {
            Field a = AnnotationTest.class.getDeclaredField("a");
            a.setAccessible(true);
            // 获取一个成员变量上的注解
            Check check = a.getAnnotation(Check.class);
            if (check != null) {
                System.out.println("check value: " + check.value());
            }
            Method method = AnnotationTest.class.getDeclaredMethod("testMethod");
            if (method != null) {
                // 获取方法中的注解
                Annotation[] annotations = method.getAnnotations();
                for (Annotation an :
                        annotations) {
                    System.out.println("Method testMethod annotation: " + an.annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            System.err.println(e.getMessage());
        }
    }
}
