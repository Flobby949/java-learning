package top.flobby.java.basic.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 反射解决泛型问题
 * @create : 2021-11-17 15:40
 **/

public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        //list.add(28);  // 不是String,报错 --> 下面通过反射解决这个问题
        Class<?> clazz = list.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(list, 28);
        Object s = list.get(2);
        System.out.println(s instanceof Integer);
        System.out.println("反射很强大"+list);
    }
}
