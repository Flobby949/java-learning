package top.flobby.java.basic.ioex;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 目录遍历搜索图片
 * @create : 2021-11-16 16:01
 **/

public class ListImgFile {
    private static List<File> fileList = new ArrayList<>();
    private static long size;
    private static final double UNIT = 1024.0;

    public static void main(String[] args) {
        //创建File对象
        File dir = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\images");
        //调⽤遍历⽬录的⽅法，得到返回集合
        fileList = listFolder(dir);
        //遍历集合
        fileList.forEach(System.out::println);
        //总数
        System.out.println("⼀共有：" + fileList.size() + "张图⽚");
        //⼤⼩（计算转换为KB、MB、GB等）
        System.out.println("总⼤⼩：" + fileSize(size));

    }

    /**
     * 递归⽅法，遍历指定⽬录，找出所有的图⽚⽂件
     *
     * @param dir ⽬录
     * @return 图⽚⽂件集合
     */
    private static List<File> listFolder(File dir) {
        //使⽤⽂件过滤器过滤图⽚⽂件
        File[] files = dir.listFiles(file -> {
            //是⽬录就放⾏
            if (file.isDirectory()) {
                return true;
            }
            //是图⽚类型⽂件也放⾏
            return isImage(file);
        });
        //遍历files数组
        for (File file : Objects.requireNonNull(files)) {
            //如果file是⽂件
            if (file.isFile()) {
                //将当前file的⻓度累加到size
                size += file.length();
                //将当前⽂件加⼊集合
                fileList.add(file);
            } else {
                //如果file是⽬录，递归遍历
                listFolder(file);
            }
        }
        return fileList;
    }

    /**
     * 判断file是否是图片
     * @param file 文件
     * @return 结果
     */
    private static boolean isImage(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")
                || fileName.endsWith(".png") || fileName.endsWith(".gif")
                || fileName.endsWith(".bmp") || fileName.endsWith(".webp");
    }

    /**
     * 根据字节数换算⽂件⼤⼩
     *
     * @param length 字节数
     * @return String
     */
    private static String fileSize(long length) {
        DecimalFormat df = new DecimalFormat("#.00");
        double res = length / UNIT;
        if (res < 1) {
            return length + "字节";
        } else if (res < UNIT) {
            return df.format(res) + "K";
        } else if (res < UNIT * UNIT) {
            return df.format(res / UNIT) + "M";
        } else {
            return df.format(res / UNIT / UNIT) + "G";
        }
    }
}
