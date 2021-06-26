package cn.jsoncc.service.business;

import cn.jsoncc.common.bean.PageBean;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/26 10:30
 * Email:896415482@qq.com
 */
public interface OilRecordService {
    public int save(Map map);
    public PageBean query(Map map);
}
