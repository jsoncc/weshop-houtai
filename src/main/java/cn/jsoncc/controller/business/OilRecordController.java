package cn.jsoncc.controller.business;

import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.business.OilRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/26 11:02
 * Email:896415482@qq.com
 *
 *
 */
@RestController
@RequestMapping("/api/oil/record")
public class OilRecordController extends BaseController {

    @Autowired
    OilRecordService oilRecordService;

    @RequestMapping("/save")
    public String save(@RequestBody Map map){
        int rs = oilRecordService.save(map);
        if (rs > 0){
            return success("充值成功");
        }
        return fail("充值失败");
    }

    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public String query(@RequestBody Map map){
        PageBean pageBean = oilRecordService.query(map);
        return success("充值记录列表",pageBean);
    }
}
