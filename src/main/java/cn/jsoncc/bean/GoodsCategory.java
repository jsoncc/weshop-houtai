package cn.jsoncc.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Author: JsonCC
 * Date: 2021/7/16 16:58
 * Email:896415482@qq.com
 */
@Data
public class GoodsCategory {
    private String id;

    @NotNull(message = "必须传递编码值")
    private String categorycode;

    private String categoryname;
    private String parentId;
}
