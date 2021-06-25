package cn.jsoncc.dao;

/**
 * Author: JsonCC
 * Date: 2021/6/25 9:19
 * Email:896415482@qq.com
 */

import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.PageMap;

import java.util.List;

/**
 * 封装增删改查操作
 * @param <T>
 */
public interface BaseDao<T> {
    //增加
    public int save(T t);
    //删除
    public int delete(String id);
    //修改
    public int update(T t);
    //分页查询的结果集 查询
    public List<T> queryResultByPage(PageMap pageMap);
    //查询总记录数
    public int queryCount(PageMap pageMap);
    //根据id查询单表结果
    public T get(String id);
}
