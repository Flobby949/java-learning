package top.flobby.basic.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 字符串
 * @create : 2021-11-22 09:54
 **/

public class StringExercise {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    /**
     * string类型转换
     */
    public static void exchangeText() {
        Object a = 0;
        if (a instanceof String) {
            // 使用(string) 强制转换时，最好使用instanceof做一个类型检查
            String strA = (String) a;
            System.out.println(strA);
        } else {
            System.out.println("error");
        }

        // 包装类有toString方法
        // 基本数据类型没有toString()方法，推荐使用String.valueOf()方法
        Integer b = 1;
        String bStr = b.toString();
        System.out.println(bStr);
    }

    /**
     * null值转换
     */
    public static void nullExchange() {
        Integer a = null;
        // String.valueOf
        String b = String.valueOf(a);
        System.out.println(b);
        System.out.println(b == null);
        System.out.println("null".equals(b));

        // 强制转换
        Object o = null;
        String c = (String) o;
        System.out.println(c);

        // toString，空指针异常
        String d = a.toString();
        System.out.println(d);
    }

    /**
     * 字符串拼接
     */
    public static void stringAppend() {
        int i = 10;
        String s = "松山院";
        System.out.println(s + i);
    }

    private static void test01() {
        String str = "松山院,";
        String ret = "";
        System.out.println("+字符串拼接开始...");
        long start = System.currentTimeMillis();
        // + 在循环中的效率太低，用10万条测试吧
        for (int i = 0; i < 100000; i++) {
            ret += str;
        }
        long end = System.currentTimeMillis();
        System.out.println("+号拼接10万条数据耗时：" + (end - start) + "ms");
        System.out.println("************");
    }

    private static void test02() {
        String str = "松山院,";
        StringBuilder builder = new StringBuilder();
        System.out.println("StringBuilder,字符串拼接开始...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            builder.append(str);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder拼接1000万条数据耗时：" + (end - start) + "ms");
        System.out.println("************");
    }

    private static void test03() {
        String str = "松山院,";
        StringBuffer buffer = new StringBuffer();
        System.out.println("StringBuffer,字符串拼接开始...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            buffer.append(str);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer拼接1000万条数据耗时：" + (end - start) + "ms");
        System.out.println("************");
    }

    /**
     * StringJoiner的效率明显高于List + StringJoiner
     */
    private static void test04() {
        String str = "松山院";
        StringJoiner join = new StringJoiner(",");
        System.out.println("StringJoiner,字符串拼接开始...");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            join.add(str);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringJoiner拼接1000万条数据耗时：" + (end - start) + "ms");
        System.out.println("************");
    }

    private static void test05() {
        String str = "松山院";
        List<String> list = new ArrayList<String>();
        System.out.println("List + StringJoiner,字符串拼接开始...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(str);
        }
        String ret = String.join(",", list);
        long end = System.currentTimeMillis();
        //563ms,477ms,585ms
        System.out.println("List + StringJoiner拼接1000万条数据耗时：" + (end - start) + "ms");
        System.out.println("************");
    }
}
