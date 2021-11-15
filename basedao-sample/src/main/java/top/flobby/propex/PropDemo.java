package top.flobby.propex;

import java.util.Properties;
import java.util.Set;

/**
 * @author : Flobby
 * @program : basedao-sample
 * @description :
 * @create : 2021-11-15 14:02
 **/

public class PropDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 存储键值对
        properties.setProperty("host", "localhost");
        properties.setProperty("port", "3306");
        properties.setProperty("username", "root");
        properties.setProperty("password", "kobe24");
        System.out.println(properties);
        // 获取port对应的值
        String port = properties.getProperty("port");
        System.out.println(port);
        // 所有的键存储到Set集合
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            System.out.println(key + "==" + properties.getProperty(key));
        }
    }
}
