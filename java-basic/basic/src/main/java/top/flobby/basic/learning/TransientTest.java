package top.flobby.basic.learning;

import top.flobby.basic.learning.entity.UserSerializable;

import java.io.*;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 序列化反序列化练习
 * @create : 2021-11-22 11:41
 **/

public class TransientTest {
    public static void main(String[] args) {
        try {
            serializeUser();
            deSerializeUser();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public static void serializeUser() throws IOException {
        UserSerializable user = new UserSerializable("松山院", "123456");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
        oos.writeObject(user);
        oos.close();
        System.out.println("普通字段序列化：username=\t" + user.getUsername());
        System.out.println("添加了transient关键字序列化：password=\t" + user.getPassword());
    }

    public static void deSerializeUser() throws IOException, ClassNotFoundException {
        File file = new File("data.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        UserSerializable user = (UserSerializable) ois.readObject();
        System.out.println("普通字段序列化：username=\t" + user.getUsername());
        System.out.println("添加了transient关键字序列化：password=\t" + user.getPassword());
    }
}
