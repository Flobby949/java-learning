package top.flobby.java.basic.ioex;

import java.io.File;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : File类构造方法
 * @create : 2021-11-15 18:07
 **/

public class FileConstructor {
    public static void main(String[] args) {
        // 文件路径名
        String pathname = "E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\aaa.txt";
        File file1 = new File(pathname);
        System.out.println(file1);
        // 通过父路径和子路径字符串
        String parent = "E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources";
        String child1 = "aaa.txt";
        File file2 = new File(parent, child1);
        System.out.println(file2);
        // 通过⽗级File对象和⼦路径字符串
        File parentDir = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources");
        String child2 = "aaa.txt";
        File file3 = new File(parentDir, child2);
        System.out.println(file3);
    }
}
