
package cn.jsoncc.dao.sys;

import cn.jsoncc.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface DictDao extends BaseDao<Map> {

    public List<Map> queryChildDictByParentId(String pid);

    public int deleteByParentId(String pid);
}
