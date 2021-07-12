package cn.jsoncc.service.common;

/**
 * Author: JsonCC
 * Date: 2021/7/12 11:47
 * Email:896415482@qq.com
 */
import cn.jsoncc.dto.ContentCategoryDTO;


import java.util.List;

public interface ContentCategoryService {

    /**
     * 测试插入数据
     */
    public void insert(ContentCategoryDTO contentCategoryDTO);

    /**
     * 测试删除数据
     */
    public void delete(String id);

    /**
     * 测试修改数据
     */
    public void update(String newName, String oldName, Boolean isParent);

//    /**
//     * 测试查询集合
//     */
//    public List<TbContentCategory> select();
//
//    /**
//     * 测试分页查询
//     */
//    public PageInfo<TbContentCategory> page(Integer pageNumber, Integer pageSize);
}
