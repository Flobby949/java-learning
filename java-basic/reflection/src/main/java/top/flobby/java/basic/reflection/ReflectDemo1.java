package top.flobby.java.basic.reflection;

import lombok.extern.slf4j.Slf4j;
import top.flobby.java.basic.reflection.entity.User;

import java.io.File;
import java.lang.reflect.*;
import java.util.UUID;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 动态创建对象执⾏⽅法
 * @create : 2021-11-15 17:31
 **/
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获取Class对象
        Class<?> clazz = Class.forName("top.flobby.java.basic.reflection.entity.User");
        // 1. 构造一个对象，本质是无参构造器
        User user1 = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.printf("user1:%s\n", user1);

        // 2.通过构造器创建对象
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, Integer.class);
        User user2 = (User) constructor.newInstance("张三", 1);
        System.out.printf("user2:%s\n", user2);

        // 3.通过反射调用普通方法
        User user3 = (User) clazz.getDeclaredConstructor().newInstance();
        Method setName = clazz.getDeclaredMethod("setUsername", String.class);
        // invoke激活
        setName.invoke(user3, "张三丰");
        System.out.printf("user3.name%s\n", user3.getUsername());

        // 4.通过反射操作属性(即使私有属性也照样可以)
        User user4 = (User) clazz.getDeclaredConstructor().newInstance();
        Field name = clazz.getDeclaredField("username");
        // true 取消Java语言访问检查
        name.setAccessible(true);
        name.set(user4, "张无忌");
        System.out.printf("user4.name%s\n", user4.getUsername());

    }
}
