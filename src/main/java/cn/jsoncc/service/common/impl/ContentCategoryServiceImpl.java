package cn.jsoncc.service.common.impl;

import cn.jsoncc.dto.ContentCategoryDTO;
import cn.jsoncc.service.common.ContentCategoryService;
import org.springframework.stereotype.Service;

//package cn.jsoncc.service.common.impl;
//
///**
// * Author: JsonCC
// * Date: 2021/7/12 11:48
// * Email:896415482@qq.com
// */
//import cn.jsoncc.dto.ContentCategoryDTO;
//import cn.jsoncc.service.common.ContentCategoryService;
////import com.funtl.hello.spring.cloud.service.admin.dao.TbContentCategoryMapper;
////import com.funtl.hello.spring.cloud.service.admin.dto.ContentCategoryDTO;
////import com.funtl.hello.spring.cloud.service.admin.entity.TbContentCategory;
////import com.funtl.hello.spring.cloud.service.admin.service.ContentCategoryService;
////import com.funtl.hello.spring.cloud.service.admin.util.DtoEntityUtil;
////import com.github.pagehelper.PageHelper;
////import com.github.pagehelper.PageInfo;
//import cn.jsoncc.utils.DtoEntityUtil;
//import io.swagger.annotations.Example;
//import org.springframework.stereotype.Service;
////import tk.mybatis.mapper.entity.Example;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Override
    public void insert(ContentCategoryDTO contentCategoryDTO) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String newName, String oldName, Boolean isParent) {

    }
}
//
//    @Resource
//    private TbContentCategoryMapper tbContentCategoryMapper;
//
//    @Override
//    public void insert(ContentCategoryDTO contentCategoryDTO) {
//
//        TbContentCategory trans = DtoEntityUtil.trans(contentCategoryDTO, TbContentCategory.class);
//        trans.setCreated(new Date());
//        trans.setUpdated(new Date());
//        // 插入数据
//        tbContentCategoryMapper.insert(trans);
//    }
//
//    @Override
//    public void delete(String name) {
//        // 构造条件，等同于 DELETE from tb_user WHERE  name = 'coco'
//        Example example = new Example(TbContentCategory.class);
//        example.createCriteria().andEqualTo("name", name);
//
//        // 删除数据
//        tbContentCategoryMapper.deleteByExample(example);
//    }
//
//    @Override
//    public void update(String newName, String oldName, Boolean isParent) {
//        // 构造条件
//        Example example = new Example(TbContentCategory.class);
//        example.createCriteria().andEqualTo("name", oldName);
//
//        // 构造一条测试数据
//        TbContentCategory tbContentCategory = new TbContentCategory();
//        tbContentCategory.setName(newName);
//        tbContentCategory.setIsParent(isParent);
//        tbContentCategory.setStatus(88);
//        tbContentCategory.setParentId(99L);
//        tbContentCategory.setCreated(new Date());
//        tbContentCategory.setUpdated(new Date());
//
//        // 修改数据
//        tbContentCategoryMapper.updateByExample(tbContentCategory, example);
//    }
//
//    @Override
//    public List<TbContentCategory> select() {
//        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectAll();
//        for (TbContentCategory contentCategory : tbContentCategories) {
//            System.out.println(contentCategory.getName());
//        }
//        return tbContentCategories;
//    }
//
//    @Override
//    public PageInfo<TbContentCategory> page(Integer pageNumber, Integer pageSize) {
//        // PageHelper 使用非常简单，只需要设置页码和每页显示笔数即可
//        PageHelper.startPage(pageNumber, pageSize);
//
//        // 设置分页查询条件
//        Example example = new Example(TbContentCategory.class);
//        PageInfo<TbContentCategory> pageInfo = new PageInfo<>(tbContentCategoryMapper.selectByExample(example));
//
//        return pageInfo;
//    }
//}
//
