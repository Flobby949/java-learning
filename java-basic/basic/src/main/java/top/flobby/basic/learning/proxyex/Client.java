package top.flobby.basic.learning.proxyex;

/**
 * @author : Flobby
 * @program : java-basic
 * @description :
 * @create : 2021-11-26 20:02
 **/

public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserService userService = new UserServiceImpl();

        // 代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 通过调用程序处理角色来处理我们要调用的对象
        pih.setTarget(userService);

        UserService proxy = (UserService) pih.getProxy();
        proxy.update();
    }
}
