package top.flobby.java.basic.ioex.entity;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 序列化测试实体类
 * @create : 2021-11-17 12:24
 **/

public class Employee implements java.io.Serializable {
    /**
     * 加⼊序列版本号
     */
    private static final long serialVersionUID = 1L;

    public String name;
    public String address;
    public transient int age;
    /**
     * 添加新的属性 ,重新编译, 可以反序列化,该属性赋为默认值
     */
    public int eid;

    /**
     * transient瞬态修饰成员,不会被序列化
     */
    public void addressCheck() {
        System.out.println("Address check : " + name + " -- " + address);
    }
}