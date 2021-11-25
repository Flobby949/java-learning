package top.flobby.basic.learning.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-basic
 * @description :
 * @create : 2021-11-25 14:39
 **/

public class Hero {
    @Deprecated
    public void say() {
        System.out.println("nothing has to say!");
    }

    public void speak() {
        System.out.println("i have a dream!");
    }

    public void addItems(String item) {
        List<String> items = new ArrayList<>();
        items.add(item);
        System.out.println("i am " + items);
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.addItems("Java工程师");
        hero.say();
        hero.speak();
    }
}
