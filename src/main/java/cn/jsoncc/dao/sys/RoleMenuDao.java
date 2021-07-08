package cn.jsoncc.dao.sys;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/8 15:06
 * Email:896415482@qq.com
 */
@Mapper
public interface RoleMenuDao {
    public int saveBatchRoleMenu(Map map);
}
