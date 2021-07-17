package cn.jsoncc.service.business.impl;

import cn.jsoncc.bean.Goods;
import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.PageMap;
import cn.jsoncc.dao.business.GoodsDao;
import cn.jsoncc.service.business.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author: JsonCC
 * Date: 2021/7/14 14:43
 * Email:896415482@qq.com
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    //分页
    @Override
    public PageBean query(Map map) {
        PageMap pageMap = new PageMap(map);
        List list = goodsDao.queryResultByPage(pageMap);
        int total = goodsDao.queryCount(pageMap);
        return new PageBean(pageMap.getPage(), pageMap.getPageSize(), total, list);
    }

    //这才是查询商品
    @Override
    public List<Goods> queryGoods() {
        List<Goods> goods = goodsDao.queryGoods();
        return goods;
    }

    @Override
    @Transactional
    public int saveGoods(Map map) {
        //生成商品id
        String gid = UUID.randomUUID().toString();
        map.put("id", gid);
        //保存油站
        int rs = goodsDao.saveGoods(map);
        return rs;
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }
}
