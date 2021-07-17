package cn.jsoncc.service.business.impl;

import cn.jsoncc.dao.business.GoodsCategoryDao;
import cn.jsoncc.service.business.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author: JsonCC
 * Date: 2021/7/16 17:26
 * Email:896415482@qq.com
 */
@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    GoodsCategoryDao goodsCategoryDao;

    @Override
    public int save(Map map) {
        /*//生成商品分类id
        String gcId = UUID.randomUUID().toString();
        map.put("id", gcId);
        //保存商品分类
        int rs = goodsCategoryDao.saveGoodsCategory(map);

        return rs;*/

        //查询字典编码是否存在
        int count = goodsCategoryDao.queryCategoryCodeOnly(map);
        if (count > 0){
            return -1;
        }
        return goodsCategoryDao.save(map);
    }

    @Override
    public List<Map> queryChildGoodsCategoryByParentId(String pid) {
        return goodsCategoryDao.queryChildGoodsCategoryByParentId(pid);
    }

    @Override
    public List<Map> queryChildGoodsCategory(String categorycode) {
        return goodsCategoryDao.queryChildGoodsCategory(categorycode);
    }

    @Override
    public int querycheckcode(Map map) {
        return goodsCategoryDao.queryCategoryCodeOnly(map);
    }


}
