package top.flobby.java.basic.thread;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 线程状态学习
 * @create : 2021-11-23 13:20
 **/

public class ThreadStateExample {
    private static final Object WAITER = new Object();
    private static final Object LOCKER = new Object();
    private static boolean flag = true;
    private static final boolean LOCK_FLAG = true;

    public static void main(String[] args) {
        terminatedExample();
    }

    /**
     * NEW - 新创建
     */
    public static void newExample() {
        Runnable waiting1 = () -> {
            try {
                WAITER.wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        };
        Thread whoWillWait = new Thread(waiting1);
        System.out.println("线程当前状态" + whoWillWait.getState());
    }

    /**
     * RUNNABLE - 可运行
     */
    public static void runnableExample() {
        Runnable waiting2 = () -> {
            // 让程序空转，保持线程是runnable状态
            do {

            } while (flag);
        };
        Thread thread = new Thread(waiting2);
        thread.start();
        try {
            // 主线程先休眠1秒，让子线程跑起来，然后输出线程状态
            Thread.sleep(1000);
            System.out.println(thread.getState());
            // 更改标志位，让子线程结束循环
            flag = false;
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.exit(1);
    }

    /**
     * BLOCKED - 被阻塞
     */
    public static void blockedExample() {
        Runnable locker = ThreadStateExample::locker;
        Thread whoWillLockOthers = new Thread(locker);
        /*
         * 启动whoWillLockOthers线程，主线程休眠一秒让子线程先运行
         * 此时whoWillLockOthers获得锁，这时候其他线程需要等待
         */
        whoWillLockOthers.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        Thread whoWillBeLocked = new Thread(locker);
        /*
         * 启动whoWillBeLocked线程，主线程休眠1秒让子线程先运行
         * 因为locker方法是个死循环，所以whoWillBeLocked永远拿不到锁，就会进入BLOCKED状态
         */
        whoWillBeLocked.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("whoWillBeLocked线程的当前状态为：" + whoWillBeLocked.getState());
        System.exit(1);
    }

    private static synchronized void locker() {
        do {

        } while (LOCK_FLAG);
    }

    /**
     * WAITING - 等待
     */
    public static void waitExample() {
        Runnable waiting = () -> {
            System.out.println("whoWillWait 开始等待 whoWillNotify");
            waiting();
            System.out.println("whoWillWait 等到了 whoWillNotify 的通知");
        };
        // 创建一个线程调用waiter.wait()方法，让whoWillWait线程进入waiting状态
        Thread whoWillWait = new Thread(waiting);
        whoWillWait.start();
        // 主线程休眠1秒，让whoWillWait先执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("whoWillWait 当前状态：" + whoWillWait.getState());

        Runnable notify = () -> {
            System.out.println("whoWillNotify 准备通知 whoWillWait");
            notifying();
        };
        // 创建一个线程调用notify方法，唤醒whoWillWait
        Thread whoWillNotify = new Thread(notify);
        whoWillNotify.start();
        // 主线程休眠2秒，whoWillNotify先执行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("唤醒后，whoWillWait 当前状态：" + whoWillWait.getState());
        System.exit(1);
    }

    private static void notifying() {
        synchronized (LOCKER) {
            LOCKER.notify();
            System.out.println("whoWillNotify已通知，即将离开同步代码块");
        }
    }

    private static void waiting() {
        synchronized (LOCKER) {
            try {
                LOCKER.wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * TIMED_WAITING  -  计时等待
     */
    public static void timedWaiting() {
        Runnable waiting = () -> {
            System.out.println("whoWillWait 开始等待 1秒钟");
            waitingTime();
            System.out.println("whoWillWait 等待结束");
        };
        // 创建一个线程调用waiter.wait()方法，让whoWillWait线程进入waiting状态
        Thread whoWillWait = new Thread(waiting);
        whoWillWait.start();
        // 主线程休眠1秒，让whoWillWait先执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("whoWillWait 当前状态：" + whoWillWait.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("whoWillWait 当前状态：" + whoWillWait.getState());
        System.exit(1);
    }

    private static void waitingTime() {
        synchronized (LOCKER) {
            try {
                LOCKER.wait(1500);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * TERMINATED - 被终止
     */
    public static void terminatedExample() {
        Runnable waiting = () -> {
            System.out.println("随便执行一下，然后线程就会变成Terminated");
        };
        Thread terminate = new Thread(waiting);
        terminate.start();
        // 主线程先休眠1秒，让terminate先执行，线程执行完毕就结束了
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("terminate当前状态：" + terminate.getState());
        System.exit(1);
    }
}
