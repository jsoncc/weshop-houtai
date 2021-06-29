
package cn.jsoncc.service.sys.impl;
import cn.jsoncc.dao.sys.DictDao;
import cn.jsoncc.service.sys.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("dictService")
public class DictServiceImpl  implements DictService {

    @Autowired
    DictDao dictDao;

    @Override
    public int save(Map map) {
        return dictDao.save(map);
    }

    @Override
    public List queryChildDictByParentId(String pid) {
        return dictDao.queryChildDictByParentId(pid);
    }

    @Transactional
    @Override
    public int deleteDictTabAll(String id) {
        Map map = new HashMap();
        map.put("isdel","1");
        map.put("id",id);
        //1.先删除字典的子项数据
        int rs= dictDao.deleteByParentId(id);
        //2.再删除字典自身
        rs = dictDao.update(map);

        return rs;
    }

    @Override
    public int update(Map map) {
        return dictDao.update(map);
    }

    @Override
    public int checkcode(Map map) {
        return dictDao.queryDictCodeOnly(map);
    }
}
