package cn.jsoncc.service.sys.impl;

import cn.jsoncc.bean.Menu;
import cn.jsoncc.bean.TreeMenu;
import cn.jsoncc.dao.sys.MenuDao;
import cn.jsoncc.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/5 15:29
 * Email:896415482@qq.com
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public int save(Menu menu) {
        return menuDao.save(menu);
    }

    @Override
    public List<Map> queryMenuByParentId(String id) {
        List list=menuDao.queryMenuByParentId(id);
        Iterator<Map> it=list.iterator();
        while(it.hasNext()){
            Map map=it.next();
            int c=Integer.parseInt(map.get("childCound").toString());
            if(c>0){
                map.put("hasChildren",true) ;
            }else{
                map.put("hasChildren",false) ;
            }
        }
        return list;
    }

    @Override
    public List<TreeMenu> queryMenuTree() {
        return menuDao.queryMenuTree();
    }

}
