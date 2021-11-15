package top.flobby.basedao.dao.impl;

import top.flobby.basedao.context.DataContext;
import top.flobby.basedao.dao.BaseDao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : basedao-sample
 * @description : 实现类
 * @create : 2021-11-15 08:44
 **/

@SuppressWarnings("unchecked") // 强制类型转换警告
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    private final Class<T> clazz;
    private final List<T> list;

    public BaseDaoImpl() {
        // this.getClass() 代表当前运行对象的Class对象  ?表示不确定类型
        Class<?> cClass = this.getClass();
        // cClass.getGenericSuperclass()得到当前对象的父类(参数化类型) 如BaseDao<Book,?,?...>
        Type type = cClass.getGenericSuperclass();
        // 向下转型为参数化对象
        ParameterizedType pt = (ParameterizedType) type;
        // 得到参数化类型（泛型类型列表） 如<Book,?,?...>
        Type[] types = pt.getActualTypeArguments();
        // 取出泛型类型列表中想要的类型，并强制转换为具体的Class
        clazz = (Class<T>) types[0];
        list = (List<T>) DataContext.getData();
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void delete(T t) {
        list.remove(t);
    }

    @Override
    public T get(Long id) {
        List<T> res = findByField(list, "id", id, clazz);
        // 判空方法
        return Objects.requireNonNull(res).get(0);
    }

    @Override
    public List<T> findByField(String fieldName, Object value) {
        return findByField(list, fieldName, value, clazz);
    }

    @Override
    public void update(T t, Long id) {
        Field field = null;
        try {
            field = clazz.getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(field).setAccessible(true);
        // 查找数据集中的id值和入参相等的对象
        for (int i = 0; i < list.size(); i++) {
            T next = list.get(i);
            try {
                // 得到该对象的id值
                Object o = field.get(next);
                // id相等找到需要更新对象
                if (id.equals(o)) {
                    // 将入参t放入该位置，实现更新
                    list.add(i, t);
                    break;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<T> findAll() {
        return list;
    }

    /**
     * 根据属性在list中查找
     * @param list 数据集
     * @param field 字段
     * @param value 值
     * @param clazz 当前数据类型
     * @param <T> 泛型方法
     * @return List
     */
    private static <T> List<T> findByField(List<T> list, String field, Object value, Class<T> clazz) {
        List<T> res = new ArrayList<>();
        try {
            // 通过反射获取指定属性
            Field classField = clazz.getDeclaredField(field);
            // 设置属性为可访问
            classField.setAccessible(true);
            for (T t : list) {
                // 遍历list,获取对应属性的值
                Object o = classField.get(t);
                if (value.toString().equals(o.toString())) {
                    // 如果和预期相等的话，则加入到返回值中
                    res.add(t);
                }
            }
        } catch (NoSuchFieldException e) {
            // 如果不存在这个字段，返回为空
            return null;
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return res;
    }
}
