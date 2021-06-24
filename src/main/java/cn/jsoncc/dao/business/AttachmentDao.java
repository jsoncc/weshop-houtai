package cn.jsoncc.dao.business;

import cn.jsoncc.bean.Attachment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/23 20:43
 * Email:896415482@qq.com
 */
@Mapper
public interface AttachmentDao {
    //批量保存图片
    public int saveBatchAttachment(Map map);

    /**
     * 嵌套查询
     * @param oid
     * @return
     */
    public List<Attachment> queryAttachmentByOilId(String oid);
}
