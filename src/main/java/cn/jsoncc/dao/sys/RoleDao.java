package cn.jsoncc.dao.sys;

import cn.jsoncc.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/8 9:45
 * Email:896415482@qq.com
 */

/**
 * 参数类型就是map，  因为bean中没有RoleDao
 */
@Mapper
public interface RoleDao extends BaseDao<Map> {
}
