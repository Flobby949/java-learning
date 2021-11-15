package top.flobby.basedao.dao;

import java.util.List;

/**
 * @author : JinChenXing
 * @program : basedao-sample
 * @description : 泛型接口
 * @create : 2021-11-15 08:40
 **/

public interface BaseDao<T> {

    /**
     * 新增
     * @param t 泛型入参
     */
    void add(T t);

    /**
     * 新增
     * @param t 泛型入参
     */
    void delete(T t);

    /**
     * 新增
     * @param id 主键
     * @return T
     */
    T get(Long id);

    /**
     * 根据指定查询
     * @param fieldName 字段名
     * @param value 值
     * @return list
     */
    List<T> findByField(String fieldName, Object value);

    /**
     * 更新
     * @param t 泛型入参
     * @param id 主键
     */
    void update(T t, Long id);

    /**
     * 查询所有
     * @return List
     */
    List<T> findAll();
}
