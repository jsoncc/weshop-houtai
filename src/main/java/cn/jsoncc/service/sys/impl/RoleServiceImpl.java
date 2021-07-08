package cn.jsoncc.service.sys.impl;

import cn.jsoncc.dao.sys.RoleDao;
import cn.jsoncc.dao.sys.RoleMenuDao;
import cn.jsoncc.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author: JsonCC
 * Date: 2021/7/8 11:34
 * Email:896415482@qq.com
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    RoleMenuDao roleMenuDao;


    @Transactional
    @Override
    public int save(Map map) {
        //生成的id就是角色id
        String id = UUID.randomUUID().toString();
        map.put("id",id);
        int rs = roleDao.save(map);
        if (rs > 0){
            //保存角色菜单关系
            Object obj = map.get("auths");
            if (obj == null){
                return rs;
            }

            List list =(ArrayList)obj;
            if (list.size()==0){
                return rs;
            }

            //添加角色菜单
            rs = roleMenuDao.saveBatchRoleMenu(map);
            return rs;

        }


        return 0;
    }
}
