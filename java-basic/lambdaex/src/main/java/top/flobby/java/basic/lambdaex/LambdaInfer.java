package top.flobby.java.basic.lambdaex;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : lambda推导
 * @create : 2021-11-27 18:53
 **/

public class LambdaInfer {
    public static void main(String[] args) {
        IStudent student = new IStudent() {
            @Override
            public void study(String technology, int time) {
                System.out.println("匿名内部类，" + technology + time);
            }
        };
        student.study("java", 8);

        // lambda表达式改造，将类名和方法名去掉
        IStudent student1 = (String technology, int time) -> {
            System.out.println("lambda表达式，" + technology + time);
        };
        student1.study("java", 9);
        // 一级进化(去掉数据类型)
        IStudent student2 = (technology, time) -> {
            System.out.println("一级进化，" + technology + time);
        };
        student2.study("java", 10);

        //二级进化(简化括号)
        IStudent student3 = (((technology, time) -> System.out.println("二级进化，" + technology + time)));
        student3.study("java", 11);
    }
}

interface IStudent{
    /**
     * study方法
     * @param technology 入参
     * @param time 入参
     */
    void study(String technology, int time);
}
