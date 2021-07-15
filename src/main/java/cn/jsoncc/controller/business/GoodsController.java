package cn.jsoncc.controller.business;

import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.business.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/14 15:26
 * Email:896415482@qq.com
 */
@RestController
@RequestMapping("/api/goods")
@Api(tags = "商品控制器")
public class GoodsController extends BaseController {
    @Autowired
    GoodsService goodsService;

    // 添加
    @PostMapping("/save")
    @ApiOperation(value = "添加商品")
    public String save(@RequestBody Map map) {
        int rs = goodsService.saveGoods(map);
        if (rs > 0) {
            return success("商品添加成功");
        }
        return fail("商品添加失败");
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询商品")
    public String query(@RequestBody Map map) {
        PageBean pageBean = goodsService.query(map);
        return success("商品列表", pageBean);
    }
}
