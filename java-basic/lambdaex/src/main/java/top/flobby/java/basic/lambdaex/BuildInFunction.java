package top.flobby.java.basic.lambdaex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : Java8四大内置函数式接口
 * @create : 2021-11-17 20:26
 **/

public class BuildInFunction {

    public static void main(String[] args) {
        consumerAccept();

        getNumList(10, () -> (int) (Math.random() * 100));

        strHandler("abc", (str) -> str.toUpperCase());
        strHandler("  abc  ", (str) -> str.trim());

        List<String> list = Arrays.asList("hello", "jiangshuying", "lambda", "www", "ok", "q");
        filterStr(list, (str) -> str.length() > 2);
    }

    /**
     * 消费型接口
     */
    public static void consumerAccept() {
        Consumer<String> consumer = e -> System.out.println("一个参无返回值Lambda表达式，" + e);
        consumer.accept("传入参数");
    }

    /**
     * 供给型接口  get()
     *
     * @param num      集合长度
     * @param supplier 元素值
     */
    public static void getNumList(int num, Supplier<Integer> supplier) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer e = supplier.get();
            list.add(e);
        }
        System.out.println(list);
    }

    /**
     * 函数型接口 apply()
     *
     * @param str 字符串
     * @param fun 字符串方法
     */
    public static void strHandler(String str, Function<String, String> fun) {
        System.out.println(fun.apply(str));
    }

    /**
     * 断言型接口 test()
     *
     * @param list 集合
     * @param pre  断言方法
     */
    public static void filterStr(List<String> list, Predicate<String> pre) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                arrayList.add(str);
            }
        }
        System.out.println(arrayList);
    }


}
