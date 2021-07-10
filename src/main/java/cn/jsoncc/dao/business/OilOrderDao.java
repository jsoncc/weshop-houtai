package cn.jsoncc.dao.business;

import cn.jsoncc.bean.OilOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: JsonCC
 * Date: 2021/7/9 14:29
 * Email:896415482@qq.com
 */
@Mapper
public interface OilOrderDao {
    public int save(OilOrder oilOrder);

    public String queryMaxOilOrderNum();
}
