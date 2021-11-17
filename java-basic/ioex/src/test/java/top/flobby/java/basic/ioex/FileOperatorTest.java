package top.flobby.java.basic.ioex;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class FileOperatorTest {

    @Test
    void isExist() {
        String path = "E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\aaa.txt";
        boolean exist = FileOperator.isExist(path);
        assertTrue(exist);
        System.out.println("***********文件存在***********");
    }

    @Test
    void createDir() {
        String path = "E:\\java-projects\\java-learning\\java-basic\\ioex\\createTest";
        boolean flag = FileOperator.createDir(path);
        assertTrue(flag);
        System.out.println("***********目录创建成功***********");
    }

    @Test
    void createFile() {
        String path = "E:\\java-projects\\java-learning\\java-basic\\ioex\\createTest\\test.txt";
        boolean res = false;
        try {
            res = FileOperator.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(res);
        System.out.println("***********文件创建成功***********");
    }

    @Test
    void getFileInfo() {
        String path = "E:\\java-projects\\java-learning\\java-basic\\ioex\\createTest\\test.txt";
        File file = new File(path);
        Properties fileInfo = FileOperator.getFileInfo(file);
        assertEquals(4, fileInfo.size());
        System.out.println(fileInfo);
    }

    @Test
    void deleteFile() {
        boolean res =
                FileOperator.deleteFile("E:\\java-projects\\java-learning\\java-basic\\ioex\\createTest\\test.txt");
        assertTrue(res);
        System.out.println("***********文件删除成功***********");
    }
}