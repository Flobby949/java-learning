package top.flobby.java.basic.ioex;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : File类学习
 * @create : 2021-11-17 12:43
 **/

public class FileExercise {

    /**
     * 文件创建方法
     */
    public static void createFile() {
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

    /**
     * 文件/目录方法
     */
    public static void fileMethods() {
        File f = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\aaa.txt");
        System.out.println("⽂件绝对路径:" + f.getAbsolutePath());
        System.out.println("⽂件构造路径:" + f.getPath());
        System.out.println("⽂件名称:" + f.getName());
        System.out.println("⽂件⻓度:" + f.length() + "字节");
        System.out.println("⽂件路径的⽗路径" + f.getParentFile());
        System.out.println("");
        File f2 = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources");
        System.out.println("⽬录绝对路径:" + f2.getAbsolutePath());
        System.out.println("⽬录构造路径:" + f2.getPath());
        System.out.println("⽬录名称:" + f2.getName());
        System.out.println("⽬录⻓度:" + f2.length());
        System.out.println("⽬录⽗路径" + f2.getParentFile());
    }

    /**
     * 文件/目录 创建&是否存在&删除
     */
    public static void createDelete() throws IOException {
        // ⽂件的创建
        File f = new File("aaa.txt");
        System.out.println("是否存在:" + f.exists());
        System.out.println("是否创建:" + f.createNewFile());
        System.out.println("是否存在:" + f.exists());
        // ⽬录的创建
        File f2 = new File("newDir");
        System.out.println("是否存在:" + f2.exists());
        System.out.println("是否创建:" + f2.mkdirs());
        System.out.println("是否存在:" + f2.exists());
        // ⽂件的删除
        System.out.println(f.delete());
        // ⽬录的删除
        System.out.println(f2.delete());
    }

    /**
     * 判断文件目录是否存在
     */
    public static void judgeMethods() {
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

    /**
     * 文件路径
     */
    public static void filePath() {
        // 绝对路径aaa.txt
        File f = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\aaa.txt");
        System.out.println(f.getAbsolutePath());
        // 项⽬下的FileGetMethods.java⽂件
        File f2 = new File("FileGetMethods.java");
        System.out.println(f2.getAbsolutePath());
    }

    /**
     * 获取目录下文件
     */
    public static void fileList() {
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

    /**
     * 目录遍历方法调用 - 递归
     */
    public static void dirTraversal() {
        File dir = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src");
        printDir(dir);
        System.out.println("****************** 筛选Java文件 ******************");
        printDirFilterJava(dir);
    }

    /**
     * 遍历目录下所有文件和文件夹
     * @param dir dir
     */
    private static void printDir(File dir) {
        // 创建File对象
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

    /**
     * 遍历目录下所有java文件
     * @param dir dir
     */
    private static void printDirFilterJava(File dir) {
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
