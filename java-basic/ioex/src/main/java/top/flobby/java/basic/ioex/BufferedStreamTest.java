package top.flobby.java.basic.ioex;

import java.io.*;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 字节缓冲流
 * @create : 2021-11-16 17:35
 **/

public class BufferedStreamTest {
    public static void main(String[] args) throws IOException {
        bufferStream();
    }

    /**
     * 基础流复制大文件（155MB - 1245040ms - )
     * @throws IOException IO异常
     */
    private static void baseStream() throws IOException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        FileInputStream fis = new FileInputStream("E:\\download\\jdk-17_windows-x64_bin.exe");
        FileOutputStream fos = new FileOutputStream("E:\\download\\copy.exe");
        // 读写数据
        int b = 0;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:" + (end - start) + " 毫秒");
    }

    /**
     * 缓冲流复制大文件（155MB - 2813ms)
     * @throws IOException IO异常
     */
    private static void bufferStream() throws IOException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream("E:\\download\\jdk-17_windows-x64_bin.exe"));
        BufferedOutputStream bos = new BufferedOutputStream(new
                FileOutputStream("E:\\download\\copy.exe"));
        // 读写数据
        int b = 0;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流复制时间:" + (end - start) + " 毫秒");
    }

    /**
     * 缓冲流使⽤数组复制大文件（155MB - 309ms)
     * @throws IOException IO异常
     */
    private static void bufferAndArrayStream() throws IOException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream("E:\\download\\jdk-17_windows-x64_bin.exe"));
        BufferedOutputStream bos = new BufferedOutputStream(new
                FileOutputStream("E:\\download\\copy.exe"));
        // 读写数据
        int len = 0;
        byte[] bytes = new byte[8 * 1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流使⽤数组复制时间:" + (end - start) + " 毫秒");
    }
}
