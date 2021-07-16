package cn.jsoncc.service.business;

import cn.jsoncc.bean.Goods;
import cn.jsoncc.common.bean.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/14 14:43
 * Email:896415482@qq.com
 */
public interface GoodsService {
    //分页查询-仅是分页
    public PageBean query(Map map);

    //查询商品列表
    public List<Goods> queryGoods();

    //添加保存商品信息
    public int saveGoods(Map map);

    //修改商品
    public int updateGoods(Goods goods);
}
