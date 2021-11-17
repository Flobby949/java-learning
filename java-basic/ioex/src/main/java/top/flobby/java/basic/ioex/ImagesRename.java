package top.flobby.java.basic.ioex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 图片文件重命名
 * @create : 2021-11-16 16:09
 **/

public class ImagesRename {
    private static final String PREFIX = "img";
    private static Integer fileNumber = 1;

    public static void main(String[] args) {
        File dir = new File("E:\\java-projects\\java-learning\\java-basic\\ioex\\src\\main\\resources\\images");
        List<File> fileList = listFolder(dir);
        fileList.forEach(file -> {
            String originName = file.getName();
            boolean flag = renameImage(file);
            if (!flag) {
                System.out.println("图片 " + originName + " 重命名失败");
            }
            fileNumber++;
        });
    }

    /**
     * 重命名
     * @param file 文件
     * @return 结果
     */
    private static boolean renameImage(File file) {
        String fileName = file.getName();
        String path = file.getParentFile().toString();
        //分割文件名，获取文件后缀名
        String[] fileNameArr = fileName.split("\\.");
        String suffix = fileNameArr[fileNameArr.length - 1];
        //拼接新得到的新上传文件名
        String newFileName = PREFIX + fileNumber.toString() + "." + suffix;
        return file.renameTo(new File(path + "/" +newFileName));
    }

    /**
     * 递归⽅法，遍历指定⽬录，找出所有的图⽚⽂件
     *
     * @param dir ⽬录
     * @return 图⽚⽂件集合
     */
    private static List<File> listFolder(File dir) {
        List<File> fileList = new ArrayList<>();
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
            if (file.isFile()) {
                fileList.add(file);
            }else {
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
}
