package cn.jsoncc.dao.sys;

import cn.jsoncc.bean.User;
import cn.jsoncc.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: JsonCC
 * Date: 2021/6/30 12:36
 * Email:896415482@qq.com
 */
@Mapper
public interface UserDao extends BaseDao<User> {
    public List<User> queryAll();
}
