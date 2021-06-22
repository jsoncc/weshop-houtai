package cn.jsoncc.service.business.impl;

import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.PageMap;
import cn.jsoncc.dao.business.OilDao;
import cn.jsoncc.service.business.OilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/16 16:33
 * Email:896415482@qq.com
 */
@Service("oilService")
public class OilServiceImpl implements OilService {

    @Autowired
    private OilDao oilDao;

    @Override
    public PageBean queryOil(Map map) {
        PageMap pageMap = new PageMap(map);
        List list = oilDao.queryOil(pageMap);
        int total = oilDao.queryOilCount(pageMap);
        return new PageBean(pageMap.getPage(), pageMap.getPageSize(), total, list);
    }

    @Override
    public int saveOil(Map map) {
        return oilDao.saveOil(map);
    }

    @Override
    public int updateOil(Map map) {
        return oilDao.updateOil(map);
    }



}
