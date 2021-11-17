package top.flobby.java.basic.ioex;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 文件综合操作
 * @create : 2021-11-16 14:27
 **/

public class FileOperator {
    /**
     * 判断文件是否存在
     * @param pathname 路径
     * @return 结果
     */
    public static boolean isExist(String pathname) {
        File file = new File(pathname);
        return file.exists();
    }

    /**
     * 创建目录
     * @param pathname 路径
     * @return 结果
     */
    public static boolean createDir(String pathname) {
        File file = new File(pathname);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return false;
    }

    /**
     * 创建文件
     * @param pathname 路径
     * @return 结果
     * @throws IOException IO异常
     */
    public static boolean createFile(String pathname) throws IOException {
        File file = new File(pathname);
        if (!file.exists()) {
            return file.createNewFile();
        }
        return false;
    }

    /**
     * 获取文件信息
     * @param file 文件
     * @return 文件信息对象
     */
    public static Properties getFileInfo(File file) {
        String fileName = file.getName();
        String filePath = file.getPath();
        String parentDir = file.getParent();
        long fileLength = file.length();
        Properties properties = new Properties();
        properties.setProperty("fileName", fileName);
        properties.setProperty("filePath", filePath);
        properties.setProperty("parentDir", parentDir);
        properties.setProperty("fileLength", String.valueOf(fileLength));
        return properties;
    }

    /**
     * 删除文件
     * @param pathname 路径
     * @return 结果
     */
    public static boolean deleteFile(String pathname) {
        File file = new File(pathname);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}
