package top.flobby.java.basic.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 线程创建方法1 - 将任务和线程合并在一起
 * @create : 2021-11-23 12:22
 **/

public class ThreadCreateOne extends Thread{
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Running" + Thread.currentThread().getName());
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(df.format(new Date()));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Thread:" + Thread.currentThread().getName() + "exited");
    }

    public static void main(String[] args) {
        new ThreadCreateOne().start();
        System.out.println("Running" + Thread.currentThread().getName());
    }
}
