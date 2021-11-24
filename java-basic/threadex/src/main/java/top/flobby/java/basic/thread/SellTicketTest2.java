package top.flobby.java.basic.thread;

/**
 * @author : Flobby
 * @program : java-basic
 * @description :
 * @create : 2021-11-23 16:05
 **/

public class SellTicketTest2 {
    public static void main(String[] args) {
        TicketWindow3 ticketWindow2 = new TicketWindow3();
        for (int i = 1; i <= 3; i++) {
            Thread t = new Thread(ticketWindow2, "窗口" + i);
            t.start();
        }
    }
}

class TicketWindow3 implements Runnable {
    private static int ticket = 30;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，当前剩余票数为：" + --ticket);
                }else {
                    System.out.println(Thread.currentThread().getName() + "余票不足，无法售票");
                    break;
                }
            }
        }
    }
}
