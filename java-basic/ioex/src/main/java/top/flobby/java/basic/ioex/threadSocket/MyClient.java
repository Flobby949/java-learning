package top.flobby.java.basic.ioex.threadSocket;

import java.io.*;
import java.net.Socket;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 客户端
 * @create : 2021-11-24 22:38
 **/

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10086);
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        OutputStream outputStream = new FileOutputStream("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\java\\top\\flobby\\java\\basic\\ioex\\threadSocket\\download.txt");
        while ((len = in.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
            outputStream.flush();
        }
        System.out.println("下载成功");
    }
}
