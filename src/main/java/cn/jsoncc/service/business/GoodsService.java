package cn.jsoncc.service.business;

import cn.jsoncc.common.bean.PageBean;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/14 14:43
 * Email:896415482@qq.com
 */
public interface GoodsService {
    //查询商品列表
    public PageBean queryGoods(Map map);

    //添加保存商品信息
    public int saveGoods(Map map);
}
