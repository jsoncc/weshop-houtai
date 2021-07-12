package cn.jsoncc.dto;

/**
 * Author: JsonCC
 * Date: 2021/7/12 11:51
 * Email:896415482@qq.com
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ContentCategoryDTO", description = "分类对象DTO")
public class ContentCategoryDTO implements Serializable {

    @ApiModelProperty(value = "父类目ID=0时，代表的是一级的类目")
    private Long parentId;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "状态。可选值:1(正常),2(删除)")
    private Integer status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    @ApiModelProperty(value = "排列序号")
    private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    @ApiModelProperty(value = "该类目是否为父类目，1为true，0为false")
    private Boolean isParent;
}
