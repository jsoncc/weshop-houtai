package cn.jsoncc.bean;

import lombok.Data;

/**
 * Author: JsonCC
 * Date: 2021/7/14 11:35
 * Email:896415482@qq.com
 */
@Data
public class Goods {
    private String id;
    private String goodsname;
    private String cid;
    private String unit;
    private String normal_price;
    private String cf_price;
    private int nums;
    private String note;
    private String desc;
    private int isdel;

}
