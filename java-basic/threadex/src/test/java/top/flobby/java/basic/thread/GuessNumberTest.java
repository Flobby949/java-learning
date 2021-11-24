package top.flobby.java.basic.thread;

import static org.junit.jupiter.api.Assertions.*;

class GuessNumberTest {
    public static void main(String[] args) {
        System.out.println("一号竞猜机启动");
        Thread thread1 = new GuessNumber(27);
        thread1.setName("一号竞猜机");
        thread1.start();

        System.out.println("二号竞猜机启动");
        Thread thread2 = new GuessNumber(72);
        thread2.setName("二号竞猜机");
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("主线程结束");
    }
}