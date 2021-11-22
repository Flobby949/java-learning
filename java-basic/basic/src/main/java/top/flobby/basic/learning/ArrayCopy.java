package top.flobby.basic.learning;

import top.flobby.basic.learning.entity.User;

import java.util.Arrays;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 数据拷贝
 * @create : 2021-11-21 12:57
 **/

public class ArrayCopy {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println("****************1*****************");
        copySelf();
        System.out.println("****************2*****************");
        copyToOther();
        System.out.println("****************3*****************");
        getStringArrayFromObjectArray();
        System.out.println("****************4*****************");
        multiDimensionalArrayCopy();
        System.out.println("****************5*****************");
        beanArrayCopy();
        System.out.println("****************6*****************");
        cloneTest1();
        System.out.println("****************7*****************");
        cloneTest2();
    }

    public static void copySelf() {
        int[] ids = {1, 2, 3, 4, 5};
        System.out.println("*****原数组*****");
        System.out.println(Arrays.toString(ids));
        // 把索引0开始的2个数字复制到索引为3的位置上
        System.arraycopy(ids, 0, ids, 3, 2);
        System.out.println("*****复制后*****");
        System.out.println(Arrays.toString(ids));
    }

    public static void copyToOther() {
        int[] ids = {1, 2, 3, 4, 5};
        int[] other = new int[5];
        System.out.println("*****原数组*****");
        System.out.println(Arrays.toString(ids));
        // 把索引1开始的2个数字复制到目标数组索引为0的位置上
        System.arraycopy(ids, 1, other, 0, 3);
        System.out.println("*****复制后*****");
        System.out.println(Arrays.toString(other));
    }

    /**
     * 获取Object数组中的字符串类型数据
     * 简单点来说，就是假设B复制了A，当修改A时，如果B也跟着变了，说明这是浅拷贝，如果B没变，那就是深拷贝
     */
    private static void getStringArrayFromObjectArray() {
        Object[] obj3 = {1, 2, 3, "4", "5"};
        String[] obj4 = new String[5];
        try {
            System.arraycopy(obj3, 3, obj4, 3, 2);
        } catch (Exception e) {
            System.out.println("transfer exception:" + e);
        }
        System.out.println(Arrays.toString(obj3));
        //[null, null, null, 4, 5]
        System.out.println(Arrays.toString(obj4));
        obj3[3] = "ZhangSan";
        System.out.println("查看是浅复制还是深复制~~~");
        System.out.println(Arrays.toString(obj3));
        System.out.println(Arrays.toString(obj4));
    }

    /**
     * 多维数组复制
     */
    private static void multiDimensionalArrayCopy() {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        int[] arr3 = {5, 6};

        int[][] src = new int[][]{arr1, arr2, arr3};
        print("原始输出：", src);
        int[][] dest = new int[3][];
        System.arraycopy(src, 0, dest, 0, 3);

        System.out.println("改变前");
        print("src = ", src);
        print("dest = ", dest);

        //原数组改变后观察新数组是否改变，改变->浅复制，不改变->深复制
        src[0][0] = -1;

        System.out.println("改变后");
        print("src = ", src);
        print("dest = ", dest);
    }

    /**
     * 打印数组
     *
     * @param string 字符串
     * @param arr    二维数组入参
     */
    private static void print(String string, int[][] arr) {
        System.out.print(string);
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print(",");
        }
        System.out.println();
    }

    /**
     * 对象数组拷贝
     */
    public static void beanArrayCopy() {
        User user1 = new User("aaa", 18);
        User user2 = new User("bbb", 18);
        User user3 = new User("ccc", 18);
        User[] userArraySrc = {user1, user2, user3};
        User[] userArrayDest = new User[3];
        System.out.println("对象数组复制，原始输出：" + Arrays.toString(userArraySrc));
        System.arraycopy(userArraySrc, 0, userArrayDest, 0, userArraySrc.length);
        System.out.println("userArrayDest," + Arrays.toString(userArrayDest));
        System.out.println("------------改变原对象------------------");
        userArraySrc[0] = new User("ddd", 20);
        System.out.println("***" + Arrays.toString(userArraySrc));
        System.out.println("***" + Arrays.toString(userArrayDest));
    }

    /**
     * 基本数组clone方法
     */
    public static void cloneTest1() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[arr1.length];
        arr2 = arr1.clone();
        System.out.println("===============拷贝后================");
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
        // 改变拷贝后的数组，原数组并未跟着改变，表明对于基本数据类型，clone是深拷贝
        arr2[0] = 100;
        System.out.println("===============改变后================");
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }

    /**
     * 对象数组clone
     */
    public static void cloneTest2() {
        User user1 = new User("aaa", 18);
        User user2 = new User("bbb", 20);
        User[] userArr1 = new User[]{user1, user2};
        User[] userArr2 = userArr1.clone();
        System.out.println("===============拷贝后================");
        System.out.println("userArr1 = " + Arrays.toString(userArr1));
        System.out.println("userArr2 = " + Arrays.toString(userArr2));
        // 改变拷贝后的user数组，原user数组也跟着改变了，表明对于对象而言，clone是浅拷贝
        userArr2[0].setAge(35);
        userArr2[0].setName("asd");
        System.out.println("===============改变后================");
        System.out.println("userArr1 = " + Arrays.toString(userArr1));
        System.out.println("userArr2 = " + Arrays.toString(userArr2));
    }
}
