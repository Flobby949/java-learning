package top.flobby.java.basic.ioex;

import java.io.File;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : file目录遍历
 * @create : 2021-11-16 15:30
 **/

public class ListFile {
    public static void main(String[] args) {
        File dir = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\java\\top\\flobby\\java\\basic\\ioex");
        //获取当前⽬录下的⽂件以及⽂件夹对象，通过⽂件对象可以获取更多信息
        File[] allFiles = dir.listFiles();
        System.out.println("****************** 全部遍历 ******************");
        for (File file : Objects.requireNonNull(allFiles)) {
            System.out.println(file);
        }
        System.out.println("****************** 筛选Java文件 ******************");
        File[] javaFiles = dir.listFiles(file -> {
            //判断如果获取到的是⽬录，直接放⾏
            if (file.isDirectory()) {
                return true;
            }
            //获取路径中的⽂件名，判断是否java结尾，是就返回true
            return file.getName().toLowerCase().endsWith("java");
        });
        //遍历files数组
        for (File file : Objects.requireNonNull(javaFiles)) {
            System.out.println(file);
        }
    }
}
