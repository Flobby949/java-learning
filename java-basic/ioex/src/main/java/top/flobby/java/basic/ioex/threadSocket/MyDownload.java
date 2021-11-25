package top.flobby.java.basic.ioex.threadSocket;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 服务端线程
 * @create : 2021-11-24 22:33
 **/

public class MyDownload implements Runnable{
    private Socket socket;

    public MyDownload(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("与客户端连接成功");
            // 服务端向客户端发送消息
            OutputStream out = socket.getOutputStream();
            File file = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\java\\top\\flobby\\java\\basic\\ioex\\threadSocket\\socket.txt");
            // 将文件从硬盘中读到内存中
            InputStream in = new FileInputStream(file);
            // 定义每次发送文件大小
            byte[] bytes = new byte[1000];
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
