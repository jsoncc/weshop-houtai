package cn.jsoncc.dao.sys;

import cn.jsoncc.bean.User;
import cn.jsoncc.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/1 20:28
 * Email:896415482@qq.com
 */
@Mapper
public interface LoginDao extends BaseDao<Map> {
    public User queryUserByUserName(String username);
}
