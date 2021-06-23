package cn.jsoncc.dao.business;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/23 20:43
 * Email:896415482@qq.com
 */
@Mapper
public interface AttachmentDao {
    public int saveBatchAttachment(Map map);
}
