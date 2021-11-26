package top.flobby.basic.learning.proxyex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 利用反射机制在运行时创建代理类。
 * @create : 2021-11-26 19:48
 **/

public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 生成得到代理类
     * @return object
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 处理代理类，返回结果
     * @param proxy proxy
     * @param method method
     * @param args args
     * @return object
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        // 动态代理的本质就是使用反射机制来实现
        return method.invoke(target, args);
    }


    public void log(String msg) {
        System.out.println("执行了" + msg + "方法");
    }
}
