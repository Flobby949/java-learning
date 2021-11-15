package top.flobby.propex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * @author : Flobby
 * @program : basedao-sample
 * @description :
 * @create : 2021-11-15 15:27
 **/

public class PropLoad {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        // 通过IO读取外部属性文件，注意路径
        InputStream in = PropLoad.class.getResourceAsStream("datasource.properties");
        properties.load(in);

        // 所有的键存储到Set集合
        Set<String> keySet = properties.stringPropertyNames();
        // 遍历
        for (String key : keySet) {
            System.out.println(key + "==" + properties.getProperty(key));
        }
    }
}
