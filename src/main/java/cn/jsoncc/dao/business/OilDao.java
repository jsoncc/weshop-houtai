package cn.jsoncc.dao.business;

import cn.jsoncc.common.bean.PageMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/16 16:36
 * Email:896415482@qq.com
 */
@Mapper
public interface OilDao {
    public int updatebalance(Map map);

    public int saveOil(Map map);

    public int updateOil(Map map);


    /**
     * 查询分页的结果集
     *
     * @param pageMap
     * @return
     */
    public List<Map> queryOil(PageMap pageMap);

    /**
     * 总记录数
     *
     * @param pageMap
     * @return
     */
    public int queryOilCount(PageMap pageMap);



}