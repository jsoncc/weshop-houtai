package cn.jsoncc.service.sys.impl;

import cn.jsoncc.bean.User;
import cn.jsoncc.dao.sys.LoginDao;
import cn.jsoncc.service.sys.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/1 20:30
 * Email:896415482@qq.com
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;

    @Override
    public User login(Map map) {
        Object obj = map.get("username");
        if (null == obj){
            return null;
        }
        return loginDao.queryUserByUserName(obj.toString());
    }
}
