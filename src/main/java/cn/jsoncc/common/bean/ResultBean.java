package cn.jsoncc.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: JsonCC
 * Date: 2021/6/16 17:17
 * Email:896415482@qq.com
 */
@Data
@AllArgsConstructor
public class ResultBean {

    //
    private int code;

    //
    private String msg;

    //
    private Object data;


}
