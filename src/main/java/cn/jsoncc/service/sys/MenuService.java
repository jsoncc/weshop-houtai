package cn.jsoncc.service.sys;

import cn.jsoncc.bean.Menu;
import cn.jsoncc.bean.TreeMenu;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/5 15:29
 * Email:896415482@qq.com
 */
public interface MenuService {
    public int save(Menu menu);
    public List<Map> queryMenuByParentId(String id);
    //查询菜单树
    public List<TreeMenu> queryMenuTree();
}
