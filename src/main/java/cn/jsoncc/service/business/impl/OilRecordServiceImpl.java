package cn.jsoncc.service.business.impl;

import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.PageMap;
import cn.jsoncc.dao.business.OilDao;
import cn.jsoncc.dao.business.OilRecordDao;
import cn.jsoncc.service.business.OilRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/26 10:32
 * Email:896415482@qq.com
 */
@Service("oilRecordService")
public class OilRecordServiceImpl implements OilRecordService {

    @Autowired
    OilDao oilDao;

    @Autowired
    OilRecordDao oilRecordDao;

    @Override
    @Transactional
    public int save(Map map) {
        oilDao.updatebalance(map);
        return oilRecordDao.save(map);
    }

    @Override
    public PageBean query(Map map) {
        PageMap pageMap = new PageMap(map);
        List list = oilRecordDao.queryResultByPage(pageMap);
        int total = oilRecordDao.queryCount(pageMap);
        PageBean pageBean = new PageBean(pageMap.getPage(), pageMap.getPageSize(), total, list);
        return pageBean;
    }

}
