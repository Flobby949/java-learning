package top.flobby.java.basic.ioex;

import java.io.File;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 文件判断方法
 * @create : 2021-11-16 14:22
 **/

public class FileJudgeMethods {
    public static void main(String[] args) {
        File f = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\aaa.txt");
        File f2 = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources");
        // 判断是否存在
        System.out.println("aaa.txt 是否存在: " +
                f.exists());
        System.out.println("resources目录是否存在: " + f2.exists());
        // 判断是⽂件还是⽬录
        System.out.println("E:/java-projects/java-learning/java-basic/ioex/src/main/resources是⽂件?: " +
                f2.isFile());
        System.out.println("E:/java-projects/java-learning/java-basic/ioex/src/main/resources是⽬录?: " +
                f2.isDirectory());
    }
}
