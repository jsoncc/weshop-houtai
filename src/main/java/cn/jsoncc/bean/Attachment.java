package cn.jsoncc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: JsonCC
 * Date: 2021/6/24 11:42
 * Email:896415482@qq.com
 */
@Data
public class Attachment {
    private String id;
    private String name;
    private String attType;
    private String attUrl;
    private String attMiniUrl;
    private String uploadTime;
    private int isdefault;
    private String businessId;
    private int businessType;
}
