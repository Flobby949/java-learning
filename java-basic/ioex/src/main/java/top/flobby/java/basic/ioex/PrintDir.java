package top.flobby.java.basic.ioex;

import java.io.File;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 目录遍历文件
 * @create : 2021-11-16 15:44
 **/

public class PrintDir {
    public static void main(String[] args) {
        // 创建File对象
        File dir = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src");
        // 调⽤打印⽬录⽅法
        printDirFilterJava(dir);
    }
    public static void printDir(File dir) {
        System.out.println(dir);
        // 获取⼦⽂件和⽬录
        File[] files = dir.listFiles();
        // 循环打印
        for (File file : Objects.requireNonNull(files)) {
            //判断是⽂件，直接输出
            if (file.isFile()) {
                System.out.println(file);
            } else {
                // 是⽬录，继续遍历,形成递归
                printDir(file);
            }
        }
    }

    public static void printDirFilterJava(File dir) {
        // 获取⼦⽂件和⽬录
        File[] files = dir.listFiles(pathname -> {
            if (pathname.isDirectory()) {
                return true;
            }
            return pathname.getName().toLowerCase().endsWith("java");
        });
        // 循环打印
        for (File file : Objects.requireNonNull(files)) {
            if (file.isFile()) {
                System.out.println(file);
            } else {
                // 是⽬录，继续遍历,形成递归
                printDirFilterJava(file);
            }
        }
    }
}
