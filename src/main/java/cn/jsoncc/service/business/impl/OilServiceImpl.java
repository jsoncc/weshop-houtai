package cn.jsoncc.service.business.impl;

import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.PageMap;
import cn.jsoncc.dao.business.AttachmentDao;
import cn.jsoncc.dao.business.OilDao;
import cn.jsoncc.service.business.OilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author: JsonCC
 * Date: 2021/6/16 16:33
 * Email:896415482@qq.com
 */
@Service("oilService")
public class OilServiceImpl implements OilService {

    @Autowired
    private OilDao oilDao;

    @Autowired
    private AttachmentDao attachmentDao;

    @Override
    public PageBean queryOil(Map map) {
        PageMap pageMap = new PageMap(map);
        List list = oilDao.queryOil(pageMap);
        int total = oilDao.queryOilCount(pageMap);
        return new PageBean(pageMap.getPage(), pageMap.getPageSize(), total, list);
    }

    @Override
    @Transactional
    public int saveOil(Map map) {
        //生成油站id
        String oid = UUID.randomUUID().toString();
        map.put("id", oid);
        //保存油站
        int rs = oilDao.saveOil(map);

        List list = (ArrayList)map.get("pics");
        //批量保存附件
        if (list!=null && list.size()>0){
            rs =attachmentDao.saveBatchAttachment(map);
        }
        return rs;
    }

    @Override
    @Transactional
    public int updateOil(Map map) {
        List list = (ArrayList)map.get("pics");
        int rs = oilDao.updateOil(map);
        //批量保存附件
        if (list!=null && list.size()>0){
            rs =attachmentDao.saveBatchAttachment(map);
        }
        return rs;
    }


}
