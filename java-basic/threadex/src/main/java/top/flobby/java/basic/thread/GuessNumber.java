package top.flobby.java.basic.thread;

import java.util.Random;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 猜数字
 * @create : 2021-11-23 15:35
 **/

public class GuessNumber extends Thread{
    private final int number;


    public GuessNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int count = 0;
        int guess;
        Random random = new Random();
        do {
            guess = random.nextInt(100);
            System.out.println(this.getName() + " guess: " + guess);
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (guess != number);
        System.out.println(this.getName() + "猜对了，猜了" + count + "次");
    }
}
