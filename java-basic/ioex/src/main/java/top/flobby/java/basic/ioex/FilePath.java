package top.flobby.java.basic.ioex;

import java.io.File;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 文件路径学习
 * @create : 2021-11-16 14:20
 **/

public class FilePath {
    public static void main(String[] args) {
        // 绝对路径aaa.txt
        File f = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\aaa.txt");
        System.out.println(f.getAbsolutePath());
        // 项⽬下的FileGetMethods.java⽂件
        File f2 = new File("FileGetMethods.java");
        System.out.println(f2.getAbsolutePath());
    }
}
