package cn.jsoncc.dao.business;

import cn.jsoncc.bean.OilOrder;
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
    /**
     * 修改充值的
     * @param map
     * @return
     */
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

    /**
     * 查询油站油卡余额
     * @param id
     * @return
     */
    public double queryOilOrderBalance(String id);

    /**
     * 更新油站油卡余额
     * @param oilOrder
     * @return
     */
    public int updateOilOrderBalance(OilOrder oilOrder);
}