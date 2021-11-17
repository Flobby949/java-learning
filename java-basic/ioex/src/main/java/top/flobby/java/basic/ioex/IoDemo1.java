package top.flobby.java.basic.ioex;

import java.io.*;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : IO流Demo练习1
 * @create : 2021-11-16 16:59
 **/

public class IoDemo1 {
    public static void main(String[] args) throws IOException {
        // 使⽤File对象创建流对象
        File file = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\java\\top\\flobby\\java\\basic\\ioex\\test.txt");

        //FileOutputStream fos = new FileOutputStream(file);
        // 使⽤⽂件名称创建流对象
        //FileOutputStream fos = new FileOutputStream("b.txt");

        //readByArray(file);
        fileCopy();
    }

    /**
     * 写出数据
     *
     * @param file 文件
     * @throws IOException IO异常
     */
    public static void writeByte1(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        // 字符串转换为字节数组
        byte[] bytes = "abcdef".getBytes();
        // 写出字节数组数据
        fos.write(bytes);
        // 关闭资源
        fos.close();
    }

    /**
     * 写出数据 - 截取长度
     *
     * @param file 文件
     * @throws IOException IO异常
     */
    public static void writeByte2(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        // 字符串转换为字节数组
        byte[] b = "abcde".getBytes();
        // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b, 2, 2);
        // 关闭资源
        fos.close();
    }

    /**
     * 写出数据 - 追加
     *
     * @param file 文件
     * @throws IOException IO异常
     */
    public static void writeByte3(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, true);
        // 字符串转换为字节数组
        byte[] b = "abcde".getBytes();
        // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b, 2, 2);
        // 关闭资源
        fos.close();
    }

    /**
     * 读取数据 - 循环读取
     * @param file 文件
     * @throws IOException IO异常
     */
    public static void readByte(File file) throws IOException {
        // 使⽤⽂件名称创建流对象
        FileInputStream fis = new FileInputStream(file);
        // 定义变量，保存数据
        int b = 0;
        // 循环读取
        while ((b = fis.read()) != -1) {
            System.out.println((char) b);
        }
        // 关闭资源
        fis.close();
    }

    /**
     * 使用字节数组读取
     * @param file file
     * @throws IOException IO流
     */
    public static void readByArray(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        // 定义变量，作为有效个数
        int len;
        // 定义字节数组，作为装字节数据的容器
        byte[] b = new byte[2];
        // 循环读取
        while ((len = fis.read(b)) != -1) {
            // 每次读取后,把数组变成字符串打印
            // len 每次读取的有效字节个数
            System.out.println(new String(b, 0, len));
        }
        // 关闭资源
        fis.close();
    }

    /**
     * 异常处理
     */
    public static void exceptionHandle() {
        FileOutputStream fos = null;
        try{
            fos.write(100);
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            if(fos!=null) {
                try{
                    fos.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件复制
     * @throws IOException IO异常
     */
    public static void fileCopy() throws IOException {
        // 1.创建流对象
        // 1.1 指定数据源
        FileInputStream fis = new FileInputStream("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\images\\img1.jpeg");
        // 1.2 指定⽬的地
        FileOutputStream fos = new FileOutputStream("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\images\\img1_copy.jpeg");
        // 2.读写数据
        // 2.1 定义数组
        byte[] b = new byte[1024];
        // 2.2 定义⻓度
        int len;
        // 2.3 循环读取
        while ((len = fis.read(b))!=-1) {
            // 2.4 写出数据
            fos.write(b, 0 , len);
        }
        // 3.关闭资源
        fos.close();
        fis.close();
    }
}
