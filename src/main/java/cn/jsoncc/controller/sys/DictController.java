
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
        }else if(rs == -1){
            return fail("保存失败，编码已存在");
        }
        return fail("保存失败");
    }

    @GetMapping("/list")
    public String query(String pid){
        List list=dictService.queryChildDictByParentId(pid);
        return success("字典列表",list);
    }

    @RequestMapping("/update")
    public String update(@RequestBody Map map){
        int rs=dictService.update(map);
        if(rs==1){
            return success("操作成功");
        }
        return fail("操作失败");
    }

    @RequestMapping("/deletetab")
    public String deleteDictTabAll(String id){
        int rs = dictService.deleteDictTabAll(id);
        if (rs == 1){
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @RequestMapping("/checkcode")
    public String checkcode(@RequestBody Map map){
        int rs = dictService.checkcode(map);
        if(rs > 0){
            return success("no");
        }
        return success("yes");
    }

    //根据字典写用户类型，供用户管理的用户类型选择
    @RequestMapping("/childdict")
    public String queryChildDict(String code){
        List list = dictService.queryChildDict(code);
        return success("字典数据：",list);
    }
}
