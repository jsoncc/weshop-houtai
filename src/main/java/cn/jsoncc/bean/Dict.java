package cn.jsoncc.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Author: JsonCC
 * Date: 2021/6/29 15:10
 * Email:896415482@qq.com
 */
@Data
public class Dict {
    private String id;

    @NotNull(message = "必须传递编码值")
    private String dictcode;

    private String dictname;
    private String dictvalue;
    private int sorts;
    private String note;
    private String parentId;

}
