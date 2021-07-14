package cn.jsoncc.dao.business;

import cn.jsoncc.bean.Goods;
import cn.jsoncc.common.bean.PageMap;
import cn.jsoncc.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/14 12:36
 * Email:896415482@qq.com
 */
@Mapper
public interface GoodsDao extends BaseDao<Map> {
    //添加保存商品
    public int saveGoods(Map map);

    //查询分页之后的结果集，显示商品列表
    public List<Goods> queryGoods(PageMap pageMap);
}
