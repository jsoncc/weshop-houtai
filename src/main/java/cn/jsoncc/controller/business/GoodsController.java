package cn.jsoncc.controller.business;

import cn.jsoncc.bean.Goods;
import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.business.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    //添加商品缺少唯一性验证 validate 目的是添加商品时不添加重复的
    //          已经添加了，但是没姬霸用
    @PostMapping("/save")
    @ApiOperation(value = "添加商品({\n" +
            "\"goodsname\": \"小米电视\",\n" +
            "\"cid\": \"家电\",\n" +
            "\"unit\": \"台\",\n" +
            "\"normal_price\": \"3399\",\n" +
            "\"cf_price\": \"3199\",\n" +
            "\"nums\": 200,\n" +
            "\"note\":\"商品名称：小米L55M7-ES商品编号：100012093825商品毛重：17.0kg商品产地：中国大陆屏幕尺寸：55英寸能效等级：三级能效分辨率：4k超高清（3840×2160）\",\n" +
            "\"desc\":\"小米L55M7-ES\"\n" +
            "})")
    public String save(@Validated @RequestBody Map map, BindingResult result) {
        List val = validate(result);
        if (val != null){
            return fail("添加商品验证失败",val);
        }
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

    //修改商品
    @PostMapping("/update")
    @ApiOperation(value = "修改商品")
    public String update(@RequestBody Goods goods){
        int rs = goodsService.updateGoods(goods);
        if (rs == 1){
            return success("商品修改成功");
        }
        return fail("商品修改失败");
    }
}
