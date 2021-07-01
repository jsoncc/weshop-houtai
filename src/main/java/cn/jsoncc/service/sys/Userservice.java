package cn.jsoncc.service.sys;

import cn.jsoncc.bean.User;
import cn.jsoncc.common.bean.PageBean;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/30 11:00
 * Email:896415482@qq.com
 */
public interface Userservice {
    public int save(User user);
    public PageBean query(Map map);
}
