package cn.jsoncc.service.sys.impl;

import cn.jsoncc.bean.User;
import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.PageMap;
import cn.jsoncc.dao.sys.UserDao;
import cn.jsoncc.service.sys.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/30 11:01
 * Email:896415482@qq.com
 */
@Service
public class UserServiceImpl implements Userservice {

    @Autowired
    UserDao userDao;

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public PageBean query(Map map) {
        PageMap pageMap = new PageMap(map);
        List list = userDao.queryResultByPage(pageMap);
        int total = userDao.queryCount(pageMap);
        PageBean pageBean = new PageBean(pageMap.getPage(), pageMap.getPageSize(), total, list);
        return pageBean;
    }

    @Override
    public List<User> queryAll() {
        List<User> users = userDao.queryAll();
        return users;
    }
}
