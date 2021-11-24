package top.flobby.java.basic.thread;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 继承Thread类方式 & 实现Runnable方式
 * @create : 2021-11-23 15:52
 **/

public class SoldTicketTest {
    public static void main(String[] args) {
        /**
         * Thread方法实现多线程
         * 车票数量没有共享，售出90张票，添加static字段使数据共享
         */
        TicketWindow1 ticketWindow1 = new TicketWindow1();
        for (int i = 1; i <= 3; i++) {
            Thread t = new Thread(ticketWindow1, "窗口" + i);
            t.start();
        }

        /**
         * Runnable方法实现多线程
         * 不需要static字段也可以共享数据，开发推荐使用runnable
         */
        TicketWindow2 ticketWindow2 = new TicketWindow2();
        for (int i = 1; i <= 3; i++) {
            Thread t = new Thread(ticketWindow2, "窗口" + i);
            t.start();
        }
    }

}

class TicketWindow1 extends Thread {
    /**
     * 车票数量
     */
    private static int ticket = 30;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出一张票，当前剩余票数为：" + --ticket);
            }else {
                System.out.println(Thread.currentThread().getName() + "余票不足，无法售票");
                break;
            }
        }
    }
}

class TicketWindow2 implements Runnable {
    /**
     * 车票数量
     */
    private int ticket = 30;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出一张票，当前剩余票数为：" + --ticket);
            }else {
                System.out.println(Thread.currentThread().getName() + "余票不足，无法售票");
                break;
            }
        }
    }
}