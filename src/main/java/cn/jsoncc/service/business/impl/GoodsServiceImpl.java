package cn.jsoncc.service.business.impl;

import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.PageMap;
import cn.jsoncc.dao.business.GoodsDao;
import cn.jsoncc.service.business.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author: JsonCC
 * Date: 2021/7/14 14:43
 * Email:896415482@qq.com
 */
@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public PageBean queryGoods(Map map) {
        PageMap pageMap = new PageMap(map);
        List list = goodsDao.queryGoods(pageMap);
        int total = goodsDao.queryCount(pageMap);
        return new PageBean(pageMap.getPage(), pageMap.getPageSize(), total, list);
    }

    @Override
    public int saveGoods(Map map) {
        //生成商品id
        String gid = UUID.randomUUID().toString();
        map.put("id", gid);
        //保存油站
        int rs = goodsDao.saveGoods(map);
        return rs;
    }
}
