package cn.jsoncc.dao.sys;

import cn.jsoncc.bean.Menu;
import cn.jsoncc.bean.TreeMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/5 15:24
 * Email:896415482@qq.com
 */
@Mapper
public interface MenuDao {
    //添加菜单
    public int save(Menu menu);

    //通过父ID，查询菜单内容
    public List<Map> queryMenuByParentId(String pid);

    //查询菜单树
    public List<TreeMenu> queryMenuTree();
}
