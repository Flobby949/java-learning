package top.flobby.java.basic.reflection;

import top.flobby.java.basic.reflection.entity.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 通过反射获取泛型信息
 * @create : 2021-11-17 15:14
 **/

public class ReflectDemo2 {
    public void method1(Map<String, User> map, List<User> list) {
        System.out.println("Method1");
    }

    public Map<String, User> method2() {
        System.out.println("Method2");
        return null;
    }

    public static void main(String[] args) throws Exception {
        // 通过反射获取方法参数信息
        System.out.println("*********************** 获取泛型 ***********************");
        Method method = ReflectDemo2.class.getMethod("method1", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("泛型参数类型：" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("实际类型：" + actualTypeArgument);
                }
            }
        }
        // 通过反射获取方法返回值
        System.out.println("*********************** 获取返回值 ***********************");
        method = ReflectDemo2.class.getMethod("method2", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("实际参数类型：" + actualTypeArgument);
            }
        }
    }
}
