package top.flobby.basedao.context;

/**
 * @author : Flobby
 * @program : basedao-sample
 * @description :
 * @create : 2021-11-15 08:53
 **/

public class DataContext implements AutoCloseable {
    /**
     * 全局共享同一个ThreadLocal
     */
    public static final ThreadLocal<Object> CTX = new ThreadLocal<>();

    public static void setData(Object data) {
        CTX.set(data);
    }

    public static Object getData() {
        return CTX.get();
    }

    @Override
    public void close() {
        CTX.remove();
    }
}
