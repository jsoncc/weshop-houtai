package cn.jsoncc.service.business;

import cn.jsoncc.common.bean.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/16 16:33
 * Email:896415482@qq.com
 */
public interface OilService {
    public PageBean queryOil(Map map);

    /**
     * 保存油站
     * @param map
     * @return
     */
    public int saveOil(Map map);

    public int updateOil(Map map);

//    int deleteOil(String id);
}
