package top.flobby.basic.learning.proxyex;

/**
 * @author : Flobby
 * @program : java-basic
 * @description :
 * @create : 2021-11-26 19:55
 **/

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void query() {
        System.out.println("query");
    }


}
