package cn.jsoncc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Author: JsonCC
 * Date: 2021/6/24 11:28
 * Email:896415482@qq.com
 */
@Data
public class Oil {
    private String id;
    private String oil_name;
    private String address;
    private String longitude;
    private String latitude;
    private String discount;
    private String explains;
    private String adddate;

    private int status;
    private List<Attachment> attachments;

}
