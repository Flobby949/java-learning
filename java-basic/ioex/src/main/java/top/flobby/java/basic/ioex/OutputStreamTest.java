package top.flobby.java.basic.ioex;

import java.io.*;
import java.util.Arrays;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 字节流/字符流 写操作
 * @create : 2021-11-24 09:33
 **/

public class OutputStreamTest {
    private static final String FILE_PATH = "fileWrite.txt";
    private static final String OUT_PATH = "testNew.txt";
    private static final String CHINESE_OUT_PATH = "testCh.txt";
    private static final String LOG_PATH = "log.txt";

    public static void main(String[] args) throws FileNotFoundException {
        log("日志消息测试", true, true);
    }

    /**
     * 字节流写操作
     */
    private static void outputStreamTest() {
        FileOutputStream fos = null;
        try {
            File file = new File(OUT_PATH);
            byte[] buffer = getBytes();
            fos = new FileOutputStream(file);
            fos.write(buffer);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * 读取文本字节
     * @return 字节数组
     */
    private static byte[] getBytes() {
        InputStream fis = null;
        int len = 512;
        byte[] buffer = new byte[len];
        try {
            fis = new FileInputStream(FILE_PATH);
            while (fis.read(buffer, 0, len) != -1) {
                System.out.print(Arrays.toString(buffer));
            }
            System.out.println();
            for (byte b : buffer) {
                if (Character.isLetterOrDigit((char) b) || (char) b == '\n') {
                    System.out.print((char) b);
                }
            }
        } catch (IOException e) {
            return new byte[1];
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return buffer;
    }

    /**
     * 字符流写操作
     */
    private static void fileWriter() {
        Reader fr = null;
        Writer fw = null;
        try {
            //先读
            fr = new FileReader(FILE_PATH);
            StringBuilder sb = new StringBuilder();
            int read;
            while ((read = fr.read()) != -1) {
                System.out.print((char) read);
                sb.append((char) read);
            }
            //再写
            File file = new File(CHINESE_OUT_PATH);
            fw = new FileWriter(file);
            fw.write(sb.toString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * 日志输出
     * @param msg  带输出信息
     * @param wrap 是否换行
     * @param out  是否输出
     */
    private static void log(Object msg, boolean wrap, boolean out) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(LOG_PATH));
        if (out) {
            if (wrap) {
                System.out.println(msg + "");
                pw.println(msg + "");
            } else {
                System.out.print(msg + "");
                pw.print(msg + "");
            }
        }
        pw.close();
    }
}
