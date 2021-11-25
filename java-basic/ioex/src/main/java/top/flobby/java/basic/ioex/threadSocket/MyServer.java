package top.flobby.java.basic.ioex.threadSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 服务端
 * @create : 2021-11-24 22:33
 **/

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10086);
        while (true) {
            Socket socket = server.accept();
            MyDownload download = new MyDownload(socket);
            Thread thread = new Thread(download);
            thread.start();
        }
    }
}
