package cn.jsoncc.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Author: JsonCC
 * Date: 2021/7/14 11:35
 * Email:896415482@qq.com
 */
@Data
public class Goods {
    private String id;

    //不能重复功能没有实现
//    @NotEmpty(message = "商品名称不能重复")
    private String goodsname;

    private String cid;
    private String unit;
    private String normal_price;
    private String cf_price;
    private int nums;
    private String note;
    private String desc;
    private int isdel;
    private int status;


}
