
package cn.jsoncc.service.sys.impl;
import cn.jsoncc.dao.sys.DictDao;
import cn.jsoncc.service.sys.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
