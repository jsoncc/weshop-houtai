package cn.jsoncc.controller.sys;

import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/8 11:37
 * Email:896415482@qq.com
 */
@RestController
@RequestMapping("/api/sys/role")
public class RoleController extends BaseController {

    @Autowired
    RoleService roleService;

    @PostMapping("/save")
    public String save(@RequestBody Map map){
        int rs = roleService.save(map);
        if (rs>0){
            return success("保存成功");
        }
        return fail("保存失败");
    }
}
