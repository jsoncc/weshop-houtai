package cn.jsoncc.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: JsonCC
 * Date: 2021/7/9 14:18
 * Email:896415482@qq.com
 */
@Data
public class OilOrder {

    @NotBlank(message="油站ID不能为空")
    private String oilid;

    @NotBlank(message = "油站名称不能为空")
    private String oilname;

    @NotBlank(message = "汽油种类不能为空")
    private String oiltype;

    @NotBlank(message = "车辆ID不能为空")
    private String cid;
    @NotBlank(message = "车牌号不能为空")

    private String carnum;
    private double payment;
    private double pay;
    private String mid;
    private String ordernum;
    private double normal_price;
    private double price;
    private String prepay_id;


}
