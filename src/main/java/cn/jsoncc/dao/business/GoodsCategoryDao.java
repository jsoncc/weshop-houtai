package cn.jsoncc.dao.business;

import cn.jsoncc.bean.GoodsCategory;
import cn.jsoncc.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/16 17:15
 * Email:896415482@qq.com
 */
@Mapper
public interface GoodsCategoryDao extends BaseDao<Map> {
//    不需要save添加保存，因为继承了BaseDao，这里面有save
//    public int saveGoodsCategory(Map map);
//
    public List<Map> queryChildGoodsCategoryByParentId(String pid);

    public List<Map> queryChildGoodsCategory(String categorycode);

    public int queryCategoryCodeOnly(Map map);

}
