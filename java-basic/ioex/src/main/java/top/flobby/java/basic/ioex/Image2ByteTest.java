package top.flobby.java.basic.ioex;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 图片和字节数组互转
 * @create : 2021-11-24 22:45
 **/

public class Image2ByteTest {
    public static void main(String[] args) {
        String path = "E:\\java-projects\\java-learning\\java-basic\\1.jpg";
        byte[] bytes = image2Byte(path);
        System.out.println(Arrays.toString(bytes));
        String path2 = "E:\\java-projects\\java-learning\\java-basic\\2.jpg";
        byte2Image(bytes, path2);
        String s = byte2String(bytes);
        System.out.println(s);
    }

    /**
     * 图片到Byte数组
     *
     * @param path 图片路径
     * @return 字节数组
     */
    public static byte[] image2Byte(String path) {
        byte[] data = null;
        FileImageInputStream inputStream;
        try {
            inputStream = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead;
            while ((numBytesRead = inputStream.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            inputStream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }

    /**
     * byte数组到图片
     *
     * @param data 字节数组
     * @param path 路径
     */
    public static void byte2Image(byte[] data, String path) {
        if (data.length < 3 || "".equals(path)) {
            return;
        }
        try {
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * byte数组转成到16进制字符串
     * @param data 字节数组
     * @return string
     */
    public static String byte2String(byte[] data) {
        if (data == null || data.length <= 1) {
            return "0x";
        }
        if (data.length > 200000) {
            return "0x";
        }
        StringBuilder sb = new StringBuilder();
        int[] buf = new int[data.length];
        // byte数组转换成十进制
        for (int k = 0; k < data.length; k++) {
            buf[k] = data[k] < 0 ? (data[k] + 256) : (data[k]);
        }
        // byte数组转换成十六进制
        for (int i : buf) {
            if (i < 16) {
                sb.append("0").append(Integer.toHexString(i));
            } else {
                sb.append(Integer.toHexString(i));
            }
        }
        return "0x" + sb.toString().toUpperCase();
    }
}
