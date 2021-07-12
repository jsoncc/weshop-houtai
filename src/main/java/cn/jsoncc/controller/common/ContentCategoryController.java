package cn.jsoncc.controller.common;

/**
 * Author: JsonCC
 * Date: 2021/7/12 11:50
 * Email:896415482@qq.com
 */

import cn.jsoncc.dto.ContentCategoryDTO;
import cn.jsoncc.service.common.ContentCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/contentCategory")
@Api(value = "内容类别管理控制器")
public class ContentCategoryController {

    @Resource
    private ContentCategoryService contentCategoryService;

    @ApiOperation(value = "新增", notes = "add")
    @PostMapping(path = "/insert")
    public String insert(@RequestBody ContentCategoryDTO contentCategoryDTO) {
        System.out.println(contentCategoryDTO);
        contentCategoryService.insert(contentCategoryDTO);
        return "success";
    }

    @ApiOperation("删除分类")
    @ApiImplicitParam(name = "name", value = "名字", required = true, dataType = "String", paramType = "path")
    @DeleteMapping(value = "/{name}")
    public String delete(@PathVariable("name") String name) {
        contentCategoryService.delete(name);
        return "success";
    }

    @ApiOperation(value = "更新内容类别", notes = "修改内容类别", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newName", value = "新名字 ", required = true, dataType = "String"),
            @ApiImplicitParam(name = "oldName", value = "旧名字 ", required = true, dataType = "String"),
            @ApiImplicitParam(name = "isParent", value = "该类目是否为父类目，1为true，0为false ", required = false, dataType = "Boolean")
    })
    @PutMapping("/update")
    public String editEnableStatus(@RequestParam(value = "newName") String newName,
                                   @RequestParam(value = "oldName") String oldName,
                                   @RequestParam(value = "isParent") Boolean isParent) {
        contentCategoryService.update(newName, oldName, isParent);
        return "success";
    }

//    @ApiOperation(value = "查询全部", notes = "查询全部", produces = "application/json")
//    @GetMapping(path = "/select")
//    public List<TbContentCategory> select() {
//        List<TbContentCategory> select = contentCategoryService.select();
//        return select;
//    }

//    @ApiOperation(value = "分页查询", notes = "分页查询", produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNumber", value = "页码 ", required = false, dataType = "Integer"),
//            @ApiImplicitParam(name = "pageSize", value = "数量 ", required = false, dataType = "Integer")})
//    @GetMapping(path = "/page")
//    public PageInfo<TbContentCategory> page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
//                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//        PageInfo<TbContentCategory> result = contentCategoryService.page(pageNumber, pageSize);
//        return result;
//    }

}
