package cn.jsoncc.controller.business;

import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.business.GoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/16 17:31
 * Email:896415482@qq.com
 */
@RestController
@RequestMapping("/api/goods/category")
@Api(tags = "商品分类控制器")
public class GoodsCategoryController extends BaseController {

    @Autowired
    GoodsCategoryService goodsCategoryService;

    @ApiOperation("商品分类添加")
    @PostMapping("/save")
    public String save(@RequestBody Map map){
        int rs = goodsCategoryService.save(map);
        if (rs == 1){
            return success("保存成功");
        }else if (rs == -1){
            return fail("保存失败，该编码已存在");
        }
        return fail("保存失败");
    }

    //主查询-商品分类
    //对照其Impl，其返回的是List
    @GetMapping("/query")
    @ApiOperation("主查询-商品分类")
    public String query(String pid){
        List list = goodsCategoryService.queryChildGoodsCategoryByParentId(pid);
        return success("查询成功商品分类列表:",list);
    }

    @GetMapping("/queryChildGoodsCategory")
    @ApiOperation("根据商品分类code查询数据")
    public String queryChildGoodsCategory(String categorycode){
        List list = goodsCategoryService.queryChildGoodsCategory(categorycode);
        return success("商品分类列表的数据:",list);
    }

    //这里用PostMapping传值不怎么明白，还有对照其Impl是int，为什么这里是String，就是因为Map？
    //根据字典写用户类型，供用户管理的用户类型选择
    @PostMapping("/querycheckcode")
    @ApiOperation("根据商品分类写cid分类")
    public String querycheckcode(@RequestBody Map map){
        int rs = goodsCategoryService.querycheckcode(map);
        if (rs > 0){
            return success("成功:编码存在,no");
        }
        return success("成功:可以添加编码,yes");
    }

}
