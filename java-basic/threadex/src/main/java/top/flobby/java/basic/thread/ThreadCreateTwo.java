package top.flobby.java.basic.thread;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 线程创建方法2 - 任务和线程分开
 * @create : 2021-11-23 12:31
 **/

public class ThreadCreateTwo implements Runnable {
    private final String threadName;

    public ThreadCreateTwo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating: " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Creating: " + threadName);
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Creating: " + threadName + "," + i);

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.err.println("Thread:" + threadName + "  exited");
    }

    public static void main(String[] args) {
        ThreadCreateTwo two = new ThreadCreateTwo("hello");
        Thread thread1 = new Thread(two);
        Thread thread2 = new Thread(two);
        Thread thread3 = new Thread(two);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
