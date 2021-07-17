package cn.jsoncc.service.business;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/16 17:25
 * Email:896415482@qq.com
 */
public interface GoodsCategoryService {
    public int save(Map map);

    public List<Map> queryChildGoodsCategoryByParentId(String pid);

    public List<Map> queryChildGoodsCategory(String categorycode);

    public int querycheckcode(Map map);
}
