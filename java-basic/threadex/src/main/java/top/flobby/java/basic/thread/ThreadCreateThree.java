package top.flobby.java.basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 线程创建方法3 - 利用FutureTask执行任务
 * @create : 2021-11-23 12:36
 **/

public class ThreadCreateThree implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + "执行了，将会返回100");
        return 100;
    }

    public static void main(String[] args) {
        ThreadCreateThree three = new ThreadCreateThree();
        FutureTask<Integer> futureTask = new FutureTask<>(three);
        Thread thread = new Thread(futureTask, "有返回值的线程");
        thread.start();
        Integer result = null;
        try {
            result = futureTask.get();
            System.out.println("线程返回值： " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.getMessage());
        }
    }
}
