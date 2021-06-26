
package cn.jsoncc.service.sys;
import java.util.List;
import java.util.Map;


public interface DictService {
    public int save(Map map);

    public List queryChildDictByParentId(String pid);
}
