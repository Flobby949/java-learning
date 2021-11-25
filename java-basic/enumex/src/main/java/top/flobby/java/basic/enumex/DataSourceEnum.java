package top.flobby.java.basic.enumex;

/**
 * @author : JinChenXing
 * @program : java-basic
 * @description : 多数据源枚举
 * @create : 2021-11-25 14:01
 **/

public enum DataSourceEnum {
    /**
     * 数据源枚举
     */
    DATASOURCE;

    private final DbConnection connection;

    DataSourceEnum() {
        connection = new DbConnection();
    }

    public DbConnection getConnection() {
        return connection;
    }

    static class DbConnection {
        private DbConnection() {

        }
    }
}
