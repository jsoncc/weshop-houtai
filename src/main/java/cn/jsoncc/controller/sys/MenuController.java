package cn.jsoncc.controller.sys;

import cn.jsoncc.bean.Menu;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: JsonCC
 * Date: 2021/7/5 15:23
 * Email:896415482@qq.com
 */
@RestController
@RequestMapping("/api/sys/menu")
public class MenuController extends BaseController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/save")
    public String save(@Validated @RequestBody Menu menu, BindingResult result) {
        List val = validate(result);
        if (null != val){
            return fail("保存失败",val);
        }
        int rs = menuService.save(menu);
        if (rs>0){
            return success("保存成功");
        }
        return fail("保存失败");
    }

    @GetMapping("/child")
    public String query(String pid){
        List list= menuService.queryMenuByParentId(pid);
        return success("菜单列表",list);
    }

    //查询菜单树
    @GetMapping("/tree")
    public String queryTree(){
        List list = menuService.queryMenuTree();
        return success("菜单树",list);
    }
}
