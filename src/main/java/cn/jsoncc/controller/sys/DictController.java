
package cn.jsoncc.controller.sys;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.sys.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/sys/dict")
public class DictController extends BaseController {

    @Autowired
    DictService dictService;

    @PostMapping("/save")
    public String save(@RequestBody Map map){
        int rs=dictService.save(map);
        if(rs==1){
            return success("保存成功 ");
        }
        return fail("保存失败");
    }

    @GetMapping("/list")
    public String query(String pid){
        List list=dictService.queryChildDictByParentId(pid);
        return success("字典列表",list);
    }
}
