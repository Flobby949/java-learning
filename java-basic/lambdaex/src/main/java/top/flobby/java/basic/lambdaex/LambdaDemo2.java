package top.flobby.java.basic.lambdaex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 常见用法
 * @create : 2021-11-18 16:56
 **/

public class LambdaDemo2 {

    public static void main(String[] args) {
        listIteration();
        mapAndReduce();
        dataFilter();

        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        predicateFilter(languages, x -> x.startsWith("J"));
        predicateFilter(languages, x -> x.endsWith("a"));
        predicateFilter(languages, x -> true);
        predicateFilter(languages, x -> false);
        predicateFilter(languages, x -> x.length() > 4);
    }

    /**
     * 简单遍历集合数组
     */
    public static void listIteration() {
        System.out.println("");
        List<String> list = Arrays.asList("java", "c#", "javascript");
        list.forEach(x -> System.out.print(x));
    }

    /**
     * lambda结合map()方法 & reduce()方法
     * map()的作用是将一个对象变换为另外一个
     * reduce()实现的则是将所有值合并为一个
     */
    public static void mapAndReduce() {
        System.out.println("");
        List<Double> list = Arrays.asList(10.0, 20.0, 40.0);
        double sum2 = list.stream()
                .map(x -> x + x * 0.05)
                .reduce((sum1, x) -> sum1 + x)
                .get();
        System.out.print(sum2);
    }

    /**
     * 数据过滤
     */
    public static void dataFilter() {
        System.out.println("");
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        List<Double> filteredCost = cost.stream()
                .filter(x -> x > 25.0)
                .collect(Collectors.toList());
        filteredCost.forEach(System.out::print);
    }

    /**
     * 与函数式接口Predicate配合
     *
     * @param languages list
     * @param condition 断言方法
     */
    public static void predicateFilter(List<String> languages, Predicate<String> condition) {
        System.out.println("");
        languages.stream().filter(x ->
                condition.test(x)
        ).forEach(x ->
                System.out.print(x + "\t")
        );
    }
}
