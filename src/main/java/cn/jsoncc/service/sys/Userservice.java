package cn.jsoncc.service.sys;

import cn.jsoncc.bean.User;
import cn.jsoncc.common.bean.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/30 11:00
 * Email:896415482@qq.com
 */
public interface Userservice {
    public int save(User user);

    //分页查询-仅是分页
    public PageBean query(Map map);

    //查询所有用户
    public List<User> queryAll();
}
