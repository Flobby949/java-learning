package top.flobby.java.basic.ioex;

import top.flobby.java.basic.ioex.entity.Employee;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : Io学习2
 * @create : 2021-11-17 11:06
 **/

public class IoDemo2 {
    public static void main(String[] args) throws Exception {
        serializableInput();
    }

    /**
     * 使⽤平台的默认字符集将此 String编码为字节序列
     * GBK字符集汉字占 2 个字节
     * UTF-8字符集汉字占 3 个字节
     */
    public static void stringToBytes() throws UnsupportedEncodingException {
        // 默认字符集
        byte[] bytes = "你".getBytes();
        System.out.println(Arrays.toString(bytes));
        // 指定字符集
        byte[] utf8Byte = "你".getBytes("UTF-8");
        System.out.println(Arrays.toString(utf8Byte));
        byte[] gbkBytes = "你".getBytes("GBK");
        System.out.println(Arrays.toString(gbkBytes));
        byte[] utf16Bytes = "你".getBytes(StandardCharsets.UTF_16LE);
        System.out.println(Arrays.toString(utf16Bytes));
    }

    /**
     * 转换流输出流 OutputStreamWriter 写入数据
     */
    public static void writeText() throws IOException {
        // 创建流对象,默认UTF8编码
        OutputStreamWriter osw = new OutputStreamWriter(new
                FileOutputStream("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\java\\top\\flobby\\java\\basic\\ioex\\test.txt"));
        // 写数据,保存为6个字节
        osw.write("你好");
        osw.flush();
        osw.close();

        // 指定GBK编码
        OutputStreamWriter oswGbk = new OutputStreamWriter(new
                FileOutputStream("gbkTest.txt") , "GBK");
        // 写数据,保存为4个字节
        oswGbk.write("你好");
        oswGbk.flush();
        oswGbk.close();
    }

    /**
     * 转换输入流 InputStreamReader 读取数据
     */
    public static void readText() throws IOException {
        // 定义需要读取的⽂件路径,该⽂件采⽤了gbk编码
        String fileName = "gbkTest.txt";
        // 创建流对象,默认UTF8编码
        InputStreamReader isrUtf8 = new InputStreamReader(new
                FileInputStream(fileName));
        // 创建流对象,指定GBK编码
        InputStreamReader isrGbk = new InputStreamReader(new
                FileInputStream(fileName), "GBK");
        // 定义变量,保存字符
        int read;
        System.out.println("\n**********使⽤默认编码读取************\n");
        // 使⽤默认编码字符流读取,乱码
        while ((read = isrUtf8.read()) != -1) {
            System.out.print((char) read);
        }
        isrUtf8.close();
        System.out.println("\n**********使⽤GBK编码读取************\n");
        // 使⽤指定编码字符流读取,正常解析
        while ((read = isrGbk.read()) != -1) {
            System.out.print((char) read);
        }
        isrGbk.close();
    }

    /**
     * 文件写入
     * 要使⽤flush()⽅法，否则数据在内存中，不会到达指定⽂件，close()⽅法在关闭前也会进⾏刷新，推荐写⼀次刷新⼀次，避免内存占⽤过多。
     */
    public static void fileWrite() throws IOException {
        // 使⽤⽂件名称创建流对象
        FileWriter fw = new FileWriter("fileWrite.txt");
        //写出单个字符
        fw.write(97);
        fw.flush();
        //写出字符数组
        char[] chs = "ABCDED".toCharArray();
        fw.write(chs);
        fw.flush();
        //写出字符数组的⼀部分，开始索引，写出个数
        fw.write(chs, 1, 3);
        fw.flush();
        //写出字符串
        fw.write("Java⼯程师");
        fw.flush();
        fw.close();
    }

    /**
     * 文件读取
     */
    public static void fileReader() throws IOException {
        // 使⽤⽂件名称创建流对象，读取的源⽂件read.txt在项⽬根⽬录下
        FileReader fr = new FileReader("fileWrite.txt");
        // 定义变量，保存有效字符个数
        int len;
        // 定义字符数组，作为装字符数据的容器
        char[] buf = new char[2];
        // 循环读取
        while ((len = fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
        // 关闭资源
        fr.close();
    }

    /**
     * FileWrite newLine() 换行符
     */
    public static void writeNewLine() throws IOException {
        // 创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("fileWrite.txt"));
        // 写出数据
        bw.write("Java");
        // 写出换⾏
        bw.newLine();
        bw.write("程序");
        bw.newLine();
        bw.write("员");
        bw.newLine();
        // 释放资源
        bw.close();
    }

    /**
     * FileWrite readLine() 读取文本行
     */
    public static void readTxtByLine() throws IOException {
        // 创建流对象
        BufferedReader br = new BufferedReader(new FileReader("fileWrite.txt"));
        // 定义字符串,保存读取的⼀⾏⽂字
        String line = null;
        // 循环读取,读取到最后返回null
        while ((line = br.readLine())!=null) {
            System.out.print(line);
            System.out.println("------");
        }
        // 释放资源
        br.close();
    }

    /**
     * 文本练习
     * 将in.txt中的文本读取后排序，写入到out.txt
     */
    public static void textExercise() throws IOException {
        // 1.创建ArrayList集合,泛型使⽤String
        ArrayList<String> textList = new ArrayList<>();
        // 2.创建BufferedReader对象
        BufferedReader br = new BufferedReader(new FileReader("E:\\java-projects\\java-learning\\java-basic\\textExercise\\in.txt"));
        // 3.创建BufferedWriter对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\java-projects\\java-learning\\java-basic\\textExercise\\out.txt"));
        // 定义字符串,保存读取的⼀⾏⽂字
        String line = null;
        // 4.循环读取,存入ArrayList,读取到最后返回null
        while ((line = br.readLine())!=null) {
            textList.add(line);
        }
        // 释放BufferedReader资源
        br.close();
        // 5.使⽤Collections集合⼯具类中的⽅法sort,对集合中的元素按照⾃定义规则排序
        textList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //依次⽐较集合中两个元素的⾸字⺟,升序排序
                return o1.charAt(0) - o2.charAt(0);
            }
        });
        // 6.遍历排序后的list,使⽤BufferedWriter对象中的⽅法write,把遍历得到的元素写⼊到⽂本中(内存缓冲区中)
        for (String text : textList) {
            bw.write(text);
            bw.newLine();
            bw.flush();
        }
        // 释放BufferedWrite资源
        bw.close();
    }

    /**
     * 打印流
     * 打印流输出数据是原样输出，打印97，结果看到就是97，⽽不是a。
     */
    public static void print() throws IOException {
        // 创建打印流,输出⽬的是字节输出流
        PrintWriter pw = new PrintWriter(new FileOutputStream("a.txt"),true);
        pw.println(97);
        //创建打印流,输出⽬的是字符
        PrintWriter pw1 = new PrintWriter(new FileWriter("b.txt"),true);
        pw1.println(97);
        pw.close();
        pw1.close();
    }

    /**
     * 序列化
     */
    public static void serializableOutput() {
        Employee e = new Employee();
        e.name = "zhangsan";
        e.address = "jiangsu";
        e.age = 20;
        e.eid = 80;
        try {
            // 创建序列化流对象
            ObjectOutputStream out = new ObjectOutputStream(new
                    FileOutputStream("employee.txt"));
            // 写出对象
            out.writeObject(e);
            // 释放资源
            out.close();
            System.out.println("Serialized data is saved");
            // 姓名，地址被序列化，年龄没有被序列化。
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    public static void serializableInput() {
        Employee e;
        try {
            // 创建反序列化流
            FileInputStream fileIn = new FileInputStream("employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // 读取⼀个对象
            e = (Employee) in.readObject();
            // 释放资源
            in.close();
            fileIn.close();
        } catch (IOException i) {
            // 捕获其他异常
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            // 捕获类找不到异常
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        // ⽆异常,直接打印输出
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("age: " + e.age);
        System.out.println("eid: " + e.eid);
    }
}
