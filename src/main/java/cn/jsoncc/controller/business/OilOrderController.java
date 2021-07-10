package cn.jsoncc.controller.business;

import cn.jsoncc.bean.OilOrder;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.business.OilOrderService;
import cn.jsoncc.service.business.OilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: JsonCC
 * Date: 2021/7/9 14:26
 * Email:896415482@qq.com
 */
@RestController
@RequestMapping("/api/order/oil")
public class OilOrderController extends BaseController {

    @Autowired
    OilOrderService oilOrderService;

    @PostMapping("/list")
    public String save(@Validated @RequestBody OilOrder oilOrder, BindingResult result){
        List val = validate(result);
        if (null != val){
            return fail("下单保存失败",val);
        }
        int rs = oilOrderService.save(oilOrder);
        if (rs == 1){
            return success("下单保存成功");
        } else if (rs ==2) {
            return fail("油站油卡余额不足");
        }
        return fail("下单保存失败");
    }

}
