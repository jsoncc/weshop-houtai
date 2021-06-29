
package cn.jsoncc.service.sys;
import java.util.List;
import java.util.Map;


public interface DictService {
    public int save(Map map);

    public List queryChildDictByParentId(String pid);

    // 删除字典tab及其子项数据
    public int deleteDictTabAll(String id);

    public int update(Map map);

    public int checkcode(Map map);
}
