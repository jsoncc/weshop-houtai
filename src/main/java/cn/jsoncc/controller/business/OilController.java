package cn.jsoncc.controller.business;

import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.ResultBean;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.business.OilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/16 15:00
 * Email:896415482@qq.com
 */
@RestController
@RequestMapping("/api/oil")
public class OilController extends BaseController {

    @Autowired
    OilService oilService;

    // 添加
    @PostMapping("/save")
    public String save(@RequestBody Map map) {
        int rs = oilService.saveOil(map);
        if (rs > 0) {
            return success("油站添加成功");
        }
        return fail("油站添加失败");
    }

    @PostMapping("/list")
    public String query(@RequestBody Map map) {
        PageBean pageBean = oilService.queryOil(map);
        return success("油站列表", pageBean);
    }

    @PostMapping("/update")
    public String update (@RequestBody Map map){
        int rs = oilService.updateOil(map);
        if (rs == 1) {
            return success("油站修改成功");
        }
        return fail("油站修改失败");
    }

    // 删除
    @RequestMapping("/delete")
    public String delete(String id){
        Map map = new HashMap();
        map.put("id",id);
            map.put("isdel",1);
            int rs = oilService.updateOil(map);
            if (rs == 1) {
                return success("油站删除成功");
            }
            return fail("油站删除失败");
    }


}
