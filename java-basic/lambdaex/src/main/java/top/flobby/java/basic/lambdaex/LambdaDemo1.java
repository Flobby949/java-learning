package top.flobby.java.basic.lambdaex;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : Lambda表达式替代匿名内部类
 * @create : 2021-11-17 18:54
 **/

public class LambdaDemo1 {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
    }

    /**
     * 无参数，无返回值
     */
    public static void demo1() {
        // 原匿名内部类写法
        /**
         * Runnable runnable = new Runnable() {
         *     @Override
         *     public void run() {
         *         System.out.println("Lambda表达式，线程启动");
         *     }
         * }).start();
         */
        Runnable runnable = () -> System.out.println("无参无返回值Lambda表达式，线程启动");
        runnable.run();
    }

    /**
     * 一个参数，无返回值
     */
    public static void demo2() {
        Consumer<String> consumer = e -> System.out.println("一个参无返回值Lambda表达式，" + e);
        consumer.accept("传入参数");
    }

    /**
     * 有两个以上的参数，有返回值
     */
    public static void demo3() {
        // lambda表达式中多条语句用 {}
        Comparator<Integer> comparator = (x, y) -> {
            System.out.print("两个参，带返回值的Lambda表达式\t");
            return Integer.compare(x, y);
        };
        int compare = comparator.compare(100, 200);
        System.out.println("有两个以上的参数，有返回值," + compare);
    }

    /**
     * 若 Lambda 体中只有一条语句， return 和 大括号可省略不写
     * 方法引用
     */
    public static void demo4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        // ::方法引用简化Lambda表达式
        //Comparator<Integer> comparator = Integer::compare;
        System.out.println("若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写," + comparator.compare(200, 100));
    }

}
