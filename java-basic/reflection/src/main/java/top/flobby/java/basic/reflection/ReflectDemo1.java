package top.flobby.java.basic.reflection;

import lombok.extern.slf4j.Slf4j;
import top.flobby.java.basic.reflection.entity.User;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 动态创建对象执⾏⽅法
 * @create : 2021-11-15 17:31
 **/

@Slf4j
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取Class对象
        Class<?> clazz = Class.forName("top.flobby.java.basic.reflection.entity.User");
        // 1. 构造一个对象，本质是无参构造器
        User user1 = (User) clazz.getDeclaredConstructor().newInstance();
        
    }
}
